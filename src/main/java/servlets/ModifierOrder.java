package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.Dao;
import dao.DaoException;
import dao.DaoFactory;



import modele.Client;
import modele.Order;
import validation.OrderValidator;


@WebServlet("/modifierOrder")
public class ModifierOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Dao<Order> orderDao;

	private Dao<Client> clientDao;

	public ModifierOrder() {
		super();
		orderDao = DaoFactory.getInstance().getOrderDao();
		clientDao = DaoFactory.getInstance().getClientDao();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		long id = Long.parseLong(request.getParameter("id"));

		try {
			request.setAttribute("clients", clientDao.lister());
			request.setAttribute("order", orderDao.trouver(id));

		} catch (DaoException e) {
			e.printStackTrace();
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/modifierOrder.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		var validator = new OrderValidator();
		
		String typePresta = request.getParameter("typePresta");
		validator.validateTypePresta(typePresta);
		
		String designation = request.getParameter("designation");
		validator.validateDesignation(designation);
		
	    String nbDaysStr = request.getParameter("nbDays");
	    validator.validateNbDays(nbDaysStr);
	    
	    String unitPriceStr = request.getParameter("unitPrice");
	    validator.validateUnitPrice(unitPriceStr);
	    
	    String stateStr = request.getParameter("state");
	    validator.validateStateOrder(stateStr);
	    
	    long clientId = Long.parseLong(request.getParameter("clientId"));

	    var erreurs = validator.getErrors();
	    
	    Long state;
	    
	    if(!erreurs.containsKey("state")) {
			state = Long.parseLong(stateStr);
		} else {
			state = -1L;
		}
		
		Long nbDays;
		
		if(!erreurs.containsKey("nbDays")) {
			nbDays = Long.parseLong(nbDaysStr);
		} else {
			nbDays = -1L;
		}
		
		Float unitPrice;
		
		if(!erreurs.containsKey("unitPrice")) {
			unitPrice = Float.parseFloat(unitPriceStr);
		} else {
			unitPrice = -1f;
		}
		
		var idStr = request.getParameter("id");
		var id = Long.parseLong(idStr);
	   
			try
			{
				Order order = orderDao.trouver(id);
		    	Client client= clientDao.trouver(clientId);
				
				order.setClient(client);		
				order.setTypePresta(typePresta);
		        order.setDesignation(designation);
		        order.setNbDays(nbDays);
		        order.setUnitPrice(unitPrice);
		        order.setState(state);
		        
		        if(erreurs.isEmpty()) 
		        {
		        	try
		        	{
		        		orderDao.update(order);
		        	}
		        	catch (DaoException e) 
		        	{
    				e.printStackTrace();
		        	}
			
		        response.sendRedirect(request.getContextPath()+"/listeOrders");
		        } 
		        else 
		        {
		        	request.setAttribute("order", order);
		        	request.setAttribute("erreurs", erreurs);
		        	request.setAttribute("resultat", "Echec de la sauvegarde de la commande.");

		        	try 
		        	{
		    			request.setAttribute("clients", clientDao.lister());
		    			request.setAttribute("order", orderDao.trouver(order.getId()));

		    		} 
		        	catch (DaoException e) 
		        	{
		    			e.printStackTrace();
		    		}
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/modifierOrder.jsp").forward(request, response);

		        }
			}
		        catch (DaoException e) 
		        {
		        	e.printStackTrace();
		        }
	}
}

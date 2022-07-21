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


@WebServlet("/ajouterOrder")
public class AjouterOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Dao<Client> clientDao;
	private Dao<Order> orderDao;

    public AjouterOrder() {
        super();
        clientDao = DaoFactory.getInstance().getClientDao();
        orderDao = DaoFactory.getInstance().getOrderDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try
		{
			request.setAttribute("clients", clientDao.lister());
		}
		catch (DaoException e)
        {
            e.printStackTrace();
        }
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterOrder.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String typePresta=request.getParameter("typePresta");
		var validator = new OrderValidator();
		validator.validateTypePresta(typePresta);
		
		String designation = request.getParameter("designation");
		validator.validateDesignation(designation);
		
		String nbDaysStr = request.getParameter("nbDays");
		validator.validateNbDays(nbDaysStr);
		
		String unitPriceStr = request.getParameter("unitPrice");
		validator.validateUnitPrice(unitPriceStr);
		
		Long state;
        String stateStr=request.getParameter("state");
		validator.validateStateOrder(stateStr);
		var erreurs = validator.getErrors();
		if(!erreurs.containsKey("state")) {
			state = Long.parseLong(stateStr);
		} else {
			state = -1L;
		}
		
		long nbDays;;
		if(!erreurs.containsKey("nbDays")) {
			nbDays = Long.parseLong(nbDaysStr);
		} else {
			nbDays = -1L;
		}
		
		float unitPrice;
		if(!erreurs.containsKey("unitPrice")) {
			unitPrice = Float.parseFloat(unitPriceStr);
		} else {
			unitPrice = -1f;
		}

		
		Client client = null;
		Order order = new Order ();
		
		
		long clientId = Long.parseLong(request.getParameter("clientId"));
		
		 
			try {
				client = clientDao.trouver(clientId);
				
				order.setClient(client);
				
			} catch (DaoException e) {
	            erreurs.put("clientId", "Le client n'existe pas." );
	        }
			
			order.setTypePresta(typePresta);
			order.setDesignation(designation);
			order.setNbDays(nbDays);
			order.setUnitPrice(unitPrice);
			order.setState(state);
			
		if(erreurs.isEmpty()) {
			try{
				orderDao.creer(order);
			} catch (DaoException e) {
	            e.printStackTrace();
	        }
			
	        response.sendRedirect(request.getContextPath()+"/listeOrders");

		} else {
			request.setAttribute("order", order);
			request.setAttribute("erreurs", erreurs);
			request.setAttribute("resultat", "Echec de la sauvegarde de la commande.");
			
			
			try
			{
				request.setAttribute("clients", clientDao.lister());
			}
			catch (DaoException e)
	        {
	            e.printStackTrace();
	        }
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterOrder.jsp").forward(request, response);

		}
		

		
	}

}

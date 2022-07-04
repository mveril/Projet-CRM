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
		
		Long id = Long.parseLong(request.getParameter("id"));
		
		String typePresta = request.getParameter("typePresta");
		String designation = request.getParameter("designation");
	    int nbDays = Integer.parseInt(request.getParameter("nbDays"));
	    Float unitPrice = Float.parseFloat(request.getParameter("unitPrice"));
	    long state = Long.parseLong(request.getParameter("state"));
	    long clientId = Long.parseLong(request.getParameter("clientId"));

	    
	    try {
	    	Order order = orderDao.trouver(id);
	    	Client client= clientDao.trouver(clientId);
			
			order.setClient(client);		
			order.setTypePresta(typePresta);
	        order.setDesignation(designation);
	        order.setNbDays(nbDays);
	        order.setUnitPrice(unitPrice);
	        order.setState(state);

	        orderDao.update(order);
	        
		} catch (DaoException e1) {
			e1.printStackTrace();
		}   
        
        response.sendRedirect(request.getContextPath()+ "/listeOrders");
		
		
		
	}

}

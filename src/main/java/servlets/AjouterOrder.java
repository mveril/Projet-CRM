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
	
		Client client = null;
		
		Order order = new Order ();
		
		long idClient = Long.parseLong(request.getParameter("idClient"));
		String typePresta = request.getParameter("typePresta");
		String designation = request.getParameter("designation");
		long nbDays = Long.parseLong(request.getParameter("nbDays"));
		float unitPrice = Float.parseFloat(request.getParameter("unitPrice"));
		long state = Long.parseLong(request.getParameter("state"));
		
		try
		{
			client = clientDao.trouver(idClient);
			
			order.setClient(client);
			order.setTypePresta(typePresta);
			order.setDesignation(designation);
			order.setNbDays(nbDays);
			order.setUnitPrice(unitPrice);
			order.setState(state);
			
			orderDao.creer(order);
		}
		catch (DaoException e)
        {
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath()+"/listeOrders");
		
	}

}

package servlets;

import java.io.IOException;
import java.util.List;

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


@WebServlet("/listeOrders")
public class ListeOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Dao<Order> orderDao;
    public ListeOrders() {
        super();
        orderDao = DaoFactory.getInstance().getOrderDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try
		{
			List<Order> orders=null;

			orders = orderDao.lister();

			request.setAttribute("orders", orderDao.lister());
		}
		catch (DaoException e)
		{
			e.printStackTrace();
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/listeOrders.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

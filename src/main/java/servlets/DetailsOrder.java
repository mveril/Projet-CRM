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


@WebServlet("/detailsOrder")
public class DetailsOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Dao<Order> orderDao;
   
    public DetailsOrder() {
    	super();
    	orderDao = DaoFactory.getInstance().getOrderDao();
    	  
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long id = Long.parseLong(request.getParameter("id"));
		
		try {
			Order orderRecherche = orderDao.trouver(id);
			request.setAttribute("order", orderRecherche);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/detailsOrder.jsp").forward(request, response);
		
	}

	

}

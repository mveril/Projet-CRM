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
import modele.Order;


@WebServlet("/supprimerCommandes")
public class SupprimerCommandes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Dao<Order> orderDao;

    public SupprimerCommandes() {
        super();
        orderDao = DaoFactory.getInstance().getOrderDao();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		var id = Long.parseLong(request.getParameter("id"));
		
		try
		{
			orderDao.supprimer(id);
		}
		
		catch (DaoException e) 
		{
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath()+"/listeCommandes");
	}
}

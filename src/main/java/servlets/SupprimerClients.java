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


@WebServlet("/supprimerClient")
public class SupprimerClients extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private Dao<Client> clientDao;
	
	public SupprimerClients() {
        super();
        clientDao = DaoFactory.getInstance().getClientDao();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		var id = Long.parseLong(request.getParameter("id"));
	
	try
	{
		clientDao.supprimer(id);
	}
	
	catch (DaoException e) 
	{
		e.printStackTrace();
	}
	
	response.sendRedirect(request.getContextPath()+"/listeClients");

	}
}

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


@WebServlet("/listeClients")
public class ListeClients extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao<Client> clientDao;
   
    public ListeClients() {
        super();
        clientDao=DaoFactory.getInstance().getClientDao();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try 
		{
			List<Client> clients=null;
			
			clients = clientDao.lister();
			
			request.setAttribute("clients", clientDao.lister());
		} 
		catch (DaoException e) 
		{
			e.printStackTrace();
		}
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/ListeClients.jsp").forward(request, response);
	}

	

}
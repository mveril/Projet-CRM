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


@WebServlet("/detailsClient")
public class DetailsClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Dao<Client> clientDao;
  
    public DetailsClient() {
        super();
        clientDao = DaoFactory.getInstance().getClientDao();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long id = Long.parseLong(request.getParameter("id"));
		
		try {
			Client clientRecherche = clientDao.trouver(id);
			request.setAttribute("client", clientRecherche);
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/detailsClient.jsp").forward(request, response);

		
	}




}

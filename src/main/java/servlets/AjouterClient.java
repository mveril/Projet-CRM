package servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import dao.DaoException;
import dao.DaoFactory;
import modele.Client;
import validation.ClientValidator;


/**
 * Servlet implementation class AjouterClient
 */
@WebServlet("/ajouterClient")
public class AjouterClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     * 
     
     */
	
	private Dao<Client> clientDao;
	   
    public AjouterClient() {
        super();
        clientDao=DaoFactory.getInstance().getClientDao();
    }
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterClient.jsp").forward(request, response);
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String companyName=request.getParameter("companyName");
		var validator = new ClientValidator();
		validator.validateCompanyName(companyName);
		String firstName=request.getParameter("firstName");
		validator.validateFirstName(firstName);
		String lastName=request.getParameter("lastName");
		validator.validateLastName(lastName);
        String email=request.getParameter("email");
		validator.validateEmail(email);
        String phone=request.getParameter("phone");
		validator.validatePhone(phone);
        String address=request.getParameter("address");
		validator.validateAdress(address);
        String zipCode=request.getParameter("zipCode");
		validator.validateZipCode(zipCode);
        String city=request.getParameter("city");
		validator.validateCity(city);
        String country=request.getParameter("country");
		validator.validateCity(country);
		Long state = (long)-1;
        String stateStr=request.getParameter("state");
		validator.validateState("state");
		var erreurs = validator.getErrors();
		if(!erreurs.containsKey("state")) {
			state = Long.parseLong(stateStr);
		}
        
		
		
		
        Client client= new Client();
        
        client.setCompany(companyName);
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setEmail(email);
        client.setPhone(phone);
        client.setAddress(address);
        client.setZipCode(zipCode);
        client.setCity(city);
        client.setCountry(country);
        client.setState(state);
        
		if(erreurs.isEmpty()) {
			try {
				clientDao.creer(client);
			} catch (DaoException e) {
				e.printStackTrace();
			}
			
			response.sendRedirect( request.getContextPath() + "/listeClients" );
		} else {
			request.setAttribute("client", client);
			request.setAttribute("erreurs", erreurs);
			request.setAttribute("resultat", "Echec de la sauvegarde de du client.");
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterClient.jsp").forward(request, response);
		}
	}
}
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
		
		Map<String,String> erreurs = new HashMap<String,String>();
		String companyName=request.getParameter("companyName");
		var erreur = ClientValidator.validateCompanyName(companyName);
		if(erreur != null) {
			erreurs.put("companyName", erreur);
		}
		String firstName=request.getParameter("firstName");
		erreur = ClientValidator.validateFirstName(firstName);
		if(erreur != null) {
			erreurs.put("companyName", erreur);
		}
		String lastName=request.getParameter("lastName");
		erreur = ClientValidator.validateLastName(lastName);
		if(erreur != null) {
			erreurs.put("lastName", erreur);
		}
        String email=request.getParameter("email");
		erreur = ClientValidator.validateEmail(email);
		if(erreur != null) {
			erreurs.put("email", erreur);
		}
        String phone=request.getParameter("phone");
		erreur = ClientValidator.validatePhone(phone);
		if(erreur != null) {
			erreurs.put("phone", erreur);
		}
        String address=request.getParameter("address");
		erreur = ClientValidator.validateAdress(address);
		if(erreur != null) {
			erreurs.put("address", erreur);
		}
        String zipCode=request.getParameter("zipCode");
		erreur = ClientValidator.validateZipCode(zipCode);
		if(erreur != null) {
			erreurs.put("zipCode", erreur);
		}
        String city=request.getParameter("city");
		erreur = ClientValidator.validateCity(city);
		if(erreur != null) {
			erreurs.put("city", erreur);
		}
        String country=request.getParameter("country");
		erreur = ClientValidator.validateCity(country);
		if(erreur != null) {
			erreurs.put("country", erreur);
		}
		Long state = (long)-1;
        String stateStr=request.getParameter("state");
		erreur = ClientValidator.validateState("state");
		if(erreur != null) {
			erreurs.put("state", erreur);
		} else {
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
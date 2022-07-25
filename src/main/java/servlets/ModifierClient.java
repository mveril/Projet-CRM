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
import validation.ClientValidator;


/**
 * Servlet implementation class ModifierClient
 */
@WebServlet("/modifierClient")
public class ModifierClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    private Dao<Client> clientDao;
	
    
    public ModifierClient() {
        super();
       clientDao=DaoFactory.getInstance().getClientDao();
       
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 long id = Long.parseLong(request.getParameter("id"));
			
			try {
				request.setAttribute("client", clientDao.trouver(id));
			} catch (DaoException e) {
				e.printStackTrace();
			}		
			this.getServletContext().getRequestDispatcher("/WEB-INF/modifierClient.jsp").forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var validator = new ClientValidator();
		
		String companyName=request.getParameter("companyName");
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
        validator.validateAddress(address);
        
        String zipcode=request.getParameter("zipCode");
        validator.validateZipCode(zipcode);
        
        String city=request.getParameter("city");
        validator.validateCity(city);
        
        String country=request.getParameter("country");
        validator.validateCountry(country);
        
        String stateStr=request.getParameter("state");
        validator.validateState(stateStr);
        
        var erreurs = validator.getErrors();
        Long state;
        
        if(!erreurs.containsKey("state")) {
			state = Long.parseLong(stateStr);
		} else {
			state = -1L;
		}
      
        var clientIdStr = request.getParameter("id");
	    var clientId = Long.parseLong(clientIdStr);

	    try
	    {
	    	Client client= clientDao.trouver(clientId);
	
        	client.setCompany(companyName);
            client.setFirstName(firstName);
            client.setLastName(lastName);
            client.setEmail(email);
            client.setPhone(phone);
            client.setAddress(address);
            client.setZipCode(zipcode);
            client.setCity(city);
            client.setCountry(country);
            client.setState(state);
            
            
        	
            if(erreurs.isEmpty()) {
    			try 
    			{
    				clientDao.update(client);
    			} catch (DaoException e) 
    			{
    				e.printStackTrace();
    			}
    			
    			response.sendRedirect( request.getContextPath() + "/listeClients" );
    		} else {
    			request.setAttribute("client", client);
    			request.setAttribute("erreurs", erreurs);
    			request.setAttribute("resultat", "Echec de la sauvegarde de du client.");
    			
    			try 
    			{
    				request.setAttribute("client", clientDao.trouver(client.getId()));
    			} 
    			catch (DaoException e) 
    			{
    				e.printStackTrace();
    			}		
    			
    			this.getServletContext().getRequestDispatcher("/WEB-INF/modifierClient.jsp").forward(request, response);
    		}			
	    }
	    catch (DaoException e) 
		{
			e.printStackTrace();
		}
	    
     }
}


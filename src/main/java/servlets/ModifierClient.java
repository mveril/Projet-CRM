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
		
		String companyName=request.getParameter("companyName");
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
        String email=request.getParameter("email");
        String phone=request.getParameter("phone");
        String address=request.getParameter("address");
        String zipcode=request.getParameter("zipCode");
        String city=request.getParameter("city");
        String country=request.getParameter("country");
        
        String stateStr=request.getParameter("state");
        var state = Long.parseLong(stateStr);
      
        var clientIdStr = request.getParameter("id");
	    var clientId = Long.parseLong(clientIdStr);
        
        try {
        	
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
        	
           	
            clientDao.update(client);
			
			
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        response.sendRedirect(request.getContextPath()+ "/listeClients");
        				
	}

}

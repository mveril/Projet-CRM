package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import model.Client;

public class ClientDaoImpl implements ClientDao {
	
	private static final String SQL_INSERT       = "INSERT INTO client(companyName,firstName,lastName,email,phone,address,zipCode,city,	country,state) VALUES(?,?,?,?,?,?,?,?,?,?)";
	private static final String SQL_SELECT       = "SELECT id,companyName,firstName,lastName,email,phone,address,zipCode,city,country,state FROM client";
    private static final String SQL_SELECT_BY_ID = "SELECT id,companyName,firstName,lastName,email,phone,address,zipCode,city,country,state WHERE id = ?";
	private static final String SQL_DELETE_BY_ID = "DELETE FROM client WHERE id = ? ";
	
	private static final String SQL_UPDATE = "UPDATE client SET companyName=?,firstName=?,lastName=?,email=?,phone=?,address=?,zipCode=?,country=?, state=? WHERE id=?";
	
	private DaoFactory factory;
	
	public ClientDaoImpl(DaoFactory factory) {
		this.factory = factory;
	}

	@Override
	public void creer(Client client) throws DaoException {
		Connection con=null;
		try {
			con = factory.getConnection();
			
			PreparedStatement pst = con.prepareStatement( SQL_INSERT, Statement.RETURN_GENERATED_KEYS );
			pst.setString( 1, client.getCompanyName());
			pst.setString( 2, client.getFirstName() );
			pst.setString( 3, client.getLastName() );
			pst.setString( 4, client.getPhone() );
			pst.setString( 5, client.getAdresse() );
			pst.setString( 6, client.getZipCode() );
			pst.setString( 7, client.getCity());
			pst.setString( 8, client.getCountry());
			pst.setLong( 9, client.getState());
			
			int statut = pst.executeUpdate();

            if ( statut == 0 ) {
                throw new DaoException( "Echec cr�ation Client (aucun ajout)" );
            }
            ResultSet rsKeys = pst.getGeneratedKeys();
            if ( rsKeys.next() ) {
                client.setId( rsKeys.getLong( 1 ) );
            } else {
                throw new DaoException( "Echec cr�ation Client (ID non retourn�)" );
            }
            rsKeys.close();
			pst.close();
			
	    } catch(SQLException ex) {
	    	throw new DaoException("Echec creation Client",ex);
	    } finally {
	    	factory.releaseConnection(con);
		}
		
	}
	
	
	@Override
	public void update(Client client) throws DaoException {
		Connection con=null;
		try {
			con = factory.getConnection();
			
			PreparedStatement pst = con.prepareStatement( SQL_UPDATE );
			pst.setString( 1, client.getCompanyName());
			pst.setString( 2, client.getFirstName() );
			pst.setString( 3, client.getLastName() );
			pst.setString( 4, client.getPhone() );
			pst.setString( 5, client.getAdresse() );
			pst.setString( 6, client.getZipCode() );
			pst.setString( 7, client.getCity());
			pst.setString( 8, client.getCountry());
			pst.setLong( 9, client.getState());
			pst.setLong( 10, client.getId() );

			int statut = pst.executeUpdate();

            if ( statut == 0 ) {
                throw new DaoException( "Echec modification client" );
            }
			pst.close();
			
	    } catch(SQLException ex) {
	    	throw new DaoException("Echec m client",ex);
	    } finally {
	    	factory.releaseConnection(con);
		}
	}


	@Override
	public Client trouver(long id) throws DaoException {
		Client            client=null;
		Connection        con=null;
		PreparedStatement pst=null;
		ResultSet         rs=null;
		try {
			  con = factory.getConnection();
			  pst = con.prepareStatement( SQL_SELECT_BY_ID );
			  pst.setLong(1, id);
		      rs  = pst.executeQuery();
		      if ( rs.next() ) {
		    	  client = map(rs);
		      }
		      rs.close();
		      pst.close();
	    } catch(SQLException ex) {
	    	throw new DaoException("Erreur de recherche BDD client", ex);
	    } finally {
	    	factory.releaseConnection(con);
		}
		return client;
	}

	@Override
	public List<Client> lister() throws DaoException {
		List<Client> listeClients = new ArrayList<Client>();
		Connection   con=null;
		try {
			  con = factory.getConnection();
			  PreparedStatement pst = con.prepareStatement( SQL_SELECT );
		      ResultSet         rs  = pst.executeQuery();
		      while ( rs.next() ) {
		    	  listeClients.add( map(rs) );
		      }
		      rs.close();
		      pst.close();
	    } catch(SQLException ex) {
	    	throw new DaoException("Erreur de lecture BDD client", ex);
	    } finally {
	    	factory.releaseConnection(con);
		}
		return listeClients;
	}

	@Override
	public void supprimer(long id) throws DaoException {
		Connection   con=null;
		try {
			  con = factory.getConnection();
			  PreparedStatement pst = con.prepareStatement( SQL_DELETE_BY_ID );
			  pst.setLong(1, id);
			  int statut = pst.executeUpdate();
			  if ( statut == 0 ) {
				  throw new DaoException("Erreur de suppression client("+id+")");
			  }
		      pst.close();
	    } catch(SQLException ex) {
	    	throw new DaoException("Erreur de suppression BDD client", ex);
	    } finally {
	    	factory.releaseConnection(con);
		}
		
	}
    /*
     * Mapping (correspondance) entre un ResultSet et un JavaBean
     * M�thode utilitaire (interne)
     */
    private static Client map( ResultSet resultSet ) throws SQLException {
        Client c = new Client();
        
        
        c.setCompany(resultSet.getString("companyName"));
		c.setFirstName(resultSet.getString("firstName") );
		c.setLastName(resultSet.getString("lastName"));
		c.setEmail(resultSet.getString("email") );
		c.setPhone(resultSet.getString("phone") );
		c.setAdresse(resultSet.getString("address") );
		c.setZipCode(resultSet.getString("zipCode"));
		c.setCity(resultSet.getString("City"));
		c.setCountry(resultSet.getString("country"));
		c.setId(resultSet.getLong("id") );
		c.setState(resultSet.getLong("state") );
		
       
        return c;
    }
    
 //   (companyName,firstName,lastName,email,phone,address,zipCode,city,	country,state)
    
   


    


}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modele.Order;

public class OrderDaoImpl implements OrderDao {
	
	private static final String SQL_INSERT       = "INSERT INTO Order(id_client, titre, nb_pages, categorie) VALUES(?,?,?,?)";
	private static final String SQL_SELECT       = "SELECT id, id_client, titre, nb_pages, categorie FROM Order";
    private static final String SQL_SELECT_BY_ID = "SELECT id, id_client, titre, nb_pages, categorie FROM Order WHERE id = ?";
	private static final String SQL_DELETE_BY_ID = "DELETE FROM Order WHERE id = ? ";
	
	private static final String SQL_UPDATE = "UPDATE Order SET id_client=?, titre=?, nb_pages=?, categorie=? WHERE id = ?";
	
	private DaoFactory factory;
	
	public OrderDaoImpl(DaoFactory factory) {
		this.factory = factory;
	}

	@Override
	public void creer(Order Order) throws DaoException {
		Connection con=null;
		try {
			con = factory.getConnection();
			
			PreparedStatement pst = con.prepareStatement( SQL_INSERT, Statement.RETURN_GENERATED_KEYS );

			pst.setLong( 1, Order.getClient().getId() );
			pst.setString( 2, Order.getDesignation());
			pst.setLong( 3, Order.getNbDays() );
			pst.setFloat( 4, Order.getUnitPrice());
			pst.setFloat( 5, Order.getTotalExcludeTaxe());
			pst.setFloat( 6, Order.getTotalExcludeTaxe());
			
			
			int statut = pst.executeUpdate();

            if ( statut == 0 ) {
                throw new DaoException( "Echec cr�ation Order (aucun ajout)" );
            }
            ResultSet rsKeys = pst.getGeneratedKeys();
            if ( rsKeys.next() ) {
                Order.setId( rsKeys.getLong( 1 ) );
            } else {
                throw new DaoException( "Echec cr�ation Order (ID non retourn�)" );
            }
            rsKeys.close();
			pst.close();
			
	    } catch(SQLException ex) {
	    	throw new DaoException("Echec cr�ation Order",ex);
	    } finally {
	    	factory.releaseConnection(con);
		}
		
	}

	@Override
	public Order trouver(long id) throws DaoException {
		Order            Order=null;
		Connection        con=null;
		PreparedStatement pst=null;
		ResultSet         rs=null;
		try {
			  con = factory.getConnection();
			  pst = con.prepareStatement( SQL_SELECT_BY_ID );
			  pst.setLong(1, id);
		      rs  = pst.executeQuery();
		      if ( rs.next() ) {
		    	  Order = map(rs);
		      }
		      rs.close();
		      pst.close();
	    } catch(SQLException ex) {
	    	throw new DaoException("Erreur de recherche BDD Order", ex);
	    } finally {
	    	factory.releaseConnection(con);
		}
		return Order;
	}

	@Override
	public List<Order> lister() throws DaoException {
		List<Order> listeOrders = new ArrayList<Order>();
		Connection   con=null;
		try {
			  con = factory.getConnection();
			  PreparedStatement pst = con.prepareStatement( SQL_SELECT );
		      ResultSet         rs  = pst.executeQuery();
		      while ( rs.next() ) {
	    	  	listeOrders.add( map(rs) );
		      }
		      rs.close();
		      pst.close();
	    } catch(SQLException ex) {
	    	throw new DaoException("Erreur de lecture BDD Order", ex);
	    } finally {
	    	factory.releaseConnection(con);
		}
		return listeOrders;
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
				  throw new DaoException("Erreur de suppression Order("+id+")");
			  }
		      pst.close();
	    } catch(SQLException ex) {
	    	throw new DaoException("Erreur de suppression BDD Order", ex);
	    } finally {
	    	factory.releaseConnection(con);
		}
		
	}
	

	@Override
	public void update(Order Order) throws DaoException {
		Connection con=null;
		try {
			con = factory.getConnection();
			
			PreparedStatement pst = con.prepareStatement( SQL_UPDATE );

			pst.setLong( 1, Order.getclient().getId() );
			pst.setString( 2, Order.getTitre());
			pst.setInt( 3, Order.getNbPages() );
			pst.setString( 4, Order.getCategorie());
			pst.setLong( 5, Order.getId() );
			
			int statut = pst.executeUpdate();

            if ( statut == 0 ) {
                throw new DaoException( "Echec mise � jour Order" );
            }
			pst.close();
			
	    } catch(SQLException ex) {
	    	throw new DaoException("Echec mise � jour Order",ex);
	    } finally {
	    	factory.releaseConnection(con);
		}
	}
	
    /*
     * Mapping (correspondance) entre un ResultSet et un JavaBean
     * M�thode utilitaire (interne)
     */
    private static Order map( ResultSet resultSet ) throws SQLException {
        Order l = new Order();
        l.setId( resultSet.getLong( "id" ) );
        
        ClientDao clientDao = DaoFactory.getInstance().getClientDao();
        try {
			l.setClient(clientDao.trouver(resultSet.getLong( "id_client" )));
		} catch (DaoException e) {
			e.printStackTrace();
		}
        
        l.setTitre(resultSet.getString( "titre" ));
        l.setNbPages(resultSet.getInt( "nb_pages" ));
        l.setCategorie(resultSet.getString( "categorie" ));
        return l;
    }

}

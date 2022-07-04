package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modele.Client;
import modele.Order;

public class OrderDaoImpl implements Dao<Order> {

	private static final String SQL_INSERT       = "INSERT INTO Orders(clientId, typePresta, designation, nbDays,unitPrice,state) VALUES(?,?,?,?,?,?)";


	private static final String SQL_SELECT       = "SELECT * FROM Orders";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM Orders WHERE id = ?";
	private static final String SQL_DELETE_BY_ID = "DELETE FROM Orders WHERE id = ? ";

	private static final String SQL_UPDATE = "UPDATE Orders SET clientId=?, typePresta=?, designation=?, nbDays=?, unitPrice=?, state=? WHERE id=?";

	private DaoFactory factory;

	public OrderDaoImpl(DaoFactory factory) {
		this.factory = factory;
	}

	@Override
	public void creer(Order order) throws DaoException {
		Connection con=null;
		try {
			con = factory.getConnection();

			PreparedStatement pst = con.prepareStatement( SQL_INSERT, Statement.RETURN_GENERATED_KEYS );

			pst.setLong( 1, order.getClient().getId() );
			pst.setString( 2, order.getTypePresta());
			pst.setString( 3, order.getDesignation() );
			pst.setLong( 4, order.getNbDays());
			pst.setFloat( 5, order.getUnitPrice());
			pst.setLong( 6, order.getState());


			int statut = pst.executeUpdate();

            if ( statut == 0 ) {
                throw new DaoException( "Echec création Order (aucun ajout)" );
            }
            ResultSet rsKeys = pst.getGeneratedKeys();
            if ( rsKeys.next() ) {
                order.setId( rsKeys.getLong( 1 ) );
            } else {
                throw new DaoException( "Echec création Order (ID non retourné)" );
            }
            rsKeys.close();
			pst.close();

	    } catch(SQLException ex) {
	    	throw new DaoException("Echec création Order",ex);
	    } finally {
	    	factory.releaseConnection(con);
		}

	}

	@Override
	public Order trouver(long id) throws DaoException {
		Order            order=null;
		Connection        con=null;
		PreparedStatement pst=null;
		ResultSet         rs=null;
		try {
			  con = factory.getConnection();
			  pst = con.prepareStatement( SQL_SELECT_BY_ID );
			  pst.setLong(1, id);
		      rs  = pst.executeQuery();
		      if ( rs.next() ) {
		    	  order = map(rs);
		      }
		      rs.close();
		      pst.close();
	    } catch(SQLException ex) {
	    	throw new DaoException("Erreur de recherche BDD Order", ex);
	    } finally {
	    	factory.releaseConnection(con);
		}
		return order;
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
	public void update(Order order) throws DaoException {
		Connection con=null;
		try {
			con = factory.getConnection();

			PreparedStatement pst = con.prepareStatement(SQL_UPDATE);
			
			pst.setLong(1, order.getClient().getId());
			pst.setString(2, order.getTypePresta());
			pst.setString(3, order.getDesignation());
			pst.setLong(4, order.getNbDays());
			pst.setFloat(5, order.getUnitPrice());
			pst.setLong(6, order.getState());
			
			pst.setLong(7, order.getId());
			
			int statut = pst.executeUpdate();
			
			if(statut == 0) {
				throw new DaoException("Echec mise à jour order");
			}
			
			pst.close();

	    } catch(SQLException ex) {
	    	throw new DaoException("Echec mise à jour Order",ex);
	    } finally {
	    	factory.releaseConnection(con);
		}
	}

    /*
     * Mapping (correspondance) entre un ResultSet et un JavaBean
     * M�thode utilitaire (interne)
     */
    private static Order map( ResultSet resultSet ) throws SQLException {
        Order o = new Order();
        o.setId( resultSet.getLong( "id" ) );

        Dao<Client> clientDao = DaoFactory.getInstance().getClientDao();
        try {
			o.setClient(clientDao.trouver(resultSet.getLong( "clientId" )));
		} catch (DaoException e) {
			e.printStackTrace();
		}

        o.setDesignation(resultSet.getString( "designation"));
        o.setTypePresta(resultSet.getString( "typePresta" ));
        o.setNbDays(resultSet.getInt( "nbDays" ));
        o.setState(resultSet.getLong( "state" ));
        o.setUnitPrice(resultSet.getFloat( "unitPrice" ));

        return o;
    }

}
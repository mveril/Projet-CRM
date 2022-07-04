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

	private static final String SQL_INSERT       = "INSERT INTO Orders(clientId, typePresta, designation, nbDays,unitPrice,state) VALUES(?,?,?,?,?,?,?)";


	private static final String SQL_SELECT       = "SELECT id, clientId, typePresta, designation, nbDays,unitPrice,state FROM Orders";
    private static final String SQL_SELECT_BY_ID = "SELECT id, clientId, typePresta, designation, nbDays,unitPrice,state FROM Orders WHERE id = ?";
	private static final String SQL_DELETE_BY_ID = "DELETE FROM Orders WHERE id = ? ";

	private static final String SQL_UPDATE = "UPDATE Orders SET clientId=?, typePresta=?, designation=?, nbDays=?,unitPrice=?,state=? WHERE id = ?";

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
		List<Order> listeOrders = new ArrayList<>();
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

			pst.setLong( 1, Order.getClient().getId() );
			pst.setString( 2, Order.getTypePresta());
			pst.setLong( 3, Order.getNbDays() );
			pst.setLong( 4, Order.getState());
			pst.setFloat( 5, Order.getUnitPrice());
			pst.setFloat( 6, Order.getUnitPrice());
			pst.setLong( 7, Order.getId() );

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
        Order o = new Order();
        o.setId( resultSet.getLong( "id" ) );

        Dao<Client> dao = DaoFactory.getInstance().getClientDao();
        try {
			o.setClient(dao.trouver(resultSet.getLong( "clientId" )));
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
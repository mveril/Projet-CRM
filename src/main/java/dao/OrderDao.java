package dao;

import java.util.List;

import model.Order;




public interface OrderDao {

	void         creer( Order Order ) throws DaoException;

	Order       trouver( long id ) throws DaoException;

    List<Order> lister() throws DaoException;

    void         supprimer( long id ) throws DaoException;
    
    void         update( Order order ) throws DaoException;

}

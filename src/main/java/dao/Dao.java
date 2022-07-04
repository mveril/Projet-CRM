package dao;

import java.util.List;




public interface Dao<T> {

	void         creer( T Order ) throws DaoException;

	T       trouver( long id ) throws DaoException;

    List<T> lister() throws DaoException;

    void         supprimer( long id ) throws DaoException;
    
    void         update( T order ) throws DaoException;

}

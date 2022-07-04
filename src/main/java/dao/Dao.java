package dao;

import java.util.List;




public interface Dao<T> {

	void         creer( T item ) throws DaoException;

	T       trouver( long id ) throws DaoException;

    List<T> lister() throws DaoException;

    void         supprimer( long id ) throws DaoException;
    
    void         update( T item ) throws DaoException;

}

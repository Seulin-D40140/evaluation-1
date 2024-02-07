package fr.fms.dao;

import java.sql.Connection;


public interface Dao<T>
{
	public Connection connection = BddConnection.getConnection(); // connection a la bdd
	public void create( T obj); // ajouter un article
	public String readOne(int id); // afficher 1 article 
	public void readAll(); // afficher tout les articles
	public void update ( T obj , int id); // mise a jour article
	public void delete(int id); // supprimer un article
}

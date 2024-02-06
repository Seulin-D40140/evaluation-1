package fr.fms.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BddConnection 
{
	static Connection getConnection() 
	{
		Properties prp = null;
		try 
		{
			prp = CreateConfigFile.readFile("configtext.txt");
		} 
		catch (IOException e) 
		{
			System.out.println(" erreur methode getconnection : lecture du fichier " + e );
			e.printStackTrace();
		}
		
		try 
		{
			Class.forName(prp.getProperty("db.driver.class"));
			Connection connection;
			try 
			{
				connection = DriverManager.getConnection(prp.getProperty("db.url") , prp.getProperty("db.login") , prp.getProperty("db.password"));
				return connection;
			} 
			catch (SQLException e) 
			{
				System.out.println(" erreur methode get connection : probleme autentification " + e );
				e.printStackTrace();
			}
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println(" erreur methode get connection " + e );
			e.printStackTrace();
		}
		return null;
	}
}
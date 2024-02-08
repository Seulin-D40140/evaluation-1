package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.entities.Stage;
import fr.fms.entities.User;

public class UserDao implements Dao<User>
{
	private ArrayList<User> users = new ArrayList<User>();

	@Override
	public void create(User obj) 
	{
		String str = "INSERT INTO T_Users ( Login , Password ) VALUES ( ? , ? );";
		
		try(PreparedStatement ps = connection.prepareStatement(str))
		{
			ps.setString(1, obj.getLogin());
			ps.setString(2, obj.getPassword());
			if( ps.executeUpdate() == 1)
			{
				System.out.println("insert add OK");
			}
			users.add(new User(obj.getLogin(), obj.getPassword()));
		}
		catch (Exception e) 
		{
			System.out.println(" erreur methode add stage " + e );
			e.printStackTrace();
		}
	}

	@Override
	public User readOne(int id) 
	{
		return null;
	}

	@Override
	public ArrayList<User> readAll() 
	{
		String strSql = "SELECT * FROM T_Users"; 
		
		try(Statement statement = connection.createStatement())
		{
			try(ResultSet resultSet = statement.executeQuery(strSql))
			{ 
				users.clear();
				while( resultSet.next())
				{
					int rsID = resultSet.getInt(1);
					String rslogin = resultSet.getString(2);
					String rspassword = resultSet.getString(3);
					
					users.add(new User(rsID , rslogin , rspassword));
				}
			}
		} 
		catch (Exception e) 
		{
			System.out.println(" erreur methode display article " + e );
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public void update(User obj, int id) 
	{
		String strSqlUpdt = "update T_Users set Login=? ,  Password=?  where idUser=?";
		
		try(PreparedStatement ps = connection.prepareStatement(strSqlUpdt))
		{
			ps.setString(1, obj.getLogin());
			ps.setString(2, obj.getPassword());
			ps.setDouble(3, obj.getIdUser());
			ps.setInt(4, id);
			
			if( ps.executeUpdate() == 1)
			{
				System.out.println("insert update OK");
			}
		}
		catch (Exception e) 
		{
			System.out.println(" erreur methode update article " + e );
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int idUser) 
	{
		String strSqlDel = "delete from T_Users where idUser= ? ";
		
		try(PreparedStatement ps = connection.prepareStatement(strSqlDel))
		{
			ps.setInt(1, idUser);
			
			if( ps.executeUpdate() == 1)
			{
				System.out.println("insert delete OK");
			}
		}
		catch (Exception e) 
		{
			System.out.println(" erreur methode remove article " + e );
			e.printStackTrace();
		}
	}
	


	
	
}

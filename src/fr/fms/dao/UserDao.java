package fr.fms.dao;

import java.sql.PreparedStatement;
import java.util.ArrayList;

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
	public void readAll() 
	{
		
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

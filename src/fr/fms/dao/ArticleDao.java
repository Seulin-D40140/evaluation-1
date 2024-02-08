package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.entities.*;

public class ArticleDao implements Dao<Stage>
{
	public ArrayList<Stage> stages = new ArrayList<Stage>();
	
	public void create(Stage obj)
	{
		String strSqlAdd = "INSERT INTO T_Stages (Name , Description , Duration , type , UnitaryPrice ) VALUES ( ? , ? , ? , ? , ? );";
		
		try(PreparedStatement ps = connection.prepareStatement(strSqlAdd))
		{
			ps.setString(1, obj.getName());
			ps.setString(2, obj.getDescription());
			ps.setInt(3, obj.getDuration());
			ps.setString(4, obj.getType());
			ps.setDouble(5, obj.getPrice());
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
	public Stage readOne(int idStage)
	{
		String strSqlAll = "select * from T_Stages where T_Stages.idStage = ? ";
		Stage stage = null;
		try(PreparedStatement statement = connection.prepareStatement(strSqlAll))
		{
			statement.setInt(1, idStage);
			try(ResultSet resultSet = statement.executeQuery())
			{ 
				while(resultSet.next())
				{
					stage = new Stage(resultSet.getInt(1), resultSet.getString(2), 
							resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5) , resultSet.getDouble(6));
				}
				
			}
			catch (Exception e) 
			{
				System.out.println(" erreur query dans la methode displayOne " + e );
				e.printStackTrace();
			}
		}
		catch (Exception e) 
		{
			System.out.println(" erreur methode displayOne article " + e );
			e.printStackTrace();
		}
		return stage;
	}
	
	public ArrayList<Stage> readAll() 
	{
		String strSql = "SELECT * FROM T_Stages"; 
		
		try(Statement statement = connection.createStatement())
		{
			try(ResultSet resultSet = statement.executeQuery(strSql))
			{ 
				stages.clear();
				while( resultSet.next())
				{
					int rsID = resultSet.getInt(1);
					String rsName = resultSet.getString(2);
					String rsDescription = resultSet.getString(3);
					int rsDuration = resultSet.getInt(4);
					String rsType= resultSet.getString(5);
					Double rsPrice = resultSet.getDouble(6);
					
					stages.add(new Stage(rsID , rsName , rsDescription , rsDuration , rsType , rsPrice));
				}
			}
		} 
		catch (Exception e) 
		{
			System.out.println(" erreur methode display article " + e );
			e.printStackTrace();
		}
		return stages;
	}

	@Override
	public void update(Stage obj, int id) 
	{
		String strSqlUpdt = "update T_Stages set Name=? , Description=? ,  Duration=?  , Type=? , UnitaryPrice=? where idStage=?";
		
		try(PreparedStatement ps = connection.prepareStatement(strSqlUpdt))
		{
			ps.setString(1, obj.getName());
			ps.setString(2, obj.getDescription());
			ps.setInt(3, obj.getDuration());
			ps.setString(4, obj.getType());
			ps.setDouble(5, obj.getPrice());
			ps.setInt(6, id);
			
			if( ps.executeUpdate() == 1)
			{
				System.out.println("insert update OK");
			}
		}
		catch (Exception e) 
		{
			System.out.println(" erreur methode update Stage " + e );
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int idStage) 
	{
		String strSqlDel = "delete from T_Stages where idStage= ? ";
		
		try(PreparedStatement ps = connection.prepareStatement(strSqlDel))
		{
			ps.setInt(1, idStage);
			
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



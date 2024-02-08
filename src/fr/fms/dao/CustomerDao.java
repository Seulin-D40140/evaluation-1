package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import fr.fms.entities.Customer;
import fr.fms.entities.Stage;

public class CustomerDao implements Dao<Customer>
{
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	
	@Override
	public void create(Customer obj) 
	{
		String str = "INSERT INTO T_Customerss ( Name , FirstName , Email , Phone , Adress ) VALUES ( ? , ? , ? , ? , ? );";
		
		try(PreparedStatement ps = connection.prepareStatement(str))
		{
			ps.setString(1, obj.getName());
			ps.setString(2, obj.getFirstName());
			ps.setString(3, obj.getEmail());
			ps.setInt(4, obj.getPhone());
			ps.setString(5, obj.getAddress());
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
	public Customer readOne(int iduser) 
	{
		String str = "select * from t_customers where idcustomer = ? ; ";
		Customer customer = null;
		try(PreparedStatement statement = connection.prepareStatement(str))
		{
			statement.setInt(1, iduser);
			try(ResultSet resultSet = statement.executeQuery())
			{ 
				while(resultSet.next())
				{
					customer = new Customer(resultSet.getString(2), resultSet.getString(3), 
							resultSet.getString(4), resultSet.getInt(5), resultSet.getString(6));
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
		return customer;
	}

	@Override
	public ArrayList<Customer> readAll() 
	{
		return null;
	}

	@Override
	public void update(Customer obj, int id) 
	{
		String strSqlUpdt = "update T_Customers set Name=? ,  FirstName=?  , Email=? , Phone=? , Adress=? where idCustomer=?";
		
		try(PreparedStatement ps = connection.prepareStatement(strSqlUpdt))
		{
			ps.setString(1, obj.getName());
			ps.setString(2, obj.getFirstName());
			ps.setString(3, obj.getEmail());
			ps.setInt(4, obj.getPhone());
			ps.setString(5, obj.getAddress());
			ps.setInt(6, id);
			
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
	public void delete(int id) 
	{
		
	}

}

package fr.fms.dao;

import java.awt.dnd.peer.DropTargetPeer;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import fr.fms.entities.Customer;

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
	public Customer readOne(int id) 
	{
		return null;
	}

	@Override
	public void readAll() 
	{
		
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

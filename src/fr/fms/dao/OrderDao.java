package fr.fms.dao;

import java.util.ArrayList;

import fr.fms.entities.Order;

public class OrderDao implements Dao<Order>
{
	ArrayList<Order> orders = new ArrayList<Order>();
	@Override
	public void create(Order obj) 
	{
		
	}

	@Override
	public Order readOne(int id) 
	{
		return null;
	}

	@Override
	public ArrayList<Order> readAll() 
	{
		return null;
	}

	@Override
	public void update(Order obj, int id) 
	{
		
	}

	@Override
	public void delete(int id) 
	{
		
	}

}

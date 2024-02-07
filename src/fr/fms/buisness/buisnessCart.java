package fr.fms.buisness;
import fr.fms.dao.*;

import java.util.ArrayList;

import fr.fms.entities.Stage;

public class buisnessCart implements Buisness
{
	ArticleDao artdao = new ArticleDao();
	
	public ArrayList<Stage> cartList = new ArrayList<Stage>();
	
	@Override
	public void addToCart(int id) 
	{
		
		
	}
	
	@Override
	public void removeFromCart(int id ) 
	{
		for( Stage k : cartList)
		{
			if( id == k.getId())
			{
				cartList.remove(id);
			}
		}
	}

	@Override
	public ArrayList<Stage> showCart() 
	{
		return cartList;
	}
	
	public void showStages()
	{
		artdao.readAll();
	}
}

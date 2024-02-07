package fr.fms.buisness;
import fr.fms.dao.*;

import java.util.ArrayList;

import fr.fms.entities.Stage;

public class buisnessCart implements Buisness<Stage>
{
	ArticleDao artdao = new ArticleDao();
	
	public ArrayList<Stage> cartList = new ArrayList<Stage>();
	
	@Override
	public void addToCart(int id) 
	{
		cartList.add(artdao.readOne(id));
	}
	
	@Override
	public void removeFromCart(int id ) 
	{
		cartList.remove(id);
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
	
	public Stage showStage(int id)
	{
		return artdao.readOne(id);
	}
}

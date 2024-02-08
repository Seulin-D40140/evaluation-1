package fr.fms.buisness;
import fr.fms.dao.*;

import java.util.ArrayList;

import fr.fms.entities.Stage;
import fr.fms.entities.User;

public class buisnessCart implements Buisness<Stage>
{
	ArticleDao artdao = new ArticleDao();
	UserDao userdao = new UserDao();
	
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
	
	public ArrayList<Stage> showStages()
	{
		 return artdao.readAll();
	}
	
	public Stage showStage(int id)
	{
		return artdao.readOne(id);
	}

	public ArrayList<User> showUsers()
	{
		 return userdao.readAll();
	}
	
	public ArrayList<Stage> stageList ()
	{
		return artdao.stages;
	}

	public void userCreate( User obj)
	{
		userdao.create(obj);
	}
}

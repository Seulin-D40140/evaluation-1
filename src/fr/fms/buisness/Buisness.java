package fr.fms.buisness;

import java.util.ArrayList;

import fr.fms.entities.Stage;

public interface Buisness<T> 
{
	
	public void addToCart(int id);
	public void removeFromCart(int id );
	public ArrayList<T> showCart();
	public T showStage(int id);
}

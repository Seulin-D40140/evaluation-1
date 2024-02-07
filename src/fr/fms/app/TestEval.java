package fr.fms.app;

import fr.fms.buisness.buisnessCart;
import fr.fms.dao.ArticleDao;
import fr.fms.entities.Stage;

public class TestEval {

	public static void main(String[] args) 
	{
		ArticleDao artdao = new ArticleDao();
		buisnessCart cart = new buisnessCart();
		
		Stage st = new Stage("js", "jvcrpt", 1500, "remote", 10);
		cart.addToCart(3);
		cart.addToCart(1);
		cart.addToCart(5);
		 for( Stage k : cart.cartList)
		 {
			 System.out.println(k);
		 }
		 cart.removeFromCart(1);
		 System.out.println("***********************************");
		 for( Stage k : cart.cartList)
		 {
			 System.out.println(k);
		 }
	}

}

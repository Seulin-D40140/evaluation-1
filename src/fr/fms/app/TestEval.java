package fr.fms.app;

import fr.fms.buisness.buisnessCart;
import fr.fms.dao.ArticleDao;
import fr.fms.entities.Stage;

public class TestEval {

	public static void main(String[] args) 
	{
		ArticleDao artdao = new ArticleDao();
		buisnessCart cart = new buisnessCart();
		double total = 0 ; 
		total += cart.showStage(7).getPrice();
		System.out.println(total);
		System.out.println("12".chars().allMatch(Character::isDigit));
	}

}

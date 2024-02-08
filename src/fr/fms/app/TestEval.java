package fr.fms.app;

import fr.fms.buisness.buisnessCart;
import fr.fms.dao.ArticleDao;
import fr.fms.dao.UserDao;
import fr.fms.entities.Stage;
import fr.fms.entities.User;

public class TestEval {

	public static void main(String[] args) 
	{
		ArticleDao artdao = new ArticleDao();
		buisnessCart cart = new buisnessCart();
		UserDao user = new UserDao();
		double total = 0 ; 
		total += cart.showStage(7).getPrice();
		System.out.println(total);
		System.out.println("12".chars().allMatch(Character::isDigit));
		User martinUser = new User("martinez40", "123456");
		user.create(martinUser);
	}

}

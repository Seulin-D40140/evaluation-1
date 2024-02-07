package fr.fms.app;
import java.util.Scanner;

import fr.fms.buisness.buisnessCart;
import fr.fms.dao.ArticleDao;
import fr.fms.entities.Stage;

public class ShopApp 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		buisnessCart buisness = new buisnessCart();
		System.out.println("**********************************");
		System.out.println("+            bonjour             +");
		System.out.println("**********************************\n");
		
		buisness.showStages();
		boolean continue1 = true;
		while (continue1)
		{
			System.out.println("\n que voulez vous faire ? : \n" +
						   " 1 - afficher un article , 2 - ajouter article au panier , 3 - voir panier , 4 - supprimez un article du panier , 5 - quitter");
			String choice = scan.nextLine();
			
			switch (Integer.parseInt(choice)) {
			case 1 :
				
				break;
			case 2 :
				Boolean continueadd = true;
				while(continueadd)
				{
					System.out.println("quel article ajouter au panier ? : ");
					String addtocart = scan.nextLine();
					buisness.addToCart(Integer.parseInt(addtocart));
					System.out.println("voulez vous en ajouter un autre ? : o/n");
					String yesnoChoice = scan.nextLine();
					
					if(yesnoChoice.equalsIgnoreCase("N"))
					{
						continueadd = false;
						break;
					}
					else 
					{
						continueadd = true;
					}
				}
				
				break;
			case 3 :
				for( Stage k : buisness.showCart())
				{
					System.out.println(k);
				}
				break;
			case 4 :
				
				break;
			case 5 :
				System.out.println(" a bientot =)");
				break;
			default:
				break;
			}
		}
	}
}


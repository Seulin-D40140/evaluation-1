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
		
		System.out.println("+-------------------- voici nos formations -------------------+");
		buisness.showStages();
		System.out.println("---------------------------------------------------------------");
		int loopCount = 0;
		boolean continue1 = true;
		
		while (continue1)
		{
			String choice = null;
			if (loopCount == 0)
			{
				System.out.println("\n que voulez vous faire ? : \n" +
					" 1 - afficher un article , 2 - ajouter article au panier , 3 - voir panier , 4 - quitter");
				choice = scan.nextLine();
			}
			else
			{
				System.out.println("\n que voulez vous faire ? : \n" +
						" 1 - afficher un article , 2 - ajouter article au panier , 3 - voir panier , 4 - quitter , 5 - voir tout les articles");
				choice = scan.nextLine();
			}
			
			
			switch (Integer.parseInt(choice)) {
			case 1 :
				loopCount++;
				System.out.println("quel formation voulez vous voir ? : ");
				String idStage = scan.nextLine();
				System.out.println("*--------------------------------------------------------------------------------------------------*");
				System.out.println (buisness.showStage(Integer.parseInt(idStage)));
				System.out.println("*--------------------------------------------------------------------------------------------------* \n");
				System.out.println("voulez vous ajouter l'article au panier ? : ");
				String addArticleCartChoise = scan.nextLine();
				
				if (addArticleCartChoise.equalsIgnoreCase("O"))
				{
					buisness.addToCart(Integer.parseInt(idStage));
				}
				
				break;
			case 2 :
				Boolean continueadd = true;
				System.out.println("+------------------------- formations ------------------------+");
				buisness.showStages();
				System.out.println("--------------------------------------------------------------- \n");
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
				boolean continueCart = true;
				System.out.println("*--------------------------------------------------------------------------------------------------*");
				if(buisness.cartList.size() == 0)
				{
					System.out.println("VOTRE PANIER EST VIDE");
					continueCart = false;
				}
				else 
				{
					for( int i = 0 ; i < buisness.showCart().size() ; i++)
					{
						System.out.println( i + " " + buisness.showCart().get(i));
					}
				}
				System.out.println("*--------------------------------------------------------------------------------------------------* \n");
				while ( continueCart)
				{
					System.out.println("voulez vous : \n" + "1 - retirer un article , 2 - passer commande , 3 - revenir au menu principal ");
					String cartChoice = scan.nextLine();
					switch (Integer.parseInt(cartChoice)) 
					{
					case 1:
						System.out.println("quel article souhaitez vous retirer ? (id article) : ");
						String removeArticleChoice = scan.nextLine();
						buisness.removeFromCart(Integer.parseInt(removeArticleChoice));
						
						System.out.println("*--------------------------------------------------------------------------------------------------*");
						for( Stage k : buisness.showCart())
						{	
							
							System.out.println(k);
						}
						System.out.println("*--------------------------------------------------------------------------------------------------* \n");
						break;
					case 2 :
						break;
					case 3 :
						loopCount++;
						continueCart = false;
						break;
					default:
						break;
					}
				}
				
				break;
			case 4 :
					continue1 = false;
					System.out.println("+***** a bientot =) *****+");
				break;
			default:
				break;
			}
		}
	}
}


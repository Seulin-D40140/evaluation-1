package fr.fms.app;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

import fr.fms.buisness.buisnessCart;
import fr.fms.dao.ArticleDao;
import fr.fms.dao.UserDao;
import fr.fms.entities.Stage;
import fr.fms.entities.User;

public class ShopApp 
{
	public static void main(String[] args) 
	{
		
		Scanner scan = new Scanner(System.in);
		buisnessCart buisness = new buisnessCart();
		System.out.println(buisness.showUsers());
		int loopCount = 0;
		double totalOrder = 0;
		boolean continue1 = true;
		boolean continueCart = true;
		String  choice = null;
		int parseChoice = 0;
		boolean isNumber = false;
		boolean isNumberCartChoice = false;
		boolean isNumberRemoveChoice = false;
		boolean isNumberOneFormation = false;
		boolean isNumberAddToCart = false;
		boolean wrongId = false;
		
		
		System.out.println("**********************************");
		System.out.println("+            bonjour             +");
		System.out.println("**********************************\n");
		
		System.out.println("+-------------------- voici nos formations -------------------+");
		for(Stage a : buisness.showStages())
		{
			System.out.println(a.getId() + " - " + a.getName() + " - " + a.getDuration() + " - " + a.getType() + " - " + a.getPrice());
		}
		System.out.println("---------------------------------------------------------------");
		
		while (continue1)
		{
			if (loopCount == 0)
			{
				System.out.println("\n que voulez vous faire ? : \n" +
					" 1 - afficher un article , 2 - ajouter plusieurs au article au panier , 3 - voir panier , 4 - quitter");
				choice = scan.nextLine();
				isNumber = choice.chars().allMatch(Character::isDigit);
				
				while (isNumber == false || (Integer.parseInt(choice) > 4 || Integer.parseInt(choice) < 1))
				{
					System.out.println("\n que voulez vous faire ? : \n" +
							" 1 - afficher un article , 2 - ajouter article au panier , 3 - voir panier , 4 - quitter");
						choice = scan.nextLine();
						isNumber = choice.chars().allMatch(Character::isDigit);
				}
			}
			
			else
			{
				System.out.println("\n que voulez vous faire ? : \n" +
						" 1 - afficher un article , 2 - ajouter article au panier , 3 - voir panier , 4 - quitter , \n 5 - voir tout les articles");
				choice = scan.nextLine();
				isNumber = choice.chars().allMatch(Character::isDigit);
				
				while (isNumber == false || (Integer.parseInt(choice) > 5 || Integer.parseInt(choice) < 1))
				{
					System.out.println("\n que voulez vous faire ? : \n" +
							" 1 - afficher une formation , 2 - ajouter formation au panier , 3 - voir panier , 4 - quitter , \n  5 - voir toutes les formations");
						choice = scan.nextLine();
						isNumber = choice.chars().allMatch(Character::isDigit);
				}
			}
		
			parseChoice = Integer.parseInt(choice);
			switch (parseChoice) 
			{
			case 1 :
				loopCount++;
				System.out.println("quel formation voulez vous voir ? : ");
				String idStage = scan.nextLine();
				isNumberOneFormation = idStage.chars().allMatch(Character::isDigit);
				
				
				while (isNumberOneFormation == false || (Integer.parseInt(idStage) > buisness.stageList().size() || Integer.parseInt(idStage) < 1))
				{
					System.out.println("quel formation voulez vous voir ? : ");
					idStage = scan.nextLine();
					isNumberOneFormation = idStage.chars().allMatch(Character::isDigit);
				}
				
				int parseIdStage = Integer.parseInt(idStage);
				System.out.println("*--------------------------------------------------------------------------------------------------*");
				System.out.println (buisness.showStage(parseIdStage));
				System.out.println("*--------------------------------------------------------------------------------------------------* \n");
				System.out.println("voulez vous ajouter l'article au panier ? : o = oui , autre = non ");
				String addArticleCartChoise = scan.nextLine();
				
				if (addArticleCartChoise.equalsIgnoreCase("O"))
				{
					totalOrder += buisness.showStage(parseIdStage).getPrice();
					buisness.addToCart(parseIdStage);
				}
				
				break;
			case 2 :
				loopCount++;
				Boolean continueadd = true;
				System.out.println("+------------------------- formations ------------------------+");
				for(Stage a : buisness.showStages())
				{
					System.out.println(a.getId() + " - " + a.getName() + " - " + a.getDuration() + " - " + a.getType() + " - " + a.getPrice());
				}
				System.out.println("--------------------------------------------------------------- \n");
				while(continueadd)
				{
					System.out.println("quel article ajouter au panier ? : ");
					String addtocart = scan.nextLine();
					isNumberAddToCart = addtocart.chars().allMatch(Character::isDigit);
					while (isNumberAddToCart == false || (Integer.parseInt(addtocart) > buisness.stageList().size() || Integer.parseInt(addtocart) < 1))
					{
						System.out.println("quel article ajouter au panier ? : ");
						addtocart = scan.nextLine();
						isNumberAddToCart = addtocart.chars().allMatch(Character::isDigit);
					}
					
					buisness.addToCart(Integer.parseInt(addtocart));
					totalOrder += buisness.showStage(Integer.parseInt(addtocart)).getPrice();
					System.out.println("voulez vous en ajouter un autre ? : n = non , autre = oui");
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
				loopCount++;
				
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
						System.out.println( "id : " + i + " ,  " + buisness.showCart().get(i));
					}
					System.out.println(" total : " + totalOrder + " €");
				}
				System.out.println("*--------------------------------------------------------------------------------------------------* \n");
				
				while ( continueCart)
				{
					System.out.println("voulez vous : \n" + "1 - retirer un article , 2 - passer commande , 3 - revenir au menu principal ");
					String cartChoice = scan.nextLine();
					isNumberCartChoice = cartChoice.chars().allMatch(Character::isDigit);
					
					while (isNumberCartChoice == false || (Integer.parseInt(cartChoice) > 3 || Integer.parseInt(cartChoice) < 1))
					{
						System.out.println("voulez vous : \n" + "1 - retirer un article , 2 - passer commande , 3 - revenir au menu principal ");
						cartChoice = scan.nextLine();
						isNumberCartChoice = cartChoice.chars().allMatch(Character::isDigit);
					}
					
					switch (Integer.parseInt(cartChoice)) 
					{
						case 1:
							System.out.println("quel article souhaitez vous retirer ? (id article) : ");
							String removeArticleChoice = scan.nextLine();
							isNumberRemoveChoice = removeArticleChoice.chars().allMatch(Character::isDigit);
							
							while(isNumberRemoveChoice == false || (Integer.parseInt(removeArticleChoice) > (buisness.cartList.size()-1) || Integer.parseInt(removeArticleChoice) < 0))
							{
								System.out.println("quel article souhaitez vous retirer ? (id article) : ");
								removeArticleChoice = scan.nextLine();
								isNumberRemoveChoice = removeArticleChoice.chars().allMatch(Character::isDigit);
							}
							totalOrder -= buisness.cartList.get(Integer.parseInt(removeArticleChoice)).getPrice();
							buisness.removeFromCart(Integer.parseInt(removeArticleChoice));
							
							System.out.println("*--------------------------------------------------------------------------------------------------*");
							if (buisness.cartList.size() > 0)
							{
								for( int i = 0 ; i < buisness.showCart().size() ; i++)
								{
									System.out.println( "id : " + i + " ,  " + buisness.showCart().get(i));
								}
								System.out.println("total : " + totalOrder + " €");
							}
							else 
							{
								System.out.println("VOTRE PANIER EST VIDE");
							}
							System.out.println("*--------------------------------------------------------------------------------------------------* \n");
							
							break;
						case 2 :
//							System.out.println("***************coming soon****************** \n");
							System.out.println("voulez vous vous connecter = 1 , ou cree un compre ? = 2 :");
							String connectORcreate = scan.nextLine();
							
							switch (connectORcreate) 
							{
							case "1" :
								while ( wrongId == false)
								{
									System.out.println("--- entrez votre login : ---");
									String login = scan.nextLine();
									System.out.println("--- entrez votre password : ---");
									String password = scan.nextLine();
									String resulAccount = null;
									
									
									for( User user : buisness.showUsers())
									{
										if(!user.getLogin().equals(login))
										{
											resulAccount =  "login incorrect"; 
										}
										else if(user.getLogin().equals(login) && !user.getPassword().equals(password))
										{
											resulAccount = "mot de passe incorrect";
										}
										else 
										{
											wrongId = true;
											resulAccount = "+----------------------~ bienvenue " + user.getLogin() + " ~----------------------+ \n";
										}
									}
									System.out.println(resulAccount);
									
									System.out.println("PANIER : ");
									for( int i = 0 ; i < buisness.showCart().size() ; i++)
									{
										System.out.println( "id : " + i + " ,  " + buisness.showCart().get(i));
									}
									System.out.println("total : " + totalOrder + " € \n");
									
									System.out.println("validez votre panier ? : O/N");
									String cartValidate = scan.nextLine();
									switch (cartValidate) 
									{
									case "o":
										int iduser = 0;
										for( User user : buisness.showUsers())
										{
											if( user.getLogin().equals(login))
											{
												iduser = user.getIdUser();
											}
										}
										System.out.println("validate");
										System.out.println("commande prise en compte et envoyer a ces coordonees : ");
										System.out.println("++++ " + buisness.showCustomer(iduser) + " ++++");
										buisness.cartList.clear();
										continueCart = false;
										
										break;
									case "n":
										continueCart = false;
										break;
									default:
										break;
									}
								}
								
								break;
							case "2" :
								System.out.println("-**************** coming soon ********************-");
								break;
							default:
								break;
							}
							
							break;
						case 3 :
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
			case 5 :
				System.out.println("+-------------------- voici nos formations -------------------+");
				for(Stage a : buisness.showStages())
				{
					System.out.println(a.getId() + " - " + a.getName() + " - " + a.getDuration() + " - " + a.getType() + " - " + a.getPrice());
				}
				System.out.println("---------------------------------------------------------------");
				break;
			default:
				
				break;
			}
		}
		scan.close();
	}
	
//	public void verifyChoice( boolean isNumber , String choice , Scanner scan , int min , int max )
//	{
//		while (isNumber == false || (Integer.parseInt(choice) > max || Integer.parseInt(choice) < min))
//		{
//			System.out.println("\n que voulez vous faire ? : \n" +
//					" 1 - afficher un article , 2 - ajouter article au panier , 3 - voir panier , 4 - quitter");
//				choice = scan.nextLine();
//				isNumber = choice.chars().allMatch(Character::isDigit);
//		}
//	}
}


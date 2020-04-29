package game;

import java.util.Scanner;

public class Arena extends GameplayLogic {
	
	static Scanner scan = new Scanner(System.in);
		
	public static void startGame() {
		boolean gameGoing = true;
		do {
			try {
				GameplayLogic.gameplayLoop();
				System.out.println("Szeretn�l �jra j�tszani?");
				System.out.println("1: Igen");
				System.out.println("2: Nem");
				System.out.println("K�rlek a megfelel� sz�mot �rd be!");
				String answerString = scan.nextLine();
				if(answerString != null && !answerString.trim().isEmpty()) {
					int answer = Integer.parseInt(answerString);
					if(answer == 1) {
						System.out.println("(New Game Starting)" + "\n");
						System.out.println("--------------------------------------------------------------------------------------"+ "\n");
						continue;
					}else if(answer == 2) {
						System.out.println("--------------------------------------------------------------------------------------"+ "\n");
						System.out.println("K�sz�nj�k a r�szv�telt!");
						System.out.println("Game Exiting");
						gameGoing = false;
						System.exit(0);
					}else {
						System.out.println("--------------------------------------------------------------------------------------"+ "\n");
						System.out.println("K�sz�nj�k a r�szv�telt!");
						System.out.println("Game Exiting");
						gameGoing = false;
						System.exit(0);
					}
				}else {
					System.out.println("--------------------------------------------------------------------------------------"+ "\n");
					System.out.println("K�sz�nj�k a r�szv�telt!");
					System.out.println("Game Exiting");
					gameGoing = false;
					System.exit(0);
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch(NumberFormatException e) {
				System.out.println("--------------------------------------------------------------------------------------"+ "\n");
				System.out.println("K�sz�nj�k a r�szv�telt!");
				System.out.println("Game Exiting");
				gameGoing = false;
				System.exit(0);
			} catch(Exception e) {
				System.out.println("--------------------------------------------------------------------------------------"+ "\n");
				System.out.println("K�sz�nj�k a r�szv�telt!");
				System.out.println("Game Exiting");
				gameGoing = false;
				System.exit(0);
			}
		}while(gameGoing);
			
		
		
		
		
		
		
		
	}
	
	
}

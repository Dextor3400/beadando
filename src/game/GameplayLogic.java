package game;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameplayLogic extends Character {
	
	static Scanner scan = new Scanner(System.in);
	static Random rand = new Random();

	static Character myCharacter;
	
	static List<Character> monsters;
	
	static boolean answerChecker;
	static int answer = -1;
	
	public static void gameplayLoop() throws InterruptedException  {
		
		myCharacter = ArenaLogic.makeCharacter();
		monsters = ArenaLogic.makeRandomMonsters(ArenaLogic.setDifficultyLevel());
		
		for(Character monster : monsters) {
			do {
					GameplayLogic.playerChoicePhase(monster);					
					Thread.sleep(3000);
					GameplayLogic.playerAttackPhase(monster);
					Thread.sleep(3000);
					if(monster.getEletero()>0) {
						GameplayLogic.playerDefensePhase(monster);
						Thread.sleep(3000);
					}
			}while(myCharacter.getEletero()>0 && monster.getEletero()>0);
		}
	}
	
	
	public static void playerChoicePhase(Character monster) throws InterruptedException {
				
		int healAmount = rand.nextInt(50-1)+1; 
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("D�nt�s f�zis kezd�dik!");
		System.out.println("Karaktered adatai: ");
		System.out.println(myCharacter);
		System.out.println("Ellens�g adatai:");
		System.out.println(monster);
		System.out.println("Mi legyen a k�vetkez� l�p�s?");
		System.out.println("1: Ellens�g t�mad�sa (" + myCharacter.getTamadoero() + ") t�mad�er�vel");
		System.out.println("2: Karakter gy�gy�t�sa (" + healAmount + ") �leter�ponttal");
		System.out.println("K�rlek a v�lasztott d�nt�s sz�m�t �rd le!");
		
		String answerString;
		
		answerChecker = false;
		
		do {
			answerString = scan.nextLine();
			if(answerString != null && !answerString.trim().isEmpty()) {
				try {
					int answer = Integer.parseInt(answerString);
					if(answer == 1) {
						System.out.println("D�nt�s regisztr�lva. (1)");
						System.out.println("K�vetkez� f�zis indul.");
						answerChecker = true;
					}else if(answer == 2) {
						myCharacter.setEletero(myCharacter.getEletero()+healAmount);
						System.out.println("D�nt�s regisztr�lva. (2)");
						System.out.println("Karakter �lete: " + + myCharacter.getEletero());
						System.out.println("K�vetkez� f�zis indul.");
						answerChecker = true;						
					}else {
						System.out.println("K�rlek v�lassz a lehet�s�gek k�z�l: (1-2)");
					}
				}catch(NumberFormatException e) {
					System.out.println("K�rlek csak sz�mot �rj be!");
				}
			}
		}while(!answerChecker);
				
	}
		
	public static void playerAttackPhase(Character monster) throws InterruptedException {
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("T�mad�s f�zis kezd�dik!");
		System.out.println("sz�rny el�tte");
		System.out.println(monster);
		monster.setEletero(monster.getEletero()-myCharacter.getTamadoero());
		System.out.println("sz�rny ut�na");
		System.out.println(monster);
		
		if(monster.getEletero()<=0) {
			myCharacter.setEletero(myCharacter.getEletero()+50);
			myCharacter.setEletero(myCharacter.getPancel()+20);
			myCharacter.setTamadoero(myCharacter.getTamadoero()+15);
			System.out.println("Sz�rny meghalt, karakter fejl�d�tt.");
			System.out.println("Karakter adatai:");
			System.out.println(myCharacter);
		}
		System.out.println("--------------------------------------------------------------------------------------");	
	}
		
	public static void playerDefensePhase(Character monster) {
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("V�dekez�s f�zis kezd�dik!");
		System.out.println("El�tte:");
		System.out.println(myCharacter);
		myCharacter.setEletero(myCharacter.getEletero()-(monster.getTamadoero())-myCharacter.getPancel());
		System.out.println("ut�na");
		System.out.println(myCharacter);
		
		System.out.println("--------------------------------------------------------------------------------------");
	}

	@Override
	public boolean harcol(Ellenseg e) {
		return false;
	}
	
}

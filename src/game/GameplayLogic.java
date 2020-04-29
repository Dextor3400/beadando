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
	
	public static void gameplayLoop() throws InterruptedException  {
		
		myCharacter = ArenaLogic.makeCharacter();
		
		System.out.println("KARAKTERED ADATAI: ");
		System.out.println("�letereje: " + myCharacter.getEletero());
		System.out.println("P�nc�lja: " + myCharacter.getPancel());
		System.out.println("T�mad�si ereje: " + myCharacter.getTamadoero() + "\n");
		Thread.sleep(500);
		
		monsters = ArenaLogic.makeRandomMonsters(ArenaLogic.setDifficultyLevel());
		
		for(Character monster : monsters) {
			do {
				if(myCharacter.getEletero()>0) {
					int choice = GameplayLogic.playerChoicePhase(monster);					
					Thread.sleep(2000);
					if(choice == 1) {
						GameplayLogic.playerAttackPhase(monster);
					}
					Thread.sleep(2000);
					if(monster.getEletero()>0) {
						GameplayLogic.playerDefensePhase(monster);
						Thread.sleep(2000);						
					}
				}
			}while(myCharacter.getEletero()>0 && monster.getEletero()>0);
		}
		
		if(myCharacter.getEletero()>0) {
			System.out.println("Megszerezted a 'THE HOLY HAND GRENADE' nev� t�rgyat!");
			System.out.println("A t�rgy erej�vel megmentett�l mindenkit �s megmentetted az emberis�get!");
			System.out.println("Egy Igazi H�s vagy!");
			System.out.println("==============NYERT�L!==============");
		}else {
			System.out.println("==============CONGRATULATIONS!==============");
			System.out.println("===============YOU HAVE DIED!==============");
			System.out.println("=================GAME OVER!==============");
		}
	}
	
	
	public static int playerChoicePhase(Character monster) throws InterruptedException {
				
		int healAmount = rand.nextInt(200-20)+20; 
		System.out.println("============================================================================================================================================================================================================================================" + "\n");
		System.out.println("D�nt�s f�zis kezd�dik!"+ "\n");
		System.out.println("Karaktered adatai: ");
		System.out.println(myCharacter + "\n");
		System.out.println("Ellens�g adatai:");
		System.out.println(monster + "\n");
		System.out.println("Mi legyen a k�vetkez� l�p�s?");
		System.out.println("1: Ellens�g t�mad�sa (" + myCharacter.getTamadoero() + ") t�mad�er�vel");
		System.out.println("2: Karakter gy�gy�t�sa (" + healAmount + ") �leter�ponttal"+ "\n");
		System.out.println("K�rlek a v�lasztott d�nt�s sz�m�t �rd le!");
		
		String answerString;
		int playerChoice = -1;
		
		answerChecker = false;
		
		do {
			answerString = scan.nextLine();
			if(answerString != null && !answerString.trim().isEmpty()) {
				try {
					int answer = Integer.parseInt(answerString);
					if(answer == 1) {
						System.out.println("D�nt�s regisztr�lva. (1)");
						System.out.println("K�vetkez� f�zis indul.");
						playerChoice = 1;
						answerChecker = true;
					}else if(answer == 2) {
						myCharacter.setEletero(myCharacter.getEletero()+healAmount);
						System.out.println("D�nt�s regisztr�lva. (2)");
						System.out.println("Karakter �lete: " + + myCharacter.getEletero());
						System.out.println("K�vetkez� f�zis indul.");
						playerChoice = 2;
						answerChecker = true;						
					}else {
						System.out.println("K�rlek v�lassz a lehet�s�gek k�z�l: (1-2)");
					}
				}catch(NumberFormatException e) {
					System.out.println("K�rlek csak sz�mot �rj be!");
				}
			}else {
				System.out.println("K�rlek v�lassz a lehet�s�gek k�z�l!");
			}
		}while(!answerChecker);
		System.out.println("============================================================================================================================================================================================================================================" + "\n");
		return playerChoice;
				
	}
		
	public static void playerAttackPhase(Character monster) throws InterruptedException {
		System.out.println("============================================================================================================================================================================================================================================" + "\n");
		System.out.println("T�mad�s f�zis kezd�dik!" + "\n");
		System.out.println("Megt�madtad " + monster.getNev() + " ellenfelet!");
		System.out.println(myCharacter.getTamadoero() + " sebz�st vitt�l be!");
		monster.setEletero(monster.getEletero()-myCharacter.getTamadoero());
		System.out.println("Ellenf�l �j �letereje: " + monster.getEletero());
				
		if(monster.getEletero()<=0) {
			
			int levelUpHealthPoints = rand.nextInt(200-100)+100;
			int levelUpArmor = rand.nextInt(100-20);
			int levelUpAttackPower = rand.nextInt(50-10)+10;
			
			System.out.println(monster.getNev() + " meghalt!");
			System.out.println("Karaktered szinten l�pett!");
			System.out.println("�leter�: " + myCharacter.getEletero() + " + " + "'" + levelUpHealthPoints + "'");
			System.out.println("P�nc�l: " + myCharacter.getPancel() + " + " + "'" + levelUpArmor + "'");
			System.out.println("T�mad�er�: " + myCharacter.getTamadoero() + " + " + "'" + levelUpAttackPower + "'");
			
			myCharacter.setEletero(myCharacter.getEletero()+ levelUpHealthPoints);
			myCharacter.setEletero(myCharacter.getPancel()+levelUpArmor);
			myCharacter.setTamadoero(myCharacter.getTamadoero()+levelUpAttackPower);
			Thread.sleep(2000);
		}
		System.out.println("============================================================================================================================================================================================================================================" + "\n");
	}
		
	public static void playerDefensePhase(Character monster) {
		System.out.println("============================================================================================================================================================================================================================================" + "\n");
		System.out.println("V�dekez�s f�zis kezd�dik!" + "\n");
		System.out.println(monster.getNev() + " nev� ellens�g megt�madott!");
		System.out.println(monster.getTamadoero() + " sebz�st szenvedt�l!");
		myCharacter.setEletero((myCharacter.getEletero()+myCharacter.getPancel())-(monster.getTamadoero()));
		System.out.println("Jelenlegi �leter�d: " + myCharacter.getEletero());
		
		System.out.println("============================================================================================================================================================================================================================================" + "\n");
	}
}

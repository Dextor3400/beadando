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
	
	static int difficultyLevel;
	
	public static void gameplayLoop() throws InterruptedException  {
		
		myCharacter = ArenaLogic.makeCharacter();
		
		System.out.println("KARAKTERED ADATAI: ");
		System.out.println("�letereje: " + myCharacter.getEletero());
		System.out.println("P�nc�lja: " + myCharacter.getPancel());
		System.out.println("T�mad�si ereje: " + myCharacter.getTamadoero() + "\n");
		Thread.sleep(500);
		
		difficultyLevel = ArenaLogic.setDifficultyLevel();
		
		monsters = ArenaLogic.makeRandomMonsters(difficultyLevel);
		
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
			System.out.println(ArenaLogic.getRandomWinningScreen());
		}else {
			System.out.println(ArenaLogic.getRandomGameOver());
		}
	}
	
	
	public static int playerChoicePhase(Character monster) throws InterruptedException {
		int healAmount = -1;
		
		if(difficultyLevel == 1) {
			healAmount = rand.nextInt(100-50)+50; 
		}else if(difficultyLevel == 2) {
			healAmount = rand.nextInt(150-75)+75;
		}else {
			healAmount = rand.nextInt(200-100)+100;
		}
		Arena.lineBreak();
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
						System.out.println("K�vetkez� f�zis indul." + "\n");
						playerChoice = 1;
						answerChecker = true;
					}else if(answer == 2) {
						myCharacter.setEletero(myCharacter.getEletero()+healAmount);
						System.out.println("D�nt�s regisztr�lva. (2)");
						System.out.println("Karaktered �lete n�vekedett  " + healAmount + " egys�ggel");
						System.out.println("Karaktered �j �lete: " + myCharacter.getEletero());
						System.out.println("K�vetkez� f�zis indul." + "\n");
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
		Arena.lineBreak();
		return playerChoice;
				
	}
		
	public static void playerAttackPhase(Character monster) throws InterruptedException {
		Arena.lineBreak();
		System.out.println("T�mad�s f�zis kezd�dik!" + "\n");
		System.out.println("Megt�madtad " + monster.getNev() + " ellenfelet!");
		System.out.println(myCharacter.getTamadoero() + " sebz�st vitt�l be!");
		monster.setEletero(monster.getEletero()-myCharacter.getTamadoero());
		System.out.println("Ellenf�l �j �letereje: " + monster.getEletero() + "\n");
				
		if(monster.getEletero()<=0) {
			
			int levelUpHealthPoints = rand.nextInt(150-100)+100;
			int levelUpArmor = rand.nextInt(40-20)+20;
			int levelUpAttackPower = rand.nextInt(50-10)+10;
			
			System.out.println("Legy�zted " + monster.getNev() + " nev� ellenfeledet!");
			
			System.out.println("KARAKTERED SZINTET L�PETT!");
			System.out.println("�LETER�D: "  + levelUpHealthPoints + " PONTTAL N�VEKEDETT" );
			System.out.println("P�NC�LOD: " + levelUpArmor + " PONTTAL N�VEKEDETT");
			System.out.println("T�MAD�ER�D: " + levelUpAttackPower + " PONTTAL N�VEKEDETT" + "\n");
			
			myCharacter.setEletero((myCharacter.getEletero() + levelUpHealthPoints));
			myCharacter.setPancel((myCharacter.getPancel() + levelUpArmor));
			myCharacter.setTamadoero((myCharacter.getTamadoero() + levelUpAttackPower));
			Thread.sleep(2000);
		}
		Arena.lineBreak();
		}
		
	public static void playerDefensePhase(Character monster) {
		Arena.lineBreak();
		
		System.out.println("V�dekez�s f�zis kezd�dik!" + "\n");
		System.out.println(monster.getNev() + " nev� ellens�g megt�madott!");
		System.out.println(monster.getTamadoero() + " sebz�st szenvedt�l!");
		myCharacter.setEletero((myCharacter.getEletero()+myCharacter.getPancel())-(monster.getTamadoero()));
		System.out.println("Jelenlegi �leter�d: " + myCharacter.getEletero() + "\n");
		
		Arena.lineBreak();
		}
}

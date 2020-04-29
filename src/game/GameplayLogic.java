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
			System.out.println("You'r Winner!" + "\n");
		}else {
			System.out.println("Epic fail!" + "\n");
		}
	}
	
	
	public static int playerChoicePhase(Character monster) throws InterruptedException {
				
		int healAmount = rand.nextInt(200-20)+20; 
		System.out.println("--------------------------------------------------------------------------------------"+ "\n");
		System.out.println("Döntés fázis kezdõdik!"+ "\n");
		System.out.println("Karaktered adatai: ");
		System.out.println(myCharacter + "\n");
		System.out.println("Ellenség adatai:");
		System.out.println(monster + "\n");
		System.out.println("Mi legyen a következõ lépés?");
		System.out.println("1: Ellenség támadása (" + myCharacter.getTamadoero() + ") támadóerõvel");
		System.out.println("2: Karakter gyógyítása (" + healAmount + ") életerõponttal"+ "\n");
		System.out.println("Kérlek a választott döntés számát írd le!");
		
		String answerString;
		int playerChoice = -1;
		
		answerChecker = false;
		
		do {
			answerString = scan.nextLine();
			if(answerString != null && !answerString.trim().isEmpty()) {
				try {
					int answer = Integer.parseInt(answerString);
					if(answer == 1) {
						System.out.println("Döntés regisztrálva. (1)");
						System.out.println("Következõ fázis indul.");
						playerChoice = 1;
						answerChecker = true;
					}else if(answer == 2) {
						myCharacter.setEletero(myCharacter.getEletero()+healAmount);
						System.out.println("Döntés regisztrálva. (2)");
						System.out.println("Karakter élete: " + + myCharacter.getEletero());
						System.out.println("Következõ fázis indul.");
						playerChoice = 2;
						answerChecker = true;						
					}else {
						System.out.println("Kérlek válassz a lehetõségek közül: (1-2)");
					}
				}catch(NumberFormatException e) {
					System.out.println("Kérlek csak számot írj be!");
				}
			}else {
				System.out.println("Kérlek válassz a lehetõségek közül!");
			}
		}while(!answerChecker);
		System.out.println("--------------------------------------------------------------------------------------");		
		return playerChoice;
				
	}
		
	public static void playerAttackPhase(Character monster) throws InterruptedException {
		System.out.println("--------------------------------------------------------------------------------------" + "\n");
		System.out.println("Támadás fázis kezdõdik!" + "\n");
		System.out.println("szörny elõtte");
		System.out.println(monster);
		monster.setEletero(monster.getEletero()-myCharacter.getTamadoero());
		System.out.println("szörny utána");
		System.out.println(monster);
		
		if(monster.getEletero()<=0) {
			
			int levelUpHealthPoints = rand.nextInt(200-100)+100;
			int levelUpArmor = rand.nextInt(100-20);
			int levelUpAttackPower = rand.nextInt(50-10)+10;
			
			System.out.println(monster.getNev() + " meghalt!");
			System.out.println("Karaktered szinten lépett!");
			System.out.println("Életerõ: " + myCharacter.getEletero() + " + " + "'" + levelUpHealthPoints + "'");
			System.out.println("Páncél: " + myCharacter.getPancel() + " + " + "'" + levelUpArmor + "'");
			System.out.println("Támadóerõ: " + myCharacter.getTamadoero() + " + " + "'" + levelUpAttackPower + "'");
			
			myCharacter.setEletero(myCharacter.getEletero()+ levelUpHealthPoints);
			myCharacter.setEletero(myCharacter.getPancel()+levelUpArmor);
			myCharacter.setTamadoero(myCharacter.getTamadoero()+levelUpAttackPower);
			Thread.sleep(2000);
		}
		System.out.println("--------------------------------------------------------------------------------------");	
	}
		
	public static void playerDefensePhase(Character monster) {
		System.out.println("--------------------------------------------------------------------------------------" + "\n");
		System.out.println("Védekezés fázis kezdõdik!" + "\n");
		System.out.println("'" + ArenaLogic.getRandomEnemyComment(monster) + "'");
		System.out.println("Karaktered életereje: " + myCharacter.getEletero() + "-" + monster.getTamadoero());
		myCharacter.setEletero((myCharacter.getEletero()+myCharacter.getPancel())-(monster.getTamadoero()));
		
		System.out.println("--------------------------------------------------------------------------------------");
	}
}

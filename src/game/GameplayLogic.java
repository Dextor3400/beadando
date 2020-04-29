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
		System.out.println("Döntés fázis kezdõdik!");
		System.out.println("Karaktered adatai: ");
		System.out.println(myCharacter);
		System.out.println("Ellenség adatai:");
		System.out.println(monster);
		System.out.println("Mi legyen a következõ lépés?");
		System.out.println("1: Ellenség támadása (" + myCharacter.getTamadoero() + ") támadóerõvel");
		System.out.println("2: Karakter gyógyítása (" + healAmount + ") életerõponttal");
		System.out.println("Kérlek a választott döntés számát írd le!");
		
		String answerString;
		
		answerChecker = false;
		
		do {
			answerString = scan.nextLine();
			if(answerString != null && !answerString.trim().isEmpty()) {
				try {
					int answer = Integer.parseInt(answerString);
					if(answer == 1) {
						System.out.println("Döntés regisztrálva. (1)");
						System.out.println("Következõ fázis indul.");
						answerChecker = true;
					}else if(answer == 2) {
						myCharacter.setEletero(myCharacter.getEletero()+healAmount);
						System.out.println("Döntés regisztrálva. (2)");
						System.out.println("Karakter élete: " + + myCharacter.getEletero());
						System.out.println("Következõ fázis indul.");
						answerChecker = true;						
					}else {
						System.out.println("Kérlek válassz a lehetõségek közül: (1-2)");
					}
				}catch(NumberFormatException e) {
					System.out.println("Kérlek csak számot írj be!");
				}
			}
		}while(!answerChecker);
				
	}
		
	public static void playerAttackPhase(Character monster) throws InterruptedException {
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("Támadás fázis kezdõdik!");
		System.out.println("szörny elõtte");
		System.out.println(monster);
		monster.setEletero(monster.getEletero()-myCharacter.getTamadoero());
		System.out.println("szörny utána");
		System.out.println(monster);
		
		if(monster.getEletero()<=0) {
			myCharacter.setEletero(myCharacter.getEletero()+50);
			myCharacter.setEletero(myCharacter.getPancel()+20);
			myCharacter.setTamadoero(myCharacter.getTamadoero()+15);
			System.out.println("Szörny meghalt, karakter fejlõdött.");
			System.out.println("Karakter adatai:");
			System.out.println(myCharacter);
		}
		System.out.println("--------------------------------------------------------------------------------------");	
	}
		
	public static void playerDefensePhase(Character monster) {
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("Védekezés fázis kezdõdik!");
		System.out.println("Elõtte:");
		System.out.println(myCharacter);
		myCharacter.setEletero(myCharacter.getEletero()-(monster.getTamadoero())-myCharacter.getPancel());
		System.out.println("utána");
		System.out.println(myCharacter);
		
		System.out.println("--------------------------------------------------------------------------------------");
	}

	@Override
	public boolean harcol(Ellenseg e) {
		return false;
	}
	
}

package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class ArenaLogic {
		
	static Scanner scan = new Scanner(System.in);
	static Random rand = new Random();
	
	public static List<Character> makeRandomMonsters(int difficultyLevel) {
		List<Character> monsters = new ArrayList<>();
		int n = 0;
		String[] monsterNames = {
				"Cryptclaw",
				"Vilemorph",
				"Hollowwoman",
				"Soultaur",
				"The Sick Mutant",
				"The Mad Critter",
				"The Quiet Pest",
				"The Giant Nightmare Monkey",
				"The Feral Butcher Leviathan",
				"The Furry Tomb Hound",
				"Acidserpent",
				"Hellseeker",
				"Guthag",
				"Poisonhag",
				"The Volatile Abomination",
				"The Corrupt Abomination",
				"The Bronze Witch",
				"The Grisly Cinder Frog",
				"The Bloodthirsty Blight Boar",
				"The Dark Rot Lion"
		};
		
		if(difficultyLevel == 1) {
			do {
				String monsterName = monsterNames[rand.nextInt(monsterNames.length)];
				int monsterHealth = rand.nextInt(200-50)+50;
				int monsterAttackPower = rand.nextInt(150-50)+50;
				monsters.add(new Ellenseg(monsterName,monsterHealth,monsterAttackPower));
				n++;
			}while(n < 5);
		}else if(difficultyLevel == 2) {
			do {
				String monsterName = monsterNames[rand.nextInt(monsterNames.length)];
				int monsterHealth = rand.nextInt(250-100)+100;
				int monsterAttackPower = rand.nextInt(175-50)+50;
				monsters.add(new Ellenseg(monsterName,monsterHealth,monsterAttackPower));
				n++;
			}while(n < 10);
		}else if(difficultyLevel == 3) {
			do {
				String monsterName = monsterNames[rand.nextInt(monsterNames.length)];
				int monsterHealth = rand.nextInt(350-150)+150;
				int monsterAttackPower = rand.nextInt(200-50)+50;
				monsters.add(new Ellenseg(monsterName,monsterHealth,monsterAttackPower));
				n++;
			}while(n < 15);
		}
										
		return monsters;
		
	}
	
	public static String getRandomEnemyComment(Character monster) {
		String[] enemyComments = {
			"You Feel like you're going to have a bad time.",
			monster.getNev() + " is overstimulated",
			monster.getNev() + " drew near",
			monster.getNev() + " waddles towards you!",
		};
		
		
		return enemyComments[rand.nextInt(enemyComments.length)];
	}
	
	public static Character getRandomPlayer() throws InterruptedException {
		String[] characterNames = {	
				"Revolver Butcher",
				"F3AR R3APER" ,
				"lx0 Shadow 0xl", 
				"Oh Your Dead 1",
				"Chris P. Bacon",
				"Assasian",
				"ThatsMr.Noob",
				"EvilSantaHOHONO",
				"A Better Player",
				"XxXx3L1T3K1LL3RxXxX",
				"DuckNorris",
				"Tedrinnor",
				"Acerama",
				"Ziaand",
				"Etendaniel",
				"Nydoegan",
				"Galilith",
				"Dret",
				"Aliedia",	
				"REFORMED",
				"TheLegend27"
		};
		
		String characterName = characterNames[rand.nextInt(characterNames.length)];
		int characterHealth = rand.nextInt(500-100)+100;
		int characterArmor = rand.nextInt(50-10)+10;
		int characterAttackPower = rand.nextInt(150-75)+75;
		
		System.out.println("Karakter létrehozva.");		
		Thread.sleep(500);
		if(characterName.equalsIgnoreCase("TheLegend27")) {					//easter egg
			return new Basic(characterName,9999,9999,9999);
		}else {
			return new Basic(characterName,characterHealth,characterAttackPower, characterArmor);
		}		
	}
	
	public static int setDifficultyLevel() throws InterruptedException {
		
		boolean inputChecker = false;
		int difficultyLevel = -1;
		
		System.out.println("Milyen nehézséget szeretnél beállítani?");
		System.out.println("Lehetõségek:");
		System.out.println("1: Piece of Cake (Könnyû)");
		System.out.println("2: Let's Rock (Közepes)");
		System.out.println("3: Come get Some (Nehéz)" + "\n");		
		
		System.out.println("Kérlek írd be a neked megfelelõ nehézséget!");
		
		
		do {
			String difficultyLevelString = scan.nextLine();
			if(difficultyLevelString != null && !difficultyLevelString.trim().isEmpty()) {
				try {
					difficultyLevel = Integer.parseInt(difficultyLevelString);
					if(difficultyLevel == 1 || difficultyLevel == 2 || difficultyLevel == 3) {
						inputChecker = true;
					}else {
						System.out.println("Kérlek megfelelõ számot írj be! '(1,2,3)'");
					}
				}catch(NumberFormatException e) {
					System.out.println("Kérlek csak számot írj be! (1-3)");
				}
			}else {
				System.out.println("Kérlek írd be a neked megfelelõ nehézség számát! (1-3)");
			}
		}while(!inputChecker);
		Thread.sleep(500);
		return difficultyLevel;
		
	}
	
	public static Character makeCharacter() throws InterruptedException {
		Character basicPlayer = null;
		Custom customPlayer = null;
			
		boolean answerChecker = false;
		boolean playerNameChecker = false;
		boolean playerHealthChecker = false;
		boolean playerArmorChecker = false;
		boolean playerAttackPowerChecker = false;
		
		String answer;
		String playerName = null;
		String playerHealthString;
		String playerArmorString;
		String playerAttackPowerString;
		
		int playerHealth = -1;
		int playerArmor = -1;
		int playerAttackPower = -1;
		
		System.out.println("Ha szeretnél saját karaktert létrehozni, akkor írd be, hogy 'Igen'");
		System.out.println("Ha azt szeretnéd, hogy mi hozzunk létre neked egy karaktert, akkor írd be, hogy 'Nem'");
		
		do {
			answer = scan.nextLine();
			if(answer != null && !answer.trim().isEmpty()) {									//Checks if the user put anything in											
				if(answer.equalsIgnoreCase("Igen") || answer.equalsIgnoreCase("Nem")) {			//Checks if the user written in the correct value 'Igen' or 'Nem'
					answerChecker = true;														// If everything is okay, it will let the program go forward
				}else {
					System.out.println("Kérlek az 'Igen' és 'Nem' lehetõségek közül válassz!");
				}			
			}else {
				System.out.println("Kérlek válassz a lehetõségek közül és írd le!");
				System.out.println("'Igen' - 'Nem'");
			}
		}while(!answerChecker);
		
		if(answer.equalsIgnoreCase("Nem")) {
			basicPlayer = ArenaLogic.getRandomPlayer();
		}
		
		//------------------------------//
		//--CUSTOM CHARACTER CREATION--//
		//---------BEGINNING----------//
		//---------------------------//
		
		
		// PLAYER NAME //
		
		if(answer.equalsIgnoreCase("Igen")) {												
			System.out.println("Kérlek add meg a karaktered nevét.");
			do {
				playerName = scan.nextLine();
				if(playerName != null && !playerName.trim().isEmpty()) {								//Checks if the user entered string is empty
					playerNameChecker = true;
				}else {
					System.out.println("Kérlek írd be a karaktered nevét!");
				}
				
			}while(!playerNameChecker);
			Thread.sleep(500);
					
		// PLAYER HEALTHPOINTS //
			
			System.out.println("Kérlek írd be a karaktered életerejét.");
			System.out.println("(1 és 1000 közötti értéket kell használni)");
			do {
				playerHealthString = scan.nextLine();
				if(playerHealthString != null && !playerHealthString.trim().isEmpty()) {
					try {
						playerHealth = Integer.parseInt(playerHealthString);
						if(playerHealth > 0 && playerHealth < 1001) {
							playerHealthChecker = true;
						}else 
							System.out.println("A megadott számnak '1' és '1000' között kell lennie!");
						
					}catch(NumberFormatException e) {
						System.out.println("Kérlek csak számokat írj be!");
					}
				}else {
					System.out.println("Kérlek írj be értéket!");
				}
												
			}while(!playerHealthChecker);
			Thread.sleep(500);
			
			
		// PLAYER ARMOR //
			
			System.out.println("Kérlek írd be a karaktered páncéljának értékét");
			System.out.println("(1 és 500 közötti értéket kell használni)");
						
			do {
				playerArmorString = scan.nextLine();
				if(playerArmorString != null && !playerArmorString.trim().isEmpty()) {
					try {
						playerArmor = Integer.parseInt(playerArmorString);
						if(playerArmor > 0 && playerArmor < 501) {
							playerArmorChecker = true;
						}else
							System.out.println("A megadott számnak '1' és '500' között kell lennie!");
					} catch (NumberFormatException e) {
						System.out.println("Kérlek csak számokat írj be!");
					}
				}else {
					System.out.println("Kérlek írj be értéket!");
				}
			}while(!playerArmorChecker);
			Thread.sleep(500);
		
		
		// PLAYER ATTACK POWER //
		
			System.out.println("Kérlek írd be a karaktered támadásának erejét");
			System.out.println("(1 és 200 közötti értéket kell használni)");
			
			do {
				playerAttackPowerString = scan.nextLine();
				if(playerAttackPowerString != null && !playerAttackPowerString.trim().isEmpty()) {
					try {
						playerAttackPower = Integer.parseInt(playerAttackPowerString);
						if(playerAttackPower > 0 && playerAttackPower < 201) {
							playerAttackPowerChecker = true;
						}else {
							System.out.println("A megadott számnak '1' és '200' között kell lennie!");
						}
					}catch(NumberFormatException e) {
						System.out.println("Kérlek csak számokat írj be!");
					}
				}else {
					System.out.println("Kérlek írj be értéket!");
				}
								
			}while(!playerAttackPowerChecker);
			
			if(playerName.equalsIgnoreCase("RusznakAttila") || playerName.equalsIgnoreCase("Rusznak Attila") || playerName.equalsIgnoreCase("RusznákAttila") || playerName.equalsIgnoreCase("Rusznák Attila")) {	//easter egg
				customPlayer = new Custom(playerName,9999,9999,9999);
			}else {
				customPlayer = new Custom(playerName,playerHealth,playerArmor,playerAttackPower);
			}						
		
		}
		
		if(answer.equalsIgnoreCase("Nem")) {
			Thread.sleep(500);
			return basicPlayer;
		}else {
			Thread.sleep(500);
			return customPlayer;
		}				
	}


	

}

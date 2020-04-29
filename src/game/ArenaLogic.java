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
				"The Giant Nightmare Monkey",
				"Arachnotron",
				"Cacodemon",
				"Carcass",
				"Whiplash",
				"Prowler",
				"Revenant",
				"Macubus",
				"Dread Knight",
				"Archvile",
				"Marauder",
				"Khan Maykr",
				"Icon of Sin",
				"Unwilling",
				"Balder Knight",
				"Light Crossbow",
				"Engorged Hollow",
				"Undead Crystal Soldier",
				"Crystal Knight",
				"Undead Attack Dog",
				"Flaming Attack Dog",
				"Infested Ghoul",
				"Darkwraith Knight",
				"Necromancer",
				"Crystal Lizard",
				"Black Knight",
				"Blowdart Sniper",
				"Darkmoon Soldiers",
				"Possessed Tree",
				"Great Feline",
				"Mimic",
				"The Channeler",
				"Vagrants",
				"Flowey",
				"Sans",
				"Papyrus",
				"Undyne",
				"Asgore",
				"Napstablook",
				"Froggit",
				"Doggo",
				"Undyne the Undying",
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
	
	public static String getRandomGameOver() {
		String[] gameOverScreenText = {
			"====YOUR DEFEAT HAS BROUGHT CHAOS TO THE FEDERATION. YOUR COWARDICE AND BETRAYAL SHALL BE KNOWN THROUGHOUT THE STARS. DISGRACE WILL FOLLOW YOUR FAMILY FOR CENTURIES.===\r\n" + 
			"==============================ONCE ADORED AND WORSHIPPED BY ALL, YOUR BODY WILL SERVE AS A REMINDEN OF THE PRICE OF FAILURE.============================================\r\n" + 
			"=======================================================OH, THE HORRIBLE PAIN OF DEFEAT....==============================================================================\r\n" + 
			"\r\n" + 
			"===================================================================GAME OVER=============================================================================================",
			"==============CONGRATULATIONS!============== " + "\r" + "\n" +
			"===============YOU HAVE DIED!=============== " + "\r" + "\n" +
			"=================GAME OVER!================= " + "\r" + "\n",
			"====================WOW===================== " + "\r" + "\n" +
			"=================YOU LOST===================" + "\r" + "\n",
			"You have ignited an accidental nuclear war." + "\r" + "\n" + 
			"And no, there is no animated display of a " + "\r" + "\n" + 
			"mushroom cloid with parts of bodies flying " + "\r" + "\n" + 
			"             through the air." + "\r" + "\n" + 
			"          We do not reward failure. " + "\r" + "\n" + 
			"                 Game Over." + "\r" + "\n",
			"			  Your Score: 00000000 " + "\r" + "\n" +
			"			       Game over " + "\r" + "\n" ,
			"                GAME OVER " + "\r" + "\n" +
			"               INSERT COINS " + 
			"               TO CONTINUE " + "\r" + "\n" 
			
			
		};
				
		return gameOverScreenText[rand.nextInt(gameOverScreenText.length)];
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
				"Doom Slayer"
		};
		
		String characterName = characterNames[rand.nextInt(characterNames.length)];
		int characterHealth = rand.nextInt(500-100)+100;
		int characterArmor = rand.nextInt(50-10)+10;
		int characterAttackPower = rand.nextInt(150-75)+75;
		
		System.out.println("Karaktered létrehozva." + "\n");
		Arena.lineBreak();
		
		Thread.sleep(500);
		if(characterName.equalsIgnoreCase("Doom Slayer")) {					//easter egg
			return new Basic(characterName,9999,9999,9999);
		}else {
			return new Basic(characterName,characterHealth,characterAttackPower, characterArmor);
		}		
	}
	
	public static int setDifficultyLevel() throws InterruptedException {
		
		boolean inputChecker = false;
		int difficultyLevel = -1;
		Arena.lineBreak();
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
		Thread.sleep(750);
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
			Arena.lineBreak();
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

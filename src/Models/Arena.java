package Models;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Characters.Basic;
import Characters.Custom;

public class Arena {
	
	static Scanner scan = new Scanner(System.in);
	
	private static ArrayList<Ellenseg> monsters = new ArrayList<>();
	/*
	public static void toborzas() {
		System.out.println("Szörnyek létrehozása megkezdve");
		Random rand = new Random();
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
		
		do {
			monsters.add(new Ellenseg(monsterNames[rand.nextInt(monsterNames.length)]));
			n++;
			System.out.println(n + " szörny létrehozva");
		}while(n < 5);
		
		for(Ellenseg m : monsters) {
			System.out.println(m);
		}
		
		System.out.println("Szörnyek létrehozva!");
		
		
	}
	*/
	
	public static void kezdjuk() {
		
		Basic basicPlayer = null;
		Custom customPlayer = null;
			
		boolean isLetter;
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
		
		System.out.println("Szeretnél saját karaktert létrehozni?");
		System.out.println("Igen vagy nem?");
		
		do {
			isLetter = true;
			answer = scan.nextLine();
			if(answer != null && !answer.trim().isEmpty()) {									//Checks if the user put anything in
				for(char currentCharacter : answer.toCharArray()) { 							//Checks the user input, if it has number, it will fail
					if(!Character.isLetter(currentCharacter)){
						isLetter = false;
					}					
				}
				if(!isLetter)
					System.out.println("Kérlek csak betûket használj!");
				if(isLetter) {
					if(answer.equalsIgnoreCase("Igen") || answer.equalsIgnoreCase("Nem")) {		//Checks if the user written in the correct value 'Igen' or 'Nem'
						answerChecker = true;													// If everything is okay, it will let the program go forward
					}else {
						System.out.println("Kérlek az 'Igen' és 'Nem' lehetõségek közül válassz!");
					}
				}
			}else {
				System.out.println("Kérlek válassz a lehetõségek közül és írd le!");
				System.out.println("'Igen' - 'Nem'");
			}
		}while(!answerChecker);
		
		if(answer.equalsIgnoreCase("Nem")) {
			basicPlayer = new Basic("Player");
		}
		
		//------------------------------//
		//--CUSTOM CHARACTER CREATION--//
		//---------BEGINNING----------//
		//---------------------------//
		
		
		// PLAYER NAME //
		
		else if(answer.equalsIgnoreCase("Igen")) {												
			System.out.println("Kérlek add meg a karaktered nevét.");
			do {
				playerName = scan.nextLine();
				if(answer != null && !answer.trim().isEmpty()) {								//Checks if the user entered string is empty
					playerNameChecker = true;
				}else 
					System.out.println("Kérlek írd be a karaktered nevét!");
				
			}while(!playerNameChecker);
					
		// PLAYER HEALTHPOINTS //
			
			System.out.println("Kérlek írd be a karaktered életerejét.");
			System.out.println("(1 és 1000 közötti értéket kell használni)");
			do {
				playerHealthString = scan.nextLine();
				if(answer != null && !answer.trim().isEmpty()) {
					try {
						playerHealth = Integer.parseInt(playerHealthString);
						if(playerHealth > 0 && playerHealth < 1001) {
							playerHealthChecker = true;
						}else 
							System.out.println("A megadott számnak '1' és '1000' között kell lennie!");
						
					}catch(NumberFormatException e) {
						System.out.println("Kérlek csak számokat írj be!");
					}
				}else 
					System.out.println("Kérlek írj be értéket!");
												
			}while(!playerHealthChecker);
			
			
		// PLAYER ARMOR //
			
			System.out.println("Kérlek írd be a karaktered páncéljának értékét");
			System.out.println("(1 és 500 közötti értéket kell használni)");
						
			do {
				playerArmorString = scan.nextLine();
				if(answer != null && !answer.trim().isEmpty()) {
					try {
						playerArmor = Integer.parseInt(playerArmorString);
						if(playerArmor > 0 && playerArmor < 501) {
							playerArmorChecker = true;
						}else
							System.out.println("A megadott számnak '1' és '500' között kell lennie!");
					} catch (NumberFormatException e) {
						System.out.println("Kérlek csak számokat írj be!");
					}
				}else 
					System.out.println("Kérlek írj be értéket!");
			}while(!playerArmorChecker);
		}
		
		// PLAYER ATTACK POWER //
		
			System.out.println("Kérlek írd be a karaktered támadásának erejét");
			System.out.println("(1 és 200 közötti értéket kell használni)");
			
			do {
				playerAttackPowerString = scan.nextLine();
				if(answer != null && !answer.trim().isEmpty()) {
					try {
						playerAttackPower = Integer.parseInt(playerAttackPowerString);
						if(playerAttackPower > 0 && playerAttackPower < 201) {
							playerAttackPowerChecker = true;
						}else
							System.out.println("A megadott számnak '1' és '200' között kell lennie!");
					}catch(NumberFormatException e) {
						System.out.println("Kérlek csak számokat írj be!");
					}
				}
								
			}while(!playerAttackPowerChecker);
			
		customPlayer = new Custom(playerName,playerHealth,playerArmor,playerAttackPower);
		
		System.out.println("-------------------------");
		System.out.println("Karakter sikeresen elkészült!");
		System.out.println("Adatai:");
		System.out.println("-------------------------");
		
		System.out.println(customPlayer);
		
		
		
		
		
		
		
	}
	
	
}

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
		System.out.println("Sz�rnyek l�trehoz�sa megkezdve");
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
			System.out.println(n + " sz�rny l�trehozva");
		}while(n < 5);
		
		for(Ellenseg m : monsters) {
			System.out.println(m);
		}
		
		System.out.println("Sz�rnyek l�trehozva!");
		
		
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
		
		System.out.println("Szeretn�l saj�t karaktert l�trehozni?");
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
					System.out.println("K�rlek csak bet�ket haszn�lj!");
				if(isLetter) {
					if(answer.equalsIgnoreCase("Igen") || answer.equalsIgnoreCase("Nem")) {		//Checks if the user written in the correct value 'Igen' or 'Nem'
						answerChecker = true;													// If everything is okay, it will let the program go forward
					}else {
						System.out.println("K�rlek az 'Igen' �s 'Nem' lehet�s�gek k�z�l v�lassz!");
					}
				}
			}else {
				System.out.println("K�rlek v�lassz a lehet�s�gek k�z�l �s �rd le!");
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
			System.out.println("K�rlek add meg a karaktered nev�t.");
			do {
				playerName = scan.nextLine();
				if(answer != null && !answer.trim().isEmpty()) {								//Checks if the user entered string is empty
					playerNameChecker = true;
				}else 
					System.out.println("K�rlek �rd be a karaktered nev�t!");
				
			}while(!playerNameChecker);
					
		// PLAYER HEALTHPOINTS //
			
			System.out.println("K�rlek �rd be a karaktered �leterej�t.");
			System.out.println("(1 �s 1000 k�z�tti �rt�ket kell haszn�lni)");
			do {
				playerHealthString = scan.nextLine();
				if(answer != null && !answer.trim().isEmpty()) {
					try {
						playerHealth = Integer.parseInt(playerHealthString);
						if(playerHealth > 0 && playerHealth < 1001) {
							playerHealthChecker = true;
						}else 
							System.out.println("A megadott sz�mnak '1' �s '1000' k�z�tt kell lennie!");
						
					}catch(NumberFormatException e) {
						System.out.println("K�rlek csak sz�mokat �rj be!");
					}
				}else 
					System.out.println("K�rlek �rj be �rt�ket!");
												
			}while(!playerHealthChecker);
			
			
		// PLAYER ARMOR //
			
			System.out.println("K�rlek �rd be a karaktered p�nc�lj�nak �rt�k�t");
			System.out.println("(1 �s 500 k�z�tti �rt�ket kell haszn�lni)");
						
			do {
				playerArmorString = scan.nextLine();
				if(answer != null && !answer.trim().isEmpty()) {
					try {
						playerArmor = Integer.parseInt(playerArmorString);
						if(playerArmor > 0 && playerArmor < 501) {
							playerArmorChecker = true;
						}else
							System.out.println("A megadott sz�mnak '1' �s '500' k�z�tt kell lennie!");
					} catch (NumberFormatException e) {
						System.out.println("K�rlek csak sz�mokat �rj be!");
					}
				}else 
					System.out.println("K�rlek �rj be �rt�ket!");
			}while(!playerArmorChecker);
		}
		
		// PLAYER ATTACK POWER //
		
			System.out.println("K�rlek �rd be a karaktered t�mad�s�nak erej�t");
			System.out.println("(1 �s 200 k�z�tti �rt�ket kell haszn�lni)");
			
			do {
				playerAttackPowerString = scan.nextLine();
				if(answer != null && !answer.trim().isEmpty()) {
					try {
						playerAttackPower = Integer.parseInt(playerAttackPowerString);
						if(playerAttackPower > 0 && playerAttackPower < 201) {
							playerAttackPowerChecker = true;
						}else
							System.out.println("A megadott sz�mnak '1' �s '200' k�z�tt kell lennie!");
					}catch(NumberFormatException e) {
						System.out.println("K�rlek csak sz�mokat �rj be!");
					}
				}
								
			}while(!playerAttackPowerChecker);
			
		customPlayer = new Custom(playerName,playerHealth,playerArmor,playerAttackPower);
		
		System.out.println("-------------------------");
		System.out.println("Karakter sikeresen elk�sz�lt!");
		System.out.println("Adatai:");
		System.out.println("-------------------------");
		
		System.out.println(customPlayer);
		
		
		
		
		
		
		
	}
	
	
}

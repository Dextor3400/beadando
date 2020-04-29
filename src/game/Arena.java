package game;

import java.util.Scanner;

public class Arena extends GameplayLogic {
	
	static Scanner scan = new Scanner(System.in);
		
	public static void startGame() {
		
		try {
			beginning();
		} catch (InterruptedException e1) {
			System.out.println("Valami hiba történt! :(");
		}
		
		boolean gameGoing = true;
		do {
			try {
				GameplayLogic.gameplayLoop();
				System.out.println("Szeretnél újra játszani?");
				System.out.println("1: Igen");
				System.out.println("2: Nem");
				System.out.println("Kérlek a megfelelõ számot írd be!");
				String answerString = scan.nextLine();
				if(answerString != null && !answerString.trim().isEmpty()) {
					int answer = Integer.parseInt(answerString);
					if(answer == 1) {
						System.out.println("(New Game Starting)" + "\n");
						lineBreak();
						}else if(answer == 2) {
						lineBreak();
						System.out.println("Köszönjük a részvételt!");
						System.out.println("Game Exiting");
						gameGoing = false;
						System.exit(0);
					}else {
						lineBreak();
						System.out.println("Köszönjük a részvételt!");
						System.out.println("Game Exiting");
						gameGoing = false;
						System.exit(0);
					}
				}else {
					lineBreak();
					System.out.println("Köszönjük a részvételt!");
					System.out.println("Game Exiting");
					gameGoing = false;
					System.exit(0);
				}
				
			} catch (InterruptedException e) {
				lineBreak();
				System.out.println("Köszönjük a részvételt!");
				System.out.println("Game Exiting");
				gameGoing = false;
				System.exit(0);
			} catch(NumberFormatException e) {
				lineBreak();
				System.out.println("Köszönjük a részvételt!");
				System.out.println("Game Exiting");
				gameGoing = false;
				System.exit(0);
			}catch(Exception e) {
				lineBreak();
				System.out.println("Köszönjük a részvételt!");
				System.out.println("Game Exiting");
				gameGoing = false;
				System.exit(0);
			}
		}while(gameGoing);
				
	}
	
	public static void beginning() throws InterruptedException {
		
		boolean correctAnswer = false;
		int answer = -1;
		System.out.println("Szeretnéd megnézni a Tutorialt?");
		System.out.println("1: Igen");
		System.out.println("2: Nem");
		System.out.println("Kérlek a neked megfelelõt válaszd ki! (1-2)" + "\n");
		do {
			String answerString = scan.nextLine();
			if(answerString != null && !answerString.trim().isEmpty()) {
				try {
					answer = Integer.parseInt(answerString);
					if(answer == 1) {
						tutorial();
						correctAnswer = true;
					}else if(answer == 2) {
						lineBreak();
						correctAnswer = true;
					}else {
						System.out.println("Kérlek a megadott lehetõségek közül válassz! (1-2)");
					}
				}catch(NumberFormatException e) {
					System.out.println("Kérlek megfelelõ tipusú értéket írj be!");
				}
			}else {
				System.out.println("Kérlek írj be értéket!");
			}
		}while(!correctAnswer);
		Thread.sleep(500);
		correctAnswer = false;
		answer = -1;
		System.out.println("Szeretnéd megnézni a Történetet?");
		System.out.println("1: Igen");
		System.out.println("2: Nem");
		System.out.println("Kérlek a neked megfelelõt válaszd ki! (1-2)" + "\n");
		do {
			String answerString = scan.nextLine();
			if(answerString != null && !answerString.trim().isEmpty()) {
				try {
					answer = Integer.parseInt(answerString);
					if(answer == 1) {
						story();
						correctAnswer = true;
					}else if(answer == 2) {
						lineBreak();
						correctAnswer = true;
					}else {
						System.out.println("Kérlek a megadott lehetõségek közül válassz! (1-2)");
					}
				}catch(NumberFormatException e) {
					System.out.println("Kérlek megfelelõ tipusú értéket írj be!");
				}
			}else {
				System.out.println("Kérlek írj be értéket!");
			}
		}while(!correctAnswer);
		Thread.sleep(500);
	}
	
	public static void tutorial() {
		lineBreak();
		System.out.println("Ez egy dungeon crawler típusú játék. \r\n" + 
				"A karaktereddel különbözõ ellenségeket le kell gyõznöd a továbbjutáshoz.\r\n" + 
				"Saját karaktert tudsz létrehozni, melynek 4 különbözõ statisztikája van. Van az életereje, a páncélja, ás a támadási ereje.\r\n" + 
				"Az eleterõ szabja meg, hogy mekkora sebzést tud a karaktered túlélni, a páncélod a sebzést csökkenti amit az ellenfél támadásai okoznak, a támadási erõd pedig, hogy mekkora sebzést tudsz az ellenfelekre mérni.\r\n" + 
				"Létre tudsz hozni saját hõst amelyeknek te állítod be minden értékét, de a játék is létre tud hozni karaktert neked.\r\n" + 
				"Nehézségi szintent is lehet állítani, amely az ellenfelek erõsségét szabályozza, és az ellenfelek mennyiségét.\r\n" + 
				"A karaktered szintet lép ha legyõz egy ellenfelet, és megnövekszik az összes statisztikája.\r\n" + 
				"3 részre van osztva a játék, van a Döntési szakasz, a Támadási szakasz és a Védekezési szakasz.\r\n" + 
				"A döntési szakaszban te döntöd el, hogy támadod az ellenfelet, vagy az életerõdet szeretnéd feltölteni.\r\n" + 
				"A támadási szakaszban megtámadod a szörnyet, és a Támadási erõdnek megfelelõ sebzést osztasz ki rá.\r\n" + 
				"A védekezési szakaszban pedig az ellenfél támad téged.\r\n" + 
				"A célja a játéknak, hogy minden ellenfelet legyõzz." + "\n");
		lineBreak();
		}
	
	public static void story() {
		lineBreak();
		System.out.println("Az év 2269, a démonok elkezdték a föld megszállását, te vagy az emberiség utolsó reménye, a prófécia megtestesülése melyet egy vak szerzetes látott egy látomásában.\r\n" + 
				"Egy tárgy van mely megmentheti az emberiséget melynek neve \"THE HOLY HAND GRENADE\".\r\n" + 
				"Meg kell szerezned ezt a tárgyat, de ez az ellenséges vonalak mögött található.\r\n" + 
				"A tárgy megszerzése a cél ám ezen át kell jutnod a tárgyat védõ ellenségeken!" + "\n");
		lineBreak();
	}
	
	public static void lineBreak() {
		System.out.println("============================================================================================================================================================================================================================================" + "\n");
	}
	
}

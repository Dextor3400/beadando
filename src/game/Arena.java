package game;

import java.util.Scanner;

public class Arena extends GameplayLogic {
	
	static Scanner scan = new Scanner(System.in);
		
	public static void startGame() {
		
		try {
			beginning();
		} catch (InterruptedException e1) {
			System.out.println("Valami hiba t�rt�nt! :(");
		}
		
		boolean gameGoing = true;
		do {
			try {
				GameplayLogic.gameplayLoop();
				System.out.println("Szeretn�l �jra j�tszani?");
				System.out.println("1: Igen");
				System.out.println("2: Nem");
				System.out.println("K�rlek a megfelel� sz�mot �rd be!");
				String answerString = scan.nextLine();
				if(answerString != null && !answerString.trim().isEmpty()) {
					int answer = Integer.parseInt(answerString);
					if(answer == 1) {
						System.out.println("(New Game Starting)" + "\n");
						System.out.println("============================================================================================================================================================================================================================================" + "\n");						continue;
					}else if(answer == 2) {
						System.out.println("============================================================================================================================================================================================================================================" + "\n");
						System.out.println("K�sz�nj�k a r�szv�telt!");
						System.out.println("Game Exiting");
						gameGoing = false;
						System.exit(0);
					}else {
						System.out.println("============================================================================================================================================================================================================================================" + "\n");
						System.out.println("K�sz�nj�k a r�szv�telt!");
						System.out.println("Game Exiting");
						gameGoing = false;
						System.exit(0);
					}
				}else {
					System.out.println("============================================================================================================================================================================================================================================" + "\n");
					System.out.println("K�sz�nj�k a r�szv�telt!");
					System.out.println("Game Exiting");
					gameGoing = false;
					System.exit(0);
				}
				
			} catch (InterruptedException e) {
				System.out.println("============================================================================================================================================================================================================================================" + "\n");
				System.out.println("K�sz�nj�k a r�szv�telt!");
				System.out.println("Game Exiting");
				gameGoing = false;
				System.exit(0);
			} catch(NumberFormatException e) {
				System.out.println("============================================================================================================================================================================================================================================" + "\n");
				System.out.println("K�sz�nj�k a r�szv�telt!");
				System.out.println("Game Exiting");
				gameGoing = false;
				System.exit(0);
			}catch(Exception e) {
				System.out.println("============================================================================================================================================================================================================================================" + "\n");
				System.out.println("K�sz�nj�k a r�szv�telt!");
				System.out.println("Game Exiting");
				gameGoing = false;
				System.exit(0);
			}
		}while(gameGoing);
				
	}
	
	public static void beginning() throws InterruptedException {
		
		boolean correctAnswer = false;
		int answer = -1;
		System.out.println("Szeretn�d megn�zni a Tutorialt?");
		System.out.println("1: Igen");
		System.out.println("2: Nem");
		System.out.println("K�rlek a neked megfelel�t v�laszd ki! (1-2)" + "\n");
		do {
			String answerString = scan.nextLine();
			if(answerString != null && !answerString.trim().isEmpty()) {
				try {
					answer = Integer.parseInt(answerString);
					if(answer == 1) {
						tutorial();
						correctAnswer = true;
					}else if(answer == 2) {
						correctAnswer = true;
					}else {
						System.out.println("K�rlek a megadott lehet�s�gek k�z�l v�lassz! (1-2)");
					}
				}catch(NumberFormatException e) {
					System.out.println("K�rlek megfelel� tipus� �rt�ket �rj be!");
				}
			}else {
				System.out.println("K�rlek �rj be �rt�ket!");
			}
		}while(!correctAnswer);
		Thread.sleep(500);
		correctAnswer = false;
		answer = -1;
		System.out.println("Szeretn�d megn�zni a T�rt�netet?");
		System.out.println("1: Igen");
		System.out.println("2: Nem");
		System.out.println("K�rlek a neked megfelel�t v�laszd ki! (1-2)" + "\n");
		do {
			String answerString = scan.nextLine();
			if(answerString != null && !answerString.trim().isEmpty()) {
				try {
					answer = Integer.parseInt(answerString);
					if(answer == 1) {
						story();
						correctAnswer = true;
					}else if(answer == 2) {
						correctAnswer = true;
					}else {
						System.out.println("K�rlek a megadott lehet�s�gek k�z�l v�lassz! (1-2)");
					}
				}catch(NumberFormatException e) {
					System.out.println("K�rlek megfelel� tipus� �rt�ket �rj be!");
				}
			}else {
				System.out.println("K�rlek �rj be �rt�ket!");
			}
		}while(!correctAnswer);
		Thread.sleep(500);
	}
	
	public static void tutorial() {
		System.out.println("============================================================================================================================================================================================================================================" + "\n");
		System.out.println("Ez egy dungeon crawler t�pus� j�t�k. \r\n" + 
				"A karaktereddel k�l�nb�z� ellens�geket le kell gy�zn�d a tov�bbjut�shoz.\r\n" + 
				"Saj�t karaktert tudsz l�trehozni, melynek 4 k�l�nb�z� statisztik�ja van. Van az �letereje, a p�nc�lja, �s a t�mad�si ereje.\r\n" + 
				"Az eleter� szabja meg, hogy mekkora sebz�st tud a karaktered t�l�lni, a p�nc�lod a sebz�st cs�kkenti amit az ellenf�l t�mad�sai okoznak, a t�mad�si er�d pedig, hogy mekkora sebz�st tudsz az ellenfelekre m�rni.\r\n" + 
				"L�tre tudsz hozni saj�t h�st amelyeknek te �ll�tod be minden �rt�k�t, de a j�t�k is l�tre tud hozni karaktert neked.\r\n" + 
				"Neh�zs�gi szintent is lehet �ll�tani, amely az ellenfelek er�ss�g�t szab�lyozza, �s az ellenfelek mennyis�g�t.\r\n" + 
				"A karaktered szintet l�p ha legy�z egy ellenfelet, �s megn�vekszik az �sszes statisztik�ja.\r\n" + 
				"3 r�szre van osztva a j�t�k, van a D�nt�si szakasz, a T�mad�si szakasz �s a V�dekez�si szakasz.\r\n" + 
				"A d�nt�si szakaszban te d�nt�d el, hogy t�madod az ellenfelet, vagy az �leter�det szeretn�d felt�lteni.\r\n" + 
				"A t�mad�si szakaszban megt�madod a sz�rnyet, �s a T�mad�si er�dnek megfelel� sebz�st osztasz ki r�.\r\n" + 
				"A v�dekez�si szakaszban pedig az ellenf�l t�mad t�ged.\r\n" + 
				"A c�lja a j�t�knak, hogy minden ellefelet legy�zz." + "\n");
		System.out.println("============================================================================================================================================================================================================================================" + "\n");
	}
	
	public static void story() {
		System.out.println("============================================================================================================================================================================================================================================" + "\n");
		System.out.println("Az �v 2269, a d�monok elkezdt�k a f�ld megsz�ll�s�t, te vagy az emberis�g utols� rem�nye, a pr�f�cia megtestes�l�se melyet egy vak szerzetes  l�tott egy l�tom�s�ban.\r\n" + 
				"Egy t�rgy van mely megmentheti az emberis�get melynek neve \"THE HOLY HAND GRENADE\".\r\n" + 
				"Meg kell szerezned ezt a t�rgyat, de ez az ellens�ges vonalak m�g�tt van tal�lhat�.\r\n" + 
				"A t�rgy megszerz�se a c�l �m ezen �t kell jutnod a t�rgyat v�d� ellens�geken!" + "\n");
		System.out.println("============================================================================================================================================================================================================================================" + "\n");
	}
	
}

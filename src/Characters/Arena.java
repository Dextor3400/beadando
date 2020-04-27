package Characters;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Arena extends ArenaLogic {
		
	public static void kezdjuk() {
		
		Character myCharacter = ArenaLogic.makeCharacter();		
		System.out.println(ArenaLogic.makeRandomMonsters(ArenaLogic.setDifficultyLevel()));
		
		System.out.println(myCharacter);
			
		
		
		
		
		
		
		
	}
	
	
}

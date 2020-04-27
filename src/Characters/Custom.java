package Characters;

import Models.Ellenseg;

public class Custom extends Character {

	public Custom(String nev, int eletero, int tamadoero, int pancel) {
		super(nev, eletero, tamadoero, pancel);
	}

	@Override
	public boolean harcol(Ellenseg e) {
		return false;
	}

}

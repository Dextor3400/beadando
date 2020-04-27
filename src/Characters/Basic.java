package Characters;

import Models.Ellenseg;

public class Basic extends Character {

	public Basic() {

	}
	
	public Basic(String nev) {
		super(nev);
	}
	

	@Override
	public boolean harcol(Ellenseg ellenseg) {
		
		ellenseg.setEletero(ellenseg.getEletero()-this.getTamadoero());
		this.setEletero(this.getEletero()-ellenseg.getTamadoero());
		
		return false;
		
	}

	

}

package game;

public class Basic extends Character {

	public Basic() {

	}
	
	public Basic(String nev) {
		super(nev);
	}
	
	public Basic(String nev, int eletero, int tamadoero, int pancel) {
		super(nev, eletero, tamadoero, pancel);
	}
	


	public boolean harcol(Ellenseg ellenseg) {
		
		ellenseg.setEletero(ellenseg.getEletero()-this.getTamadoero());
		this.setEletero(this.getEletero()-ellenseg.getTamadoero());
		
		return false;
		
	}

	

}

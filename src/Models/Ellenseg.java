package Models;

import Characters.Basic;

public class Ellenseg implements Szint {

	private String nev;
	private int eletero;
	private int tamadoero;
	
	private static int szint;
	
	public Ellenseg() {
		
	}
	/*
	public Ellenseg(String nev) {
		this.nev=nev;
		switch(Jatekos.getSzint()) {
			case 0:
				this.setEletero(ELET_LEVEL_ONE);
				this.setTamadoero(TAMADOERO_LEVEL_ONE);
				break;
			case 1:
				this.setEletero(ELET_LEVEL_TWO);
				this.setTamadoero(TAMADOERO_LEVEL_TWO);
				break;
			case 2:
				this.setEletero(ELET_LEVEL_THREE);
				this.setTamadoero(TAMADOERO_LEVEL_THREE);
				break;
			case 3:
				this.setEletero(ELET_LEVEL_FOUR);
				this.setTamadoero(TAMADOERO_LEVEL_FOUR);
				break;
			case 4:
				this.setEletero(ELET_LEVEL_FIVE);
				this.setTamadoero(TAMADOERO_LEVEL_FIVE);
				break;
				
		}
	}
	*/
	
	public String getNev() {
		return nev;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	public int getEletero() {
		return eletero;
	}

	public void setEletero(int eletero) {
		this.eletero = eletero;
	}

	public int getTamadoero() {
		return tamadoero;
	}

	public void setTamadoero(int tamadoero) {
		this.tamadoero = tamadoero;
	}

	public static int getSzint() {
		return szint;
	}

	public static void setSzint(int szint) {
		Ellenseg.szint = szint;
	}

	@Override
	public String toString() {
		return "Ellenseg [nev=" + nev + ", eletero=" + eletero + ", tamadoero=" + tamadoero + "]";
	}
	
	
	
	
	
	
}

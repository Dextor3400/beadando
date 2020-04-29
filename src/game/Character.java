package game;



public abstract class Character  {

	private String nev;
	private int eletero;
	private int pancel;
	private int tamadoero;
	
	private static int szint;
	
	public Character() {
		
	}
	
	
	public Character(String nev, int eletero, int tamadoero) {
		this.nev = nev;
		this.eletero = eletero;
		this.tamadoero = tamadoero;
	}
	
	public Character(String nev, int eletero, int tamadoero, int pancel ) {
		this.nev = nev;
		this.eletero = eletero;
		this.pancel = pancel;
		this.tamadoero = tamadoero;
		this.szint = 0;
	}
		
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

	public int getPancel() {
		return pancel;
	}

	public void setPancel(int pancel) {
		this.pancel = pancel;
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
		Character.szint = szint;
	}

	@Override
	public String toString() {
		return "Név=" + nev + ", Életerõ=" + eletero + ", Páncél=" + pancel + ", Támadóerõ=" + tamadoero;
	}		
}

package game;

import Models.Szint;

public abstract class Character implements Szint {

	private String nev;
	private int eletero;
	private int pancel;
	private int tamadoero;
	
	private static int szint;
	
	public Character() {
		
	}
	
	public Character(String nev) {
		this.nev = nev;
		this.eletero = BASIC_PLAYER_HEALTH;
		this.pancel = BASIC_PLAYER_ARMOR;
		this.tamadoero = BASIC_PLAYER_ATTACKPOWER;
		this.szint = 0;
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
	
	public void tulel() {
		this.szint++;
	}
	
	public abstract boolean harcol(Ellenseg e);

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
		return "Character [nev=" + nev + ", eletero=" + eletero + ", pancel=" + pancel + ", tamadoero=" + tamadoero
				+ "]";
	}		
}

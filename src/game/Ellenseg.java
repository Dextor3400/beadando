package game;



public class Ellenseg extends Character{

	private String nev;
	private int eletero;
	private int tamadoero;
	
	private static int szint;
	
	public Ellenseg() {
		
	}

	public Ellenseg(String nev, int eletero, int tamadoero) {
		this.nev = nev;
		this.eletero = eletero;
		this.tamadoero = tamadoero;
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
		return "N�v=" + nev + ", �leter�=" + eletero + ", T�mad�er�=" + tamadoero;
	}
}

package corso_java;

public class Automobile {
	String modello;
	String marca;
	String targa;
	
	public Automobile(String modello, String marca, String targa) {
		this.modello = modello;
		this.marca = marca;
		this.targa = targa;
	}
	
	public String info() {
		return this.marca + " " + this.modello + " " + this.targa;
	}

	@Override
	public String toString() {
		return "Automobile [modello=" + modello + ", marca=" + marca + ", targa=" + targa + "]";
	}
	
}

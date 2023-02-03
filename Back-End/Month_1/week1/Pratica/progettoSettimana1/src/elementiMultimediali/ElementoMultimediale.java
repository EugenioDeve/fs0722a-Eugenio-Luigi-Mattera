package elementiMultimediali;


import InterfaceEnum.TipologiaFile;

public class ElementoMultimediale {
	
	protected TipologiaFile tipo;
	String titolo;
	public ElementoMultimediale(TipologiaFile tipo, String titolo) {
		this.tipo = tipo;
		this.titolo = titolo;
	}
	
	public void show() {
	}
	public void play() {
		
	}

	public void aumentaLuminosita() {
	}

	public void diminuisiciLuminosita() {
	}

	public void alzaVolume() {
	}

	public void abbassaVolume() {
	}
		

}

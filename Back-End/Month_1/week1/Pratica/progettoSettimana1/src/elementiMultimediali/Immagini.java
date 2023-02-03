package elementiMultimediali;

import InterfaceEnum.TipologiaFile;

public class Immagini extends ElementoMultimediale {

	int luminosita;

	public Immagini(TipologiaFile tipo, String titolo, int luminosita) {
		super(tipo, titolo);
		setLuminosita(luminosita);
	}

	@Override
	public void show() {
		String lum = "";
		for (int i = 0; i < this.luminosita; i++) {
			lum += "*";
		}

		System.out.printf(" Titolo: %s,Luminosità: %s%n",this.titolo, lum);

	}
	
	@Override
	public void aumentaLuminosita() {
		++this.luminosita;
		System.out.println("Luminosità incrementata di uno.");
	}
	
	@Override
	public void diminuisiciLuminosita() {
		--this.luminosita;
		System.out.println("Luminosità decrementata di uno.");
	}

	public int getLuminosita() {
		return luminosita;
	}
	
	
	public void setLuminosita(int luminosita) {
		if (0 > luminosita || luminosita > 10) {
			System.out.println("Errore! Impostare una luminosità compresa tra 1 e 10.");
			return;
		}
		this.luminosita = luminosita;
	}
}

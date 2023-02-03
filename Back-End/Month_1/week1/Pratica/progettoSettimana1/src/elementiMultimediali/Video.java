package elementiMultimediali;

import InterfaceEnum.TipologiaFile;

public class Video extends Riproducibili {
	
	int luminosita;
	public Video(TipologiaFile tipo, String titolo, int volume, int durata, int luminosita) {
		super(tipo, titolo, volume, durata);
		setLuminosita(luminosita);
	}
	
	@Override
	public void play() {
		String vol = "";
		for (int i=0; i<this.volume;i++) {
			vol += "!";
		}
		
		String lum = "";
		for (int i=0; i<this.luminosita;i++) {
			lum += "*";
		}
		
		for (int i = 0; i<this.durata; i++) {
			System.out.printf("Titolo: %s, Volume: %s, Luminosità: %s, Durata attuale: %d min%n",this.titolo, vol, lum,i+1);			
		}
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
		if (0>luminosita||luminosita>10) {
			System.out.println("Errore! Impostare una luminosità compresa tra 0 e 10.");
			return;
		}
		this.luminosita = luminosita;
	}

}

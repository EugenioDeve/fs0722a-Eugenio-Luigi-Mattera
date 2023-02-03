package elementiMultimediali;

import InterfaceEnum.TipologiaFile;
import InterfaceEnum.Volume;

public class Riproducibili extends ElementoMultimediale implements Volume {

	int volume;
	int durata;
	
	public Riproducibili(TipologiaFile tipo, String titolo, int volume, int durata) {
		super(tipo, titolo);
		setVolume(volume);
		this.durata = durata;
	}
	
	@Override
	public void play() {
		System.out.println("Seleziona un elemento multimediale da riprodurre!");
	}
	
	
	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		if (0>volume||volume>10) {
			System.out.println("Errore! Impostare un volume compreso tra 0 e 10.");
			return;
		}
		this.volume = volume;
		
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		if (0>durata||durata>10) {
			System.out.println("Errore! Impostare una durata compresa tra 0 e 10.");
			return;
		}
		this.durata = durata;
	}

	@Override
	public void alzaVolume() {
		++this.volume;
		System.out.println("Volume alzato di uno.");
	}

	@Override
	public void abbassaVolume() {
		--this.volume;
		System.out.println("Volume abbassato di uno.");
	}

}

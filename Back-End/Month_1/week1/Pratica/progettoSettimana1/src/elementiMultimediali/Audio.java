package elementiMultimediali;


import InterfaceEnum.TipologiaFile;

public class Audio extends Riproducibili {

	public Audio(TipologiaFile tipo, String titolo, int volume, int durata) {
		super(tipo, titolo, volume, durata);
	}
	
	@Override
	public void play() {
		String vol = "";
		for (int i=0; i<this.volume;i++) {
			vol += "!";
		}
		for (int i = 0; i<this.durata; i++) {
			System.out.printf("Titolo: %s, Volume: %s, Durata attuale: %d min%n",this.titolo, vol,i+1);			
		}
	}
	
	
	
}

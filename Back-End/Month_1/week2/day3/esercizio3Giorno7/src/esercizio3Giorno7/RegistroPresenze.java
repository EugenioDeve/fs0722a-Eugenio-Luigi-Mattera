package esercizio3Giorno7;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class RegistroPresenze {
		
	String nomeDipendente;
	int giorni;
	
	public RegistroPresenze(String nomeDipendente, int giorni) {
		this.nomeDipendente = nomeDipendente;
		this.giorni = giorni;
	}
	
	public String presenza() {
		String str = this.nomeDipendente + "@" + this.giorni + "#";
		return str;
	}
	
	public void aggiungiVoce(File f, String e) throws IOException {
		FileUtils.writeStringToFile(f, this.presenza(), e, true);
	}

}

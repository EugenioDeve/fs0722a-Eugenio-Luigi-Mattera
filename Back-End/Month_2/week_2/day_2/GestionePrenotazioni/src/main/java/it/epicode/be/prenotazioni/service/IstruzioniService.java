package it.epicode.be.prenotazioni.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import it.epicode.be.prenotazioni.common.exception.PrenotazioneException;

@Service
public class IstruzioniService {
	

	@Value("${gestioneprenotazioni.istruzioniInglese}")
	private String istruzioniInglese;

	@Value("${gestioneprenotazioni.istruzioniItaliano}")
	private String istruzioniItaliano;

	public String getIstruzioni(@PathVariable String lingua) {
		if ("italiano".equals(lingua))
			return istruzioniItaliano;
		else if ("inglese".equals(lingua))
			return istruzioniInglese;
		else {
			throw new PrenotazioneException("Lingua non supportata");
		}
	}

}

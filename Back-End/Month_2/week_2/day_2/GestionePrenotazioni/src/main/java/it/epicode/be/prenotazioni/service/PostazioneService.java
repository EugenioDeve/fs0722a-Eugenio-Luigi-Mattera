package it.epicode.be.prenotazioni.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.be.prenotazioni.common.exception.PrenotazioneException;
import it.epicode.be.prenotazioni.model.Citta;
import it.epicode.be.prenotazioni.model.Postazione;
import it.epicode.be.prenotazioni.model.TipoPostazione;
import it.epicode.be.prenotazioni.repository.PostazioneRepository;

@Service
public class PostazioneService {
	
	@Autowired
	PostazioneRepository postazioneRepository;

	public Optional<Postazione> findById( Long id) {
		return postazioneRepository.findById(id);
	}
	
	public Page<Postazione> findByCodice(String codice, Pageable pageable) {
		return postazioneRepository.findByCodice(codice, pageable);
	}

	public Page<Postazione> findAll(Pageable pageable) {
		return postazioneRepository.findAll(pageable);
	}

	public Postazione save(Postazione postazione) {
		return postazioneRepository.save(postazione);
	}
	
	public Page<Postazione> findLibereByCitta(Citta citta, TipoPostazione tipo,  LocalDate dataRichiesta, Pageable pageable){
		return postazioneRepository.findLibereByCitta(citta, tipo, dataRichiesta, pageable);
	}

	public Postazione update(Long id, Postazione postazione) {
		Optional<Postazione> postazioneResult = postazioneRepository.findById(id);

		if (postazioneResult.isPresent()) {
			Postazione postazioneUpdate = postazioneResult.get();
			postazioneUpdate.setCodice(postazione.getCodice());
			postazioneUpdate.setDescrizione(postazione.getDescrizione());
			postazioneUpdate.setEdificio(postazione.getEdificio());
//			postazioneUpdate.setListaPrenotazioni(postazione.getListaPrenotazioni());
			postazioneUpdate.setNumeroMassimoOccupanti(postazione.getNumeroMassimoOccupanti());
			postazioneUpdate.setTipo(postazione.getTipo());
			postazioneRepository.save(postazioneUpdate);
			return postazioneUpdate;
		} else {
			throw new PrenotazioneException("Elemento non aggiornato");
		}

	}
	
	public void delete(Long id) {
		postazioneRepository.deleteById(id);
	}

}

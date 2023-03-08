package it.epicode.be.prenotazioni.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.be.prenotazioni.common.exception.PrenotazioneException;
import it.epicode.be.prenotazioni.model.Postazione;
import it.epicode.be.prenotazioni.model.Prenotazione;
import it.epicode.be.prenotazioni.model.User;
import it.epicode.be.prenotazioni.repository.PrenotazioneRepository;

@Service
public class PrenotazioneService {

	@Value("${gestioneprenotazioni.giornianticipoprenotazione}")
	private Integer giorniAnticipoPrenotazione;

	@Autowired
	private PrenotazioneRepository prenotazioneRepository;

	public Prenotazione prenota(User utente, Postazione postazione, LocalDate dataPrenotazione) {
		if (checkDataPrenotazione(dataPrenotazione) == false) {
			throw new PrenotazioneException(
					"Impossibile prenotare una postazione meno di " + giorniAnticipoPrenotazione + " giorni prima");
		}

		if (!checkPrenotazioniUtentePerData(utente, dataPrenotazione)) {
			throw new PrenotazioneException("Impossibile effettuare due prenotazioni per la stessa data");
		}

		Prenotazione prenotazione = new Prenotazione(null,utente, postazione, dataPrenotazione, LocalDate.now());

		return prenotazioneRepository.save(prenotazione);

	}

	private boolean checkDataPrenotazione(LocalDate dataPrenotazione) {
		LocalDate now = LocalDate.now();
		return dataPrenotazione.minus(giorniAnticipoPrenotazione, ChronoUnit.DAYS).isAfter(now);
	}

	private boolean checkPrenotazioniUtentePerData(User user, LocalDate dataPrenotazione) {

		Pageable pageable = PageRequest.of(0, 1);

		Page<Prenotazione> findByUserDataPrenotata = prenotazioneRepository.findByUserAndDataPrenotata(user,
				dataPrenotazione, pageable);

		return findByUserDataPrenotata.isEmpty();

	}
	
	public Optional<Prenotazione> findById(Long id) {
		return prenotazioneRepository.findById(id);
	}
	

	public Page<Prenotazione> findByUser(User user, Pageable pageable) {
		return prenotazioneRepository.findByUser(user, pageable);
	}

	public Page<Prenotazione> findAll(Pageable pageable) {
		return prenotazioneRepository.findAll(pageable);
	}

	public Prenotazione save(Prenotazione postazione) {
		return prenotazioneRepository.save(postazione);
	}

	public Prenotazione update(Long id, Prenotazione prenotazione) {
		Optional<Prenotazione> prenotazioneResult = prenotazioneRepository.findById(id);

		if (prenotazioneResult.isPresent()) {
			Prenotazione prenotazioneUpdate = prenotazioneResult.get();
			prenotazioneUpdate.setDataPrenotata(prenotazione.getDataPrenotata());
			prenotazioneUpdate.setDataPrenotazione(prenotazione.getDataPrenotazione());
			prenotazioneUpdate.setPostazione(prenotazione.getPostazione());
			prenotazioneUpdate.setUser(prenotazione.getUser());
			prenotazioneRepository.save(prenotazioneUpdate);
			return prenotazioneUpdate;
		} else {
			throw new PrenotazioneException("Elemento non aggiornato");
		}

	}

	public void delete(Long id) {
		prenotazioneRepository.deleteById(id);
	}

}

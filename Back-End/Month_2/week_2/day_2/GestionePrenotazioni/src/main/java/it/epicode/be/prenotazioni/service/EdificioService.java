package it.epicode.be.prenotazioni.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.epicode.be.prenotazioni.common.exception.PrenotazioneException;
import it.epicode.be.prenotazioni.model.Edificio;
import it.epicode.be.prenotazioni.repository.EdificioRepository;

@Service
public class EdificioService {
	
	@Autowired
	EdificioRepository edificioRepository;

	public Optional<Edificio> findById( Long id) {
		return edificioRepository.findById(id);
	}
	
	public Page<Edificio> findByNome(String nome, Pageable pageable) {
		return edificioRepository.findByNome(nome, pageable);
	}

	public Page<Edificio> findAll(Pageable pageable) {
		return edificioRepository.findAll(pageable);
	}

	public Edificio save(Edificio edificio) {
		return edificioRepository.save(edificio);
	}

	public Edificio update(Long id, Edificio edificio) {
		Optional<Edificio> edificioResult = edificioRepository.findById(id);

		if (edificioResult.isPresent()) {
			Edificio edificioUpdate = edificioResult.get();
			edificioUpdate.setNome(edificio.getNome());
			edificioUpdate.setCitta(edificio.getCitta());
			edificioUpdate.setIndirizzo(edificio.getIndirizzo());
			edificioRepository.save(edificioUpdate);
			return edificioUpdate;
		} else {
			throw new PrenotazioneException("Elemento non aggiornato");
		}

	}
	
	public void delete(Long id) {
		edificioRepository.deleteById(id);
	}

}

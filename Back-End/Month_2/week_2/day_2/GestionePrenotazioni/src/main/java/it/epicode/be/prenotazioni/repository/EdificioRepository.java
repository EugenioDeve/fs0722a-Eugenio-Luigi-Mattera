package it.epicode.be.prenotazioni.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import it.epicode.be.prenotazioni.model.Citta;
import it.epicode.be.prenotazioni.model.Edificio;

public interface EdificioRepository extends PagingAndSortingRepository<Edificio, Long> {
	
	Page<Edificio> findByCitta(Citta citta, Pageable pageable);
	
	Page<Edificio> findByNome(String nome, Pageable pageable);

}

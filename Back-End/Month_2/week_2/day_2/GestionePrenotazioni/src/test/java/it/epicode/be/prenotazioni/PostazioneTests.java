package it.epicode.be.prenotazioni;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.epicode.be.prenotazioni.model.Citta;
import it.epicode.be.prenotazioni.model.TipoPostazione;
import it.epicode.be.prenotazioni.repository.PostazioneRepository;

@SpringBootTest
class PostazioneTests {
	
	@Autowired
	PostazioneRepository postazioneRepository;

	@Test
	void contextLoads() {
		assertNotNull(postazioneRepository);
	}
	
	@Test
	void testFindLiberoByCitta(){
		Citta citta = null;
		postazioneRepository.findLibereByCitta(citta, TipoPostazione.OPENSPACE, LocalDate.now(), null);
		
	}
	
	@Test
	void testFindByCittaAndDate(){
		Citta citta = null;
		postazioneRepository.findByEdificioCittaAndTipo(citta, TipoPostazione.OPENSPACE, null);
		
	}

}

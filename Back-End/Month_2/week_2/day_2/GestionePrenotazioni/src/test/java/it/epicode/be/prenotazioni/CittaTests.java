package it.epicode.be.prenotazioni;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import it.epicode.be.prenotazioni.model.Citta;
import it.epicode.be.prenotazioni.repository.CittaRepository;

@SpringBootTest
class CittaTests {
	
	@Autowired
	CittaRepository cittaRepository;

	@Test
	void contextLoads() {
	}
	
	@Test
	void testFindById(){
		Optional<Citta> findById = cittaRepository.findById(1L);
		
	}
	
	@Test
	void testFindByNome(){
		Page<Citta> findByNome = cittaRepository.findByNome("Roma", null);
		
	}

}

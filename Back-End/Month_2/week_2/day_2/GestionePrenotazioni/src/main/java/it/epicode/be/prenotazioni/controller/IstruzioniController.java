package it.epicode.be.prenotazioni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.be.prenotazioni.service.IstruzioniService;

@RestController
@RequestMapping("/api")
public class IstruzioniController {
	
	@Autowired
	private IstruzioniService istruzioniService;

	@GetMapping(path = "/istruzioni/{lingua}")
	public ResponseEntity<String> getIstruzioni(@PathVariable String lingua) {
		String istruzioni = istruzioniService.getIstruzioni(lingua);
		
		return new ResponseEntity<>(istruzioni, HttpStatus.OK);

	}

}

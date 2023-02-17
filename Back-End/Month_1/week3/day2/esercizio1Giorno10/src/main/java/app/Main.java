package app;

import java.time.LocalDate;

import dao.EventoDAO;
import dao.LocationDAO;
import dao.PartecipazioneDAO;
import dao.PersonaDAO;
import entities.Sesso;
import entities.Stato;
import entities.TipoEvento;

public class Main {

	public static void main(String[] args) {
		
		boolean insertEvento = false;
		boolean getById = false;
		boolean delete = false;
		boolean refresh = false;
		boolean persona = false;
		boolean location = false;
		boolean part = true;
		
		if (insertEvento) {
			//EventoDAO.save("Tomorrowland", LocalDate.parse("2023-07-21"), "Evento musicale", TipoEvento.PUBBLICO, 600000);
			EventoDAO.addPart(1, 1);
		}
		
		if ( getById) {
			EventoDAO.getEventoById(1);
		}
		
		if (delete) {
			EventoDAO.deleteById(3);
		}
		
		if ( refresh) {
			EventoDAO.refresh(1, 700000);
		}
		
		if (persona) {
			PersonaDAO.save("Lorenzo", "De Carolis", "l@l.it", LocalDate.parse("1998-06-06"), Sesso.MASCHIO);
		}
		
		if(location) {
			LocationDAO.save("Via del Corso, 5", "Roma");
		}
		
		if(part) {
			PartecipazioneDAO.save(6, 1, Stato.CONFERMATA);
		}
		
		
		EventoDAO.closeEm();

	}

}

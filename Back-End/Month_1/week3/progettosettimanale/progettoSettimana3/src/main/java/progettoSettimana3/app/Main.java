package progettoSettimana3.app;

import java.time.LocalDate;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import progettoSettimana3.models.Autore;
import progettoSettimana3.models.Genere;
import progettoSettimana3.models.Libro;
import progettoSettimana3.models.Periodicita;
import progettoSettimana3.models.Prestito;
import progettoSettimana3.models.Prodotti;
import progettoSettimana3.models.Rivista;
import progettoSettimana3.models.Utente;
import progettoSettimana3.models.dao.AutoreDAO;
import progettoSettimana3.models.dao.PrestitoDAO;
import progettoSettimana3.models.dao.ProdottoLetterarioDAO;
import progettoSettimana3.models.dao.UtenteDAO;




public class Main {

	static Scanner input = new Scanner(System.in);
	private static final Logger logger = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args) {
		
		int scelta = 1;
		int stop = 0;

		do {

			try {
				System.out.println("-------------------");
				System.out.println("Cosa vuoi fare?");
				System.out.printf(
						"0)Esci%n1)Aggiungi prodotto%n2)Rimuovi prodotto tramite ISBN%n3)Cerca prodotto tramite ISBN%n4)Ricerca per anno di pubblicazione%n5)Ricerca per autore%n6)Ricerca per titolo%n7)Ricerca elementi attualmente in prestito%n8)Ricerca prestiti scaduti e non restituiti%n9)Aggiungi un utente%n10)Crea Prestito%n");
				scelta = Integer.parseInt(input.nextLine());
				switch (scelta) {
				case 0:
					System.out.println("Programma Terminato");
					break;
				case 1:
					aggiungiProdotto();
					break;
				case 2:
					rimuoviTramiteISBN();
					break;
				case 3:
					cercaISBN();
					break;
				case 4:
					cercaPerAnno();
					break;
				case 5:
					cercaPerAutore();
					break;
				case 6:
					cercaPerTitolo();
					break;
				case 7:
					cercaElementiInPrestito();
					break;
				case 8:
					prestitiScaduti();
					break;
				case 9:
					creaUtente();
					break;
				case 10:
					creaPrestito();
					break;
				default:
					System.out.println("Insrisci un indice tra quelli elencati");
				}
			} catch (NumberFormatException e) {
				logger.error("Errore inserisci un numero!");
			}

		} while (scelta != stop);

	}
	
	static void prestitiScaduti() {
		PrestitoDAO pDao = new PrestitoDAO();
		pDao.prestitoNonReso();
	}
	
	//METODO PER RICERCA PRESTITI NON RESTITUITI IN BASE AL NUMERO TESSERA
	static void cercaElementiInPrestito() {
		System.out.println("-------------------");
		System.out.println("Inserisci il tuo numero di tessera:");
		long num = Long.parseLong(input.nextLine());
		
		PrestitoDAO pDao = new PrestitoDAO();
		pDao.prestitoDaTessera(num);
	}
	
	//METODO CREAZIONE PRESTITO
	static void creaPrestito() {
		Prodotti prod = cercaPerTitolo();
		
		System.out.println("-------------------");
		System.out.println("Inserisci il tuo numero di tessera:");
		long num = Long.parseLong(input.nextLine());
		UtenteDAO uDao = new UtenteDAO();
		Utente utente = uDao.getByTessera(num);
		
		Prestito p = new Prestito();
		p.setUtente(utente);
		p.setProdottoPrestato(prod);
		p.setDataInzio(LocalDate.now());
		LocalDate in = p.getDataInzio();
		p.setDataResPrevista(in.plusDays(30));
		
		PrestitoDAO pDao = new PrestitoDAO();
		pDao.save(p);
	}
		
	//METODO PER LA CREAZIONE DEL NUOVO UTENTE
	static void creaUtente() {
		System.out.println("-------------------");
		System.out.println("Inserisci il tuo nome:");
		String nome = input.nextLine();
		
		System.out.println("Inserisci il tuo cognome:");
		String cognome = input.nextLine();
		
		System.out.println("Inserisci la tua data di nascita (IN FORMATO YYYY-MM-DD):");
		LocalDate data = LocalDate.parse(input.nextLine());
		
		Utente u = new Utente();
		u.setNome(nome);
		u.setCognome(cognome);
		u.setDataDiNascita(data);
		
		UtenteDAO uDao = new UtenteDAO();
		uDao.save(u);
		System.out.println("Utente aggiunto correttamente");
	}
	
	//METODO PER RICERCA TRAMITE TITOLO COMPLETO O PARZIALE
	static Prodotti cercaPerTitolo() {
		System.out.println("-------------------");
		System.out.println("Inserisci il titolo del prodotto che cerchi:");
		String str = input.nextLine();
		
		ProdottoLetterarioDAO pDao = new ProdottoLetterarioDAO();
		return pDao.cercaPerTitolo(str);
	}
	
	//METODO PER LA RICERCA TRAMITE AUTORE
	static void cercaPerAutore() {
		System.out.println("-------------------");
		System.out.println("Inserisci il nome dell'autore del prodotto che cerchi:");
		String str = input.nextLine();
		
		ProdottoLetterarioDAO pDao = new ProdottoLetterarioDAO();
		pDao.cercaPerAutore(str);
	}
	
	//METODO PER LA RICERCA TRAMITE ANNO
	static void cercaPerAnno() {
		System.out.println("-------------------");
		System.out.println("Inserisci l'anno del prodotto che cerchi:");
		int anno = Integer.parseInt(input.nextLine());
		
		ProdottoLetterarioDAO pDao = new ProdottoLetterarioDAO();
		pDao.cercaPerAnno(anno);
	}
	
	//METODO PER CERCARE TRAMITE ISBN
	static Prodotti cercaISBN() {
		System.out.println("-------------------");
		System.out.println("Inserisci l'ISBN del prodotto:");
		long isbn = Long.parseLong(input.nextLine());
		
		ProdottoLetterarioDAO pDao = new ProdottoLetterarioDAO();
		System.out.println(pDao.getById(isbn));
		return pDao.getById(isbn);
	}
	
	//METODO PER RIMOZIONE PRODOTTO IN BASE AL CODICE ISBN
	static void rimuoviTramiteISBN() {
		System.out.println("-------------------");
		System.out.println("Inserisci l'ISBN del prodotto:");
		long isbn = Long.parseLong(input.nextLine());
		
		ProdottoLetterarioDAO pDao = new ProdottoLetterarioDAO();
		pDao.delete(isbn);
	}
	
	// METODO PER L'AGGIUNTA DI UN NUOVO PRODOTTO TRAMITE INSERIMENTO DA CONSOLE
	static void aggiungiProdotto() {
		System.out.println("-------------------");
		System.out.println("Che prodotto vuoi aggiungere?");
		System.out.printf("1)Libro%n2)Rivista%n");

		int tipo = Integer.parseInt(input.nextLine());
		
		//switch case per determinare che tipo di prodotto si vuole inserire
		switch (tipo) {
		case 1:
			// RACCOLTA DATI PER CREAZIONE
			System.out.println("Seleziona un genere:");
			System.out.printf("1)Fantasy%n2)Azione%n3)Giallo%n");
			int sceltaGenere = Integer.parseInt(input.nextLine());
			
			//raccolgo i dati
			Genere genere = null;
			switch (sceltaGenere) {
			case 1:
				genere = Genere.FANTASY;
				break;
			case 2:
				genere = Genere.AZIONE;
				break;
			case 3:
				genere = Genere.GIALLO;
				break;
			}

			System.out.println("Inserisci titolo:");
			String titolo = input.nextLine();

			System.out.println("Inserisci anno di pubblicazione:");
			int anno = Integer.parseInt(input.nextLine());

			System.out.println("Inserisci numero di pagine:");
			int pagine = Integer.parseInt(input.nextLine());

			// CREAZIONE AUTORE DEL LIBRO
			System.out.println("Inserisci cognome autore:");
			String cognome = input.nextLine();

			System.out.println("Inserisci nome autore:");
			String nome = input.nextLine();

			Autore autore = saveAutore(cognome, nome);

			// CREAZIONE LIBRO
			Libro libro = new Libro();
			libro.setTitolo(titolo);
			libro.setAnno(anno);
			libro.setPagine(pagine);
			libro.setAutore(autore);
			libro.setGenere(genere);
			
			Prodotti libroDao = saveProdotto(libro);
			System.out.println("Prodotto aggiunto correttamente!");
			break;
		case 2:
			
			// RACCOLTA DATI PER CREAZIONE
			System.out.println("Seleziona una periodicità:");
			System.out.printf("1)Settimanale%n2)Mensile%n3)Semestrale%n");
			int sceltaPeriod = Integer.parseInt(input.nextLine());
			Periodicita period = null;
			switch (sceltaPeriod) {
			case 1:
				period = Periodicita.SETTIMANALE;
				break;
			case 2:
				period = Periodicita.MENSILE;
				break;
			case 3:
				period = Periodicita.SEMESTRALE;
				break;
			}
			System.out.println("Inserisci titolo:");
			String titoloRivista = input.nextLine();

			System.out.println("Inserisci anno di pubblicazione:");
			int annoRivista = Integer.parseInt(input.nextLine());

			System.out.println("Inserisci numero di pagine:");
			int pagineRivista = Integer.parseInt(input.nextLine());

			// CREAZIONE RIVISTA
			Rivista rivista = new Rivista();
			rivista.setTitolo(titoloRivista);
			rivista.setAnno(annoRivista);
			rivista.setPagine(pagineRivista);
			rivista.setPeriodicita(period);
			
			Prodotti rivistaDao = saveProdotto(rivista);
			System.out.println("Prodotto aggiunto correttamente!");
			
			break;
		default:
			logger.error("Errore! Inserisci un indice valido.");
			break;
		}

	}
	
	//METODO PER IL SALVATAGGIO DEI PRODOTTI INDIFFERENTEMENTE DAL TIPO
	private static Prodotti saveProdotto(Prodotti p) {
		ProdottoLetterarioDAO pDao = new ProdottoLetterarioDAO();
		pDao.save(p);
		return p;
	}
	
	//METODO PER IL SALVATAGGIO DELL'AUTORE
	private static Autore saveAutore(String cognome, String nome) {
		Autore a = new Autore();
		a.setCognome(cognome);
		a.setNome(nome);
		
		AutoreDAO aDao = new AutoreDAO();
		aDao.save(a);
		return a;
	}


}

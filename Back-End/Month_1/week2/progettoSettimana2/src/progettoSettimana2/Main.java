package progettoSettimana2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Enum.Genere;
import Enum.Periodicita;

public class Main {

	static Scanner input = new Scanner(System.in);
	private static final Logger logger = LoggerFactory.getLogger(Main.class);
	static String fileName = "archivio.txt";
	static File fileInfo = new File(fileName);
	final static String ENCODING = "utf-8";

	public static void main(String[] args) {
		

		List<Prodotti> archivio = new ArrayList<Prodotti>();
		//ALL'AVVIO CARICO IL CONTUNUTO DEL FILE ESTERNO IN MODO DA AVERE L'ARCHIVIO AGGIORNATO ED EVITARE ERRORI DI RIPETIZIONE DI ISBN
		try {
			archivio = caricaDaDisco();
			
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		calcolaISBN(archivio);

		int scelta = 1;
		int stop = 0;

		do {

			try {
				System.out.println("-------------------");
				System.out.println("Cosa vuoi fare?");
				System.out.printf(
						"0)Esci%n1)Aggiungi prodotto%n2)Rimuovi prodotto tramite ISBN%n3)Cerca prodotto tramite ISBN%n4)Ricerca per anno di pubblicazione%n5)Ricerca per autore%n6)Salva archivio sul disco%n7)Carica archivio da disco%n");
				scelta = Integer.parseInt(input.nextLine());
				switch (scelta) {
				case 0:
					System.out.println("Chiusura Programma");
					break;
				case 1:
					aggiungiProdotto(archivio);
					break;
				case 2:
					archivio = rimuoviTramiteIsbn(archivio, true);
					break;
				case 3:
					rimuoviTramiteIsbn(archivio, false);
					break;
				case 4:
					ricercaAnno(archivio);
					break;
				case 5:
					ricercaAutore(archivio);
					break;
				case 6:
					try {
						salvaSuDisco(archivio);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					break;
				case 7:
					try {
						archivio = caricaDaDisco();
						stampa(archivio);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				case 8:
					System.out.println("----------------------------");
					System.out.println("Archivio corrente:");
					stampa(archivio);
				default:
					System.out.println("Insrisci un indice tra quelli elencati");
				}
			} catch (NumberFormatException e) {
				logger.error("Errore inserisci un numero!");
			}

		} while (scelta != stop);

	}
	
	//METODO CHE CARICA TUTTO IL CONTENUTO DELL'ARCHIVIO PRESENTE SU FILE ESTERNO ED AGGIORNA IL CORRENTE ARCHIVIO
	static List<Prodotti> caricaDaDisco() throws IOException {
		List<Prodotti> array = new ArrayList<Prodotti>();
		String contenuto = FileUtils.readFileToString(fileInfo, ENCODING);
		//suddivido ogni prodotto grazie al divisore inserito #
		String[] segmento = contenuto.split("#");
		//itero ogni prodoto suddividendolo ulteriormente per avere ogni parametro a dispozione grazie al divisore @
		for (int i = 0; i < segmento.length; i++) {
			String[] valore = segmento[i].split("@");
			//verifico se si tratta di un libro o di una rivista ( i libir hanno 6 parametri, le riviste 5)
			if (valore.length > 5) {
				//raccolgo i giusti valori per ogni parametro 
				String[] nome = valore[4].split(" ");
				Genere gen = null;
				switch (valore[5]) {
				case "FANTASY":
					gen = Genere.FANTASY;
					break;
				case "AZIONE":
					gen = Genere.AZIONE;
					break;
				case "GIALLO":
					gen = Genere.GIALLO;
					break;
				}
				try {
					//istanzio l'oggetto con i valori prima raccolti
					Prodotti p = new Libro(Long.parseLong(valore[0]), valore[1], Integer.parseInt(valore[2]),
							Integer.parseInt(valore[3]), new Autore(nome[0], nome[1]), gen);
					//lo aggiungo ad un array temporaneo 
					array.add(p);
				} catch (NumberFormatException ex) {
					logger.error("Errrore nella lettura");
				}
			} else {
				//raccolgo i giusti valori per ogni parametro 
				Periodicita period = null;
				switch (valore[4]) {
				case "SETTIMANALE":
					period = Periodicita.SETTIMANALE;
					break;
				case "MENSILE":
					period = Periodicita.MENSILE;
					break;
				case "SEMESTRALE":
					period = Periodicita.SEMESTRALE;
					break;
				}
				try {
					//istanzio l'oggetto con i valori prima raccolti
					Prodotti p = new Rivista(Long.parseLong(valore[0]), valore[1], Integer.parseInt(valore[2]),
							Integer.parseInt(valore[3]), period);
					//lo aggiungo ad un array temporaneo 
					array.add(p);
				} catch (NumberFormatException ex) {
					logger.error("Errrore nella lettura");
				}
			}

		}
		//restituisco l'array temporaneo per assegnarlo come nuovo valore di archivio
		return array;
	}

	// METODO PER LA SCRITTURA SU DISCO DELL'INTERO ARCHIVIO CHE SOVRASCRIVE IL VECCHIO CONTENUTO (TEORICAMENTE L'ARCHIVIO CHE VIENE CARICATO E' SEMPRE LA VERSIONE PIU AGGIORNATA)
	static void salvaSuDisco(List<Prodotti> archivio) throws IOException {
		List<String> arraySalvataggio = new ArrayList<String>();
		//per ogni elemento dell'archivio invoco il metodo preparaStirnga che mi formatta il contenuto secondo le mie esegienze ( con i divisori @)
		for (int i = 0; i < archivio.size(); i++) {
			arraySalvataggio.add(archivio.get(i).preparaStringa());
		}
		//salvo il contenuto formattato sul file esterno
		FileUtils.writeLines(fileInfo, arraySalvataggio, "#", false);
	}

	// METODO PER LA RICERCA DI PRODOTTI IN BASE ALL'AUTORE
	static List<Prodotti> ricercaAutore(List<Prodotti> archivio) {
		System.out.println("Inserisci il nome dell'autore del prodotto che cerchi:");
		String autore = input.nextLine();
		//verifico che il nome dell'autore esista nell'archivio, se si procedo a chiedere il cognome
		boolean exist = archivio.stream().anyMatch(p -> p.getAutore().equals(autore));
		if (exist) {
			//se il nome esiste filtro l'array lasciando solo i prodotti che hanno come nome autore quello indicato
			Stream<Prodotti> cercaAutore = archivio.stream().filter(p -> p.getAutore().equals(autore));
			System.out.println("Inserisci il cognome dell'autore del prodotto che cerchi:");
			String cognomeAutore = input.nextLine();
			//dall'array gia fltrato dei nomi, filtro nuovamente questa volta con i cognomi
			Stream<Prodotti> risultatoAutore = cercaAutore.filter(p -> p.getCognomeAutore().equals(cognomeAutore));
			List<Prodotti> risultato = risultatoAutore.toList();
			//stampo il risultato della ricerca
			stampa(risultato);
			return risultato;
		} else {
			logger.error("L'autore inserito non è presente nell'archivio");
		}
		return archivio;
	}

	// METODO PER LA RICERCA DI PRODOTTI IN BASE ALL'ANNO
	static List<Prodotti> ricercaAnno(List<Prodotti> archivio) {
		System.out.println("-------------------");
		System.out.println("Inserisci l'anno di pubblicazione del prodotto:");
		int anno = Integer.parseInt(input.nextLine());
		//verifico se almeno uno dei prodotti ha l'anno deisderato
		boolean exist = archivio.stream().anyMatch(p -> p.getAnno() == anno);
		if (exist) {
			//se l'anno esiste nell'archivio procedo a filtrare il giusto prodotto
			Stream<Prodotti> cercaAnno = archivio.stream().filter(p -> p.getAnno() == anno);
			List<Prodotti> risultato = cercaAnno.toList();
			stampa(risultato);
			return risultato;
		} else {
			logger.error("L'anno inserito non è presente nell'archivio");
		}
		return archivio;
	}

	// METODO CHE IN BASE ALLA VARIABILE BOOLEANA RIMUOVE IL PRODOTTO CERCATO OPPURE
	// LO RESTITUISCE ALL'UTENTE
	static List<Prodotti> rimuoviTramiteIsbn(List<Prodotti> archivio, boolean rimuovi) {
		System.out.println("-------------------");
		System.out.println("Inserisci l'ISBN del prodotto:");
		long isbn = Long.parseLong(input.nextLine());
		//verifico se almeno uno dei prodotti ha l'isbn deisderato
		boolean exist = archivio.stream().anyMatch(p -> p.getIsbn() == isbn);
		if (exist) {
			//se l'isbn esiste nell'archivio procedo a verificare se si tratta di un operazione di cancellazione o flitraggio(varibile rimuovi)
			if (rimuovi) {
				//se si tratta di una riomozione, filtro e restituisco tutto l'archivio ad eccezione del prodotot con l'isbn inserito
				Stream<Prodotti> streamProd = archivio.stream().filter(p -> p.getIsbn() != isbn);
				System.out.println("Prodotto rimosso correttamente!");
				return streamProd.toList();
			} else {
				//se si tratta di ricerca filtro e restituisco il prodotto con l'isbn inserito
				Stream<Prodotti> streamProd = archivio.stream().filter(p -> p.getIsbn() == isbn);
				List<Prodotti> risultato = streamProd.toList();
				stampa(risultato);
				return risultato;
			}

		} else {
			logger.error("Il codice inserito non è presente nell'archivio");
		}
		return archivio;
	}

	// METODO PER L'AGGIUNTA DI UN NUOVO PRODOTTO
	static List<Prodotti> aggiungiProdotto(List<Prodotti> archivio) {
		System.out.println("-------------------");
		System.out.println("Che prodotto vuoi aggiungere?");
		System.out.printf("1)Libro%n2)Rivista%n");

		long newIsbn = 0;
		int tipo = Integer.parseInt(input.nextLine());
		
		//switch case per determinare che tipo di prodotto si vuole inserire
		switch (tipo) {
		case 1:
			//invoco la funzione per il calcolo automatico dell'isbn
			newIsbn = calcolaISBN(archivio);
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

			Autore a1 = new Autore(nome, cognome);

			// CREAZIONE LIBRO
			Prodotti prodotto = new Libro(newIsbn, titolo, anno, pagine, a1, genere);
			try {
				prodotto.upload(fileInfo, ENCODING);
			} catch (IOException e) {
				e.printStackTrace();
			}
			archivio.add(prodotto);
			System.out.println("Prodotto aggiunto correttamente!");
			stampa(archivio);
			break;
		case 2:
			//invoco la funzione per il calcolo automatico dell'isbn
			newIsbn = calcolaISBN(archivio);
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
			Prodotti rivista = new Rivista(newIsbn, titoloRivista, annoRivista, pagineRivista, period);
			try {
				rivista.upload(fileInfo, ENCODING);
			} catch (IOException e) {
				e.printStackTrace();
			}
			archivio.add(rivista);
			System.out.println("Prodotto aggiunto correttamente!");
			stampa(archivio);
			break;
		default:
			logger.error("Errore! Inserisci un indice valido.");
			break;
		}
		return archivio;

	}

	// METODO PER LA GENERAZIONE RANDOM DEL NUMERO ISBN UNIVOCO
	static long calcolaISBN(List<Prodotti> a) {
		//Creo un hashset cosi da evitare ripetizioni di isbn
		HashSet<Long> isbn = new HashSet<Long>();
		//aggiungo ogni isbn dell'archivio al nuovo hashset
		for (int i = 0; i<a.size(); i++) {
			isbn.add(a.get(i).isbn);
		}
		
		Random rand = new Random();
		//genero un isbn randomico da 1 a 1000
		long newIsbn = rand.nextInt(1001);
		boolean add = isbn.add(newIsbn);
		if (!add) {
			// se l'isbn generato random è gia presente, viene rilanciata la fuznione e generato un nuovo isbn
			calcolaISBN(a);
		}
		//se l'isbn è valido lo restituisco
		return newIsbn;
	}

	// METODO UNFICATO PER LA STAMPA
	static void stampa(List<Prodotti> array) {
		for (int i = 0; i < array.size(); i++) {
			System.out.println(array.get(i));
		}
	}

}

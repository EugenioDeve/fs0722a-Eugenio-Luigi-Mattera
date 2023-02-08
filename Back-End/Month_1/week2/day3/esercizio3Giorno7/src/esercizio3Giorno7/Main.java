package esercizio3Giorno7;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;


public class Main {

	private static Scanner input = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		String fileName = "info.txt";
		File fileInfo = new File(fileName);
		final String ENCODING = "utf-8";
				
		
		int stop = 1;
		
		
		do {
			
			System.out.println("-------------------------------------");
			System.out.println("Cosa vuoi fare?");
			System.out.println("0)Esci");
			System.out.println("1)Aggiungi dipendente");
			System.out.println("2)Stampa Lista dipendenti");
			
			int scelta = Integer.parseInt(input.nextLine());
			
			switch (scelta) {
				case 0:
					stop = 0;
					System.out.println("Programma terminato!");
					break;
				case 1:
					aggiugni(fileInfo, ENCODING);
					break;
				case 2:
					try {
						leggiVoci(fileInfo, ENCODING);
					} catch (IOException e) {
					}
					break;
			}
			
			
		} while (stop != 0);
		
		input.close();
	}
	
	public static void aggiugni(File f, String e) {
		
		
		
		
		System.out.println("----------------------------------------");
		
		System.out.println("Inserisci nome e cognome del dipendente:");
		String nome = input.nextLine();
		System.out.println("Inserisci quanti giorni ha lavorato il dipendente:");
		try {
			int giorni = Integer.parseInt(input.nextLine());
			
			RegistroPresenze d1 = new RegistroPresenze(nome ,giorni);
			
			
			try {
				d1.aggiungiVoce(f, e);
			} catch (IOException ex) {
				System.out.println("Errore durante la scrittura del file!");
			}
		} catch (NumberFormatException ex) {
			System.out.println("Errore, formato non valido, è necessario inserire un numero");
		}
		
		
	}
	
	public static void leggiVoci(File f, String e) throws IOException {
		String content = FileUtils.readFileToString(f, e);
		String[] segments = content.split("#");
		for (int i=0; i<segments.length; i++) {
			String[] newSegment = segments[i].split("@");
			try {
				RegistroPresenze dip = new RegistroPresenze( newSegment[0],Integer.parseInt(newSegment[1]));
				System.out.println( dip.nomeDipendente + " " + dip.giorni );
			}
			catch(NumberFormatException ex) {
				System.out.println( "Error!" );
			}
		}
		
		
	}

	
}

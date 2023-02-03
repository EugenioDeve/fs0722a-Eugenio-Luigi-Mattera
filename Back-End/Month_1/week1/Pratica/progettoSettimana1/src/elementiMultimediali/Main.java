package elementiMultimediali;

import java.util.Scanner;

import InterfaceEnum.TipologiaFile;

public class Main {

	public static void main(String[] args) {

		ElementoMultimediale[] elementi = new ElementoMultimediale[5];
		int stop = elementi.length;
		int indice = 0;

		Scanner input = new Scanner(System.in);
		do {

			TipologiaFile tipo;
			String titolo;
			int lum;
			int vol;
			int durata;

			System.out.printf(
					"Seleziona una tipologia di file multimediale digitando il numero corrispondente tra:%n1)Immagine%n2)Audio%n3)Video%n");
			int indiceTipo = Integer.parseInt(input.nextLine());
			switch (indiceTipo) {
			case 1:
				tipo = TipologiaFile.IMMAGINE;
				System.out.printf("Inserisci il titolo dell'immagine:%n");
				titolo = input.nextLine();
				System.out.println("Inserisci il valore di luminosità compreso tra 1 e 10");
				lum = Integer.parseInt(input.nextLine());
				if (lum <= 0 || lum > 10) {
					System.out.println("-----------------");
					System.out.println("Errore! Impostare una luminosità compresa tra 1 e 10.");
					System.out.println("-----------------");
					break;
				} else {
					elementi[indice] = new Immagini(tipo, titolo, lum);
					indice++;
				}
				break;
			case 2:
				tipo = TipologiaFile.AUDIO;
				System.out.printf("Inserisci il titolo della traccia audio:%n");
				titolo = input.nextLine();
				System.out.println("Inserisci il valore del volume compreso tra 1 e 10");
				vol = Integer.parseInt(input.nextLine());
				if (vol <= 0 || vol > 10) {
					System.out.println("-----------------");
					System.out.println("Errore! Impostare un volume compreso tra 1 e 10.");
					System.out.println("-----------------");
					break;
				}
				System.out.println("Inserisci il valore della durata compreso tra 1 e 10 min");
				durata = Integer.parseInt(input.nextLine());
				if (durata <= 0 || durata > 10) {
					System.out.println("-----------------");
					System.out.println("Errore! Impostare una durata compresa tra 1 e 10.");
					System.out.println("-----------------");
					break;
				}
				System.out.println("File mltimediale creato con successo!");
				elementi[indice] = new Audio(tipo, titolo, vol, durata);
				indice++;
				break;
			case 3:
				tipo = TipologiaFile.VIDEO;
				System.out.printf("Inserisci il titolo dell video:%n");
				titolo = input.nextLine();
				System.out.println("Inserisci il valore del volume compreso tra 1 e 10");
				vol = Integer.parseInt(input.nextLine());
				if (vol <= 0 || vol > 10) {
					System.out.println("-----------------");
					System.out.println("Errore! Impostare un volume compreso tra 1 e 10.");
					System.out.println("-----------------");
					break;
				}
				System.out.println("Inserisci il valore della durata compreso tra 1 e 10 min");
				durata = Integer.parseInt(input.nextLine());
				if (durata <= 0 || durata > 10) {
					System.out.println("-----------------");
					System.out.println("Errore! Impostare una durata compresa tra 1 e 10.");
					System.out.println("-----------------");
					break;
				}
				System.out.println("Inserisci il valore di luminosità compreso tra 1 e 10");
				lum = Integer.parseInt(input.nextLine());
				if (lum <= 0 || lum > 10) {
					System.out.println("-----------------");
					System.out.println("Errore! Impostare una luminosità compresa tra 1 e 10.");
					System.out.println("-----------------");
					break;
				} else {
					System.out.println("File mltimediale creato con successo!");
					elementi[indice] = new Video(tipo, titolo, vol, durata, lum);
					indice++;
				}
				break;

			}

		} while (!(indice == stop));

		int scelta;
		do {
			System.out.println("-----------------");
			System.out.println(
					"Selezionare il file multimediale desiderato digitando un numero da 1 a 5. Digitare 0 per interrompere");
			scelta = Integer.parseInt(input.nextLine());
			int nuovoIndice = scelta - 1;
			if (nuovoIndice == -1) {
				System.out.println("Esecuzione terminata!");
				return;
			}
			if (elementi[nuovoIndice].tipo.equals(TipologiaFile.IMMAGINE)) {
				System.out.println("-----------------");
				System.out.printf("Seleziona cosa desderi fare digitando il numero corrispondente tra:%n0)Esci%n1)Vedi%n2)Aumenta Luminosità%n3)Diminuisci Luminosità%n");
				 int azione = Integer.parseInt(input.nextLine());
				 switch (azione) {
				 	case 0:
				 		System.out.println("Uscita dal file multimediale esguita!");
				 		break;
				 	case 1: 
				 		elementi[nuovoIndice].show();
				 		break;
				 	case 2:
				 		elementi[nuovoIndice].aumentaLuminosita();
				 		break;
				 	case 3:
				 		elementi[nuovoIndice].diminuisiciLuminosita();
				 		break;
				 }
				
			} else if (elementi[nuovoIndice].tipo.equals(TipologiaFile.VIDEO)){
				System.out.println("-----------------");
				System.out.printf("Seleziona cosa desderi fare digitando il numero corrispondente tra:%n0)Esci%n1)Riproduci%n2)Aumenta Luminosità%n3)Diminuisci Luminosità%n4)Aumenta volume%n5)Diminuisci volume%n");
				 int azione = Integer.parseInt(input.nextLine());
				 switch (azione) {
				 	case 0:
				 		System.out.println("Uscita dal file multimediale esguita!");
				 		break;
				 	case 1: 
				 		elementi[nuovoIndice].play();
				 		break;
				 	case 2:
				 		elementi[nuovoIndice].aumentaLuminosita();
				 		break;
				 	case 3:
				 		elementi[nuovoIndice].diminuisiciLuminosita();
				 		break;
				 	case 4:
				 		elementi[nuovoIndice].alzaVolume();
				 		break;
				 	case 5:
				 		elementi[nuovoIndice].abbassaVolume();
				 		break;
				 		
				 }
			} else {
				System.out.println("-----------------");
				System.out.printf("Seleziona cosa desderi fare digitando il numero corrispondente tra:%n0)Esci%n1)Riproduci%n2)Aumenta volume%n3)Diminuisci volume%n");
				 int azione = Integer.parseInt(input.nextLine());
				 switch (azione) {
				 	case 0:
				 		System.out.println("Uscita dal file multimediale esguita!");
				 		break;
				 	case 1: 
				 		elementi[nuovoIndice].play();
				 		break;
				 	case 2:
				 		elementi[nuovoIndice].alzaVolume();
				 		break;
				 	case 3:
				 		elementi[nuovoIndice].abbassaVolume();
				 		break;
				 		
				 }
			}

		} while (!(scelta == 0));

		input.close();

	}

}

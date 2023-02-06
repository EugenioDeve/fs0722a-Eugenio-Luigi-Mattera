package esercizio2Giorno5;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		try {
			System.out.println("Insersici il numero di KM percorsi:");
			int km = Integer.parseInt(input.nextLine());
			
			
			if (km <= 0) {
				throw new ChilometriNegativiException("Errore! non puoi dividere per 0. Inserisci un valore valido di litri.",km);				
			}
			
			System.out.println("Inserisci il numero di litri di carburante consumati:");
			int l = Integer.parseInt(input.nextLine());
			
			if (l < 0) {
				throw new ChilometriNegativiException("Errore! non puoi dividere per 0. Inserisci un valore valido di litri.",km);	
			}
			
			double result = km / l;
			System.out.println("Il tuo consumo è stato di: " + result + " km/l");
		} catch (ArithmeticException e) {
			System.out.println("Errore! il valore del carburante inserito non è valido.");
		} catch ( ChilometriNegativiException e ) {
			e.whyThereWasError();
		} catch (NumberFormatException e) {
			System.out.println("Errore! il valore inserito non è un numero.");
		}
		
		input.close();
	}

}

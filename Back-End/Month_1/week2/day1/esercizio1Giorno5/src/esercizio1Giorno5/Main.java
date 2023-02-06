6package esercizio1Giorno5;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Random randomPicker = new Random();
		Scanner input = new Scanner(System.in);
		
		int[] numbers = new int[5];
		
		for(int i=0; i < numbers.length; i++) {
			numbers[i] = randomPicker.nextInt(11);
		}
		
		System.out.println("Array orignale " + Arrays.toString(numbers));
		
		int index = 1;
		do {
			System.out.println("--------------------------------------------------");
			System.out.println("Selezionare l'indice dell'array in cui sostituire l'elemento da 1 a " + numbers.length + " (0 per uscire):");
			
			try {
			index = Integer.parseInt(input.nextLine());
			
			if ( index == 0) {
				System.out.println("Programma terminato!");
				return;
			} else if ( index < 0 || index > numbers.length) {
				throw new ArrayIndexOutOfBoundsException();
			}
			
			
			System.out.println("Digita il nuovo numero da inserire:");
			int newNumber = Integer.parseInt(input.nextLine());
			
			numbers[index - 1] = newNumber;
			
			System.out.println("Array modificato con nuovo elemento " + Arrays.toString(numbers));
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Errore! indice non valido. Inserire un valore compreso tra 1 e " + numbers.length);
			} catch (NumberFormatException e) {
				System.out.println("Errore! il valore inserito non è un numero.");
			}
			
		} while (index != 0);

		input.close();
		
	}

}

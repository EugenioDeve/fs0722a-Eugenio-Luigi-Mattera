package esercizio2Giorno3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Inserisci un numero intero compreso tra 0 e 3:");
		int n = Integer.parseInt(input.nextLine());
		printNumber(n);
		
		input.close();

	}
	
	static void printNumber(int n) {
		String message = "";
		
		switch (n) {
			case 0:
				message = "Zero";
				break;
			case 1:
				message = "Uno";
				break;
			case 2:
				message = "Due";
				break;
			case 3:
				message = "Tre";
				break;
			default:
				message = "Errore il numero deve essere compreso tra 0 e 3!";
		}
		
		System.out.println(message);
	}

}

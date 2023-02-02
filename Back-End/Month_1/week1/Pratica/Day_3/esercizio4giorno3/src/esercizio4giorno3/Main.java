package esercizio4giorno3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Inserisci un numero intero per inziare il conto alla rovescia:");
		int n = Integer.parseInt(input.nextLine());
		contoAllaRovescia(n);
		
		input.close();

	}

	static void contoAllaRovescia(int n) {
		for (int i = n; i >= 0; i--) {
			System.out.println(i);
		}
	}
}

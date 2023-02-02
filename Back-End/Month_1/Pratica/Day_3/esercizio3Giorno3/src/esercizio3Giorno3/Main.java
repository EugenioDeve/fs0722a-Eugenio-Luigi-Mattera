package esercizio3Giorno3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		String stop = ":q";
		String str;
		Scanner input;

		do {

			input = new Scanner(System.in);

			System.out.println("inserisci una stringa:");
			str = input.nextLine();

			String s = str.replaceAll("\\s", "");

			// CON L'UTILIZZO DEL METODO SPLIT()
			String[] arr = s.split("");

			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + ",");
			}
			System.out.println();

		} while (!str.equals(stop));

		System.out.println("Programma terminato!");
		input.close();

	}
}

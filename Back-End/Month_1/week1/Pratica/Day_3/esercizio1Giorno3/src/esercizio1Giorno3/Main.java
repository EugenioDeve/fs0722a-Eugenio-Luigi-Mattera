package esercizio1Giorno3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Inserisci una stringa: ");
		String s = input.nextLine();
		printStringa(s);

		System.out.println("Inserisci un anno per verificare se è bisestile: ");
		int a = Integer.parseInt(input.nextLine());
		printAnno(a);

		input.close();

	}

	static boolean stringaPariDispari(String s) {
		if (s.length() % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}

	static void printStringa(String s) {
		if (stringaPariDispari(s) == true) {
			System.out.println("La stringa che hai inserito è pari");
			System.out.println("----------------------------------");
		} else {
			System.out.println("La stringa che hai inserito è dispari");
			System.out.println("----------------------------------");
		}
	}

	static void printAnno(int a) {
		if (annoBisestile(a) == true) {
			System.out.println("L'anno inserito è bisestile");
		} else {
			System.out.println("L'anno inserito non è bisestile");	
		}
		
	}

	static boolean annoBisestile(int a) {
		if (a % 400 == 0) {
			return true;
		} else if (a % 4 == 0 && !(a % 100 == 0)) {
			return true;
		} else {
			return false;
		}
	}

}

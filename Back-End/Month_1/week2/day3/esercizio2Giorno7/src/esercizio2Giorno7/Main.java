package esercizio2Giorno7;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		prendiInput();
		
	}

	static void prendiInput() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("----------------------------------------------------------------");
		System.out.println("Da quanti numeri vuoi che l'array sia generato? (il numero deve essere divisibile per 3)");
		try {
			int val = Integer.parseInt(input.nextLine());
			if (val % 3 == 0) {
				calcoloSomme(val);
			} else {
				System.out.println("Errore, il numero non è divisibile per 3!");
				prendiInput();
			}

		} catch (NumberFormatException e) {
			System.out.println("Valore errato, inserisci un numero!");
			prendiInput();
		}

		input.close();
	}

//	Metodo per il calcolo delle somme
	static void calcoloSomme(int val) {
		int[] numeri = new int[val];

		assegnaNumeri(numeri);

		int calcoloIndici = val / 3;
		System.out.println("Ogni array parziale contiene: " + calcoloIndici + " elementi");

		SommeParziali s1 = new SommeParziali(0, calcoloIndici, numeri);
		SommeParziali s2 = new SommeParziali(calcoloIndici, calcoloIndici*2, numeri);
		SommeParziali s3 = new SommeParziali(calcoloIndici*2, calcoloIndici*3, numeri);

		s1.start();
		s2.start();
		s3.start();

		try {
			s1.join();
			System.out.println("Somma parziale s1: " + s1.sommaParziale);
			s2.join();
			System.out.println("Somma parziale s2: " + s2.sommaParziale);
			s3.join();
			System.out.println("Somma parziale s3: " + s3.sommaParziale);
		} catch (InterruptedException e) {
		}

		int sommaTotale = s1.sommaParziale + s2.sommaParziale + s3.sommaParziale;
		System.out.println("La somma totale dell'array è: " + sommaTotale);
	}

//	Metodo per la generazione randomica dei valori
	static int[] assegnaNumeri(int[] n) {
		Random rand = new Random();

		for (int i = 0; i < n.length; i++) {
			int nuovoNumero = rand.nextInt(101);
			n[i] = nuovoNumero;
		}

		return n;
	}

}

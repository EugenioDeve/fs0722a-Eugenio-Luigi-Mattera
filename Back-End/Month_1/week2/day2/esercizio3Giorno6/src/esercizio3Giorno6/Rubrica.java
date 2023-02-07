package esercizio3Giorno6;

import java.util.HashMap;
import java.util.Scanner;

public class Rubrica {

	public static void main(String[] args) {

		HashMap<String,String> rubrica = new HashMap<String,String>();
//		Scanner input = new Scanner(System.in);
//		
//		System.out.println("Inserisci il nome del contatto:");
//		String nome = input.nextLine();
//		
//		System.out.println("Inserisci il numero:");
//		String numero = input.nextLine();
//		
//		Contatto.aggiungi(nome, numero, rubrica);
		
//		input.close();
		
		Contatto.aggiungi("Lorenzo", "1234567890", rubrica);
		Contatto.aggiungi("David", "12345678901", rubrica);
		Contatto.aggiungi("Frank", "1234567890", rubrica);
		Contatto.aggiungi("Paolo", "1234567890", rubrica);
		
		Contatto.cancella("Lorenzo", rubrica);
		Contatto.cercaConNumero("12345678901", rubrica);
		Contatto.cercaConNome("Paolo", rubrica);
		
		System.out.println(rubrica);
	}

}

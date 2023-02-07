package esercizio1Giorno6;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		Set<String> word = new HashSet<String>();
		Set<String> duplicate = new HashSet<String>();
		
		System.out.println("Quanti elementi vuoi inserire?");
		int elementNumber = Integer.parseInt(input.nextLine());
		int count = 0;
		
		do {
			
			System.out.println("-------------------------------------");
			System.out.println("Inserisci una parola:");
			String newWord = input.nextLine();
			if (word.contains(newWord)) {
				duplicate.add(newWord);
				System.out.println("Parola già presente!");
			} else {
				word.add(newWord);
				System.out.println("Parola aggiunta!");
			}
			count++;
			
			
		} while(count != elementNumber);
		
		System.out.println("-------------------------------------");
		System.out.println("Elenco parole duplicate: " + duplicate);
		System.out.println("Numero parole distinte: " + word.size());
		System.out.println("Elenco parole distinte: " + word);
		input.close();

	}
	
	

}

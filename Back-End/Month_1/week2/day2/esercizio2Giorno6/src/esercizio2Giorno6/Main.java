package esercizio2Giorno6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Insersici un numero intero:");
		int num = Integer.parseInt(input.nextLine());

		randomGenerator(num);

		input.close();
	}

	static void randomGenerator(int n) {
		Random rand = new Random();

		List<Integer> numbers = new ArrayList<Integer>(n);

		for (int i = 0; i < n; i++) {
			int newNumber = rand.nextInt(101);
			numbers.add(newNumber);
		}

		System.out.println("Lista numeri random: " + numbers);
		reverseList(numbers);
		evenOdd(numbers, true);
	}

	static void reverseList(List<Integer> a) {
		List<Integer> newArray = new ArrayList<Integer>(a);

		int lastIndex = a.size() - 1;

		for (int i = lastIndex; i > -1; i--) {
			newArray.add(a.get(i));
		}

		System.out.println("Nuova Lista: " + newArray);
	}

	static void evenOdd(List<Integer> a, boolean b) {
		List<Integer> evenOrOdd = new ArrayList<Integer>();
		String type;
		if (b) {
			type = "pari";
			for (int i = 0; i < a.size(); i += 2) {
				evenOrOdd.add(a.get(i));
			}
			
		} else {
			type = "dispari";
			for (int i = 1; i < a.size(); i += 2) {
				evenOrOdd.add(a.get(i));
			}
		}
		
		System.out.println("Lista numeri in posizone " + type + " :" + evenOrOdd);
	}

}

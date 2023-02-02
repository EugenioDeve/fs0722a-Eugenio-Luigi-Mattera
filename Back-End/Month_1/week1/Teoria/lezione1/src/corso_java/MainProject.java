package corso_java;

import java.util.Scanner;

public class MainProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Ciao a tutti");
		
		int varx; // Dichiarazione di una variabile
		varx = 25; // Inizializzazione di una variabile
		int vary = 10; // Dichiarazione ed inizializzazione di una variabile
		
		int arrx[] = new int[5]; // Dichiarazione di un array
		arrx[0] = 25; // Inizializzazione di un array
		int arry[] = {25,12,99}; // Dichiarazione ed inizializzazione di un array
		
		
		int n = 25;
		double f = 25.5;
		char c = 'h';
		boolean b = true;
		String s = "15";
		
		double db = n; // 25.0 -> Cast implicito
		int id = (int) f; // 25 -> Cast esplicito
		int is = Integer.parseInt(s); // 25 -> Parse
		
		int num1 = 10;
		int num2 = 3;
		int res = num1/num2;
		int mod = num1%num2;
		double r = num1/num2;
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Scrivi il tuo nome: ");
		String nome = sc.nextLine();
		System.out.println("Ciao " + nome);
		System.out.print("Quanti anni hai? ");
		int eta = Integer.parseInt(sc.nextLine());
		if(eta > 18) {
			System.out.println("Sei maggiorenne!! " );
		} else {
			System.out.println("Sei minorenne!! " );
		}
		
		stampa();
	}
	
	public static void stampa() {
		System.out.println("FINE!!!" );
	}

}

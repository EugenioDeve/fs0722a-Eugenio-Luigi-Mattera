package esercizio1Giorno7;

public class Main {

	public static void main(String[] args) {
		
		Esercizio e1 = new Esercizio("*");
		Esercizio e2 = new Esercizio("#");

		e1.start();
		e2.start();
	}

}


class Esercizio extends Thread{
	
	private String str;
	
	public Esercizio(String str) {
		this.str = str;
	}

	public void run() {
		for (int i=0; i<11; i++) {
			System.out.println(this.str);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
		
	}
	
}

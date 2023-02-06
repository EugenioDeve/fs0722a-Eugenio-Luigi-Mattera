package esercizio2Giorno5;

public class ChilometriNegativiException extends RuntimeException {

	private int number;
	
	public ChilometriNegativiException(String message, int number) {
		super(message);
		this.number = number;
	}
	
	public void whyThereWasError() {
		System.out.printf( "Errore perchè non puoi aver percorso un numero negativo di km (%d)", this.number );
	}
	
}

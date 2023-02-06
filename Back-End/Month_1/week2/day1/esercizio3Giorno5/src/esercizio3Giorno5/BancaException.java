package esercizio3Giorno5;

public class BancaException extends Exception  {
	
	String message;

	public BancaException(String message) {
		super();
		this.message = message;
	}
	
	@Override 
	public String toString(){
		return this.message;
	}
	
}

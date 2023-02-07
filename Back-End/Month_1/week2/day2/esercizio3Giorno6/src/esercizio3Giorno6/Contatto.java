package esercizio3Giorno6;

import java.util.HashMap;

public class Contatto {
	
	String nome;
	String numero;
	
	public Contatto(String nome, String numero) {
		this.nome = nome;
		this.numero = numero;
	}
	
	public static void aggiungi(String nome, String numero,HashMap<String,String> r){
		r.put(nome, numero);
	}
	
	public static void cancella(String nome,HashMap<String,String> r){
		r.remove(nome);
	}
	
	public static void cercaConNumero(String numero,HashMap<String,String> r){
		if(r.containsValue(numero)) {
			r.forEach((key, value) -> {
			    if (value.equals(numero)) {
			        System.out.println("Il nome di " + numero + " è: " +key);
			    }
			});
		} else {
			System.out.println("Contatto non trovato!");
		}
	}
	
	public static void cercaConNome(String nome,HashMap<String,String> r){
		if(r.containsKey(nome)) {
			System.out.println("Il numero di " + nome + " è: " + r.get(nome));
		} else {
			System.out.println("Contatto non trovato!");
		}
	}
	
	
}

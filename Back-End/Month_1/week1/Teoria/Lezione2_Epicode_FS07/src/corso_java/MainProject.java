package corso_java;

public class MainProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("MainProject");
		
		/*Veicolo v = new Veicolo();
		v.marca = "Fiat";
		v.modello = "500";
		v.colore = "Nera";
		v.cilindrata = 1200;
		v.targa = "AB123CD";*/
		Veicolo v1 = new Veicolo("500", "Fiat", "AB123CD", "Nera", 1200);
		//System.out.println(v1.matricola);
		Veicolo v2 = new Veicolo("Fiesta", "Ford", 1200);
		//System.out.println(v2.matricola);
		v2.colore = "Bianco";
		v2.targa = "ZA987QW";
		Veicolo v3 = new Veicolo("X5", "BMW", "Verde", 2500);
		//System.out.println(v3.matricola);
		v3.targa = "CD654PO";
		Veicolo v4 = new Veicolo("500", "Fiat", "AB123CD", "Nera", 1200);
		//System.out.println(v4.matricola);
		Veicolo v5 = v1;
		v3 = v5;
		
		System.out.println(v1.info());
		System.out.println(v2.info());
		System.out.println(v3.info());
		
		
		int x = 5;
		int y = 5;
		int z = x;
		x = z;
		System.out.println(z);
		System.out.println(x);
		z = 10;
		System.out.println(z);
		System.out.println(x);
		
		
		
		System.out.println(x == y);
		
		System.out.println(v1 == v4);
		System.out.println(v1 == v5);
		
		System.out.println(v1.info());
		System.out.println(v5.info());
		v5.targa = "123456789";
		System.out.println(v1.info());
		System.out.println(v5.info());
		
		
		
		int tNum = 10;
		System.out.println(tNum);
		testInt(tNum);
		System.out.println(tNum);
		
		Veicolo tv = new Veicolo("500", "Fiat", "AB123CD", "Nera", 1200);
		//System.out.println(tv.matricola);
		System.out.println(tv.info());
		testVeicolo(v3);
		System.out.println(v3.info());
		
		System.out.println("N. Veicoli: " + Veicolo.count);
		
		tv.start();
		tv.stop();
		Veicolo.Test();
		
		System.out.println(tv.tipo);
		System.out.println(v4.tipo);
		System.out.println(v1.tipo);
		System.out.println(v3.tipo);
		
		v3.tipo = "Tipo Automobile";
		
		System.out.println(tv.tipo);
		System.out.println(v4.tipo);
		System.out.println(v1.tipo);
		System.out.println(v3.tipo);
		
		
		//System.out.println(tv.info() + " Matricola: " + tv.matricola);
		//System.out.println(v4.info() + " Matricola: " + v4.matricola);
		
		Automobile a1 = new Automobile("500", "Fiat", "AB123CD");
		Automobile a2 = new Automobile("500", "Fiat", "AB123CD");
		Automobile a3 = a2;
		
		System.out.println(a1.info());
		System.out.println(a2.info());
		System.out.println(a1 == a2);
		System.out.println(a1.equals(a2));
		System.out.println(a3 == a2);
		System.out.println(a3.equals(a2));
		
		System.out.println(a2.getClass());
		System.out.println(a2);
		
		
		
		
		String t0 = new String("Test");
		String t1 = "Ciao";
		String t2 = "Ciao";
		System.out.println(t1 == t2);
		System.out.println(t1.equals(t2));
		
		Automobile[] arr = new Automobile[5];
		System.out.println(arr);
		pushArr(arr, a1);
		System.out.println(arr[0]);
		

	}
	
	public static void testInt(int param) {
		param = 25;
	}
	
	public static void testVeicolo(Veicolo param) {
		param.marca = "---";
	}
	
	public static void pushArr(Automobile[] veicoli, Automobile v) {
		veicoli[0] = v;
	}

}


public class Rettangolo {

	// altezza e larghezza
	int h;
	int w;

	public Rettangolo(int h, int w) {
		this.h = h;
		this.w = w;
	}

	// calcolo perimetro
	static int perimetro(int h, int w) {
		return (h * 2) + (w * 2);
	}

	// calcolo area
	static int area(int h, int w) {
		return h * w;
	}

	// stampa a video di un singolo rettangolo
	void stampaRettangolo() {
		int p = Rettangolo.perimetro(this.h, this.w);
		int a = Rettangolo.area(this.h, this.w);
		System.out.println("Il perimetro del rettangolo è: " + p);
		System.out.println("L'area del rettangolo è: " + a);
	}

	// stampa a video di due rettangoli, più somma aree e perimetri
	void stampaDueRettangoli(Object r) {
		Rettangolo _r = (Rettangolo) r;
		// primo rettangolo
		int p1 = Rettangolo.perimetro(this.h, this.w);
		int a1 = Rettangolo.area(this.h, this.w);
		// secondo rettangolo
		int p2 = Rettangolo.perimetro(_r.h, _r.w);
		int a2 = Rettangolo.area(_r.h, _r.w);
		// somme
		int sommaPerimetro = p1 + p2;
		int sommaArea = a1 + a2;

		System.out.println("Il perimetro del primo rettangolo è: " + p1);
		System.out.println("L'area del primo rettangolo è: " + a1);
		System.out.println("------------------------------");
		System.out.println("Il perimetro del secondo rettangolo è: " + p2);
		System.out.println("L'area del secondo rettangolo è: " + a2);
		System.out.println("------------------------------");
		System.out.println("La somma dei perimetri è: " + sommaPerimetro);
		System.out.println("La somma delle aree è: " + sommaArea);
	}
}

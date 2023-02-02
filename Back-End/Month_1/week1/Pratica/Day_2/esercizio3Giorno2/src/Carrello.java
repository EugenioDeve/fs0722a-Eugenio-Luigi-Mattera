public class Carrello {

	int cliente;
	Articolo[] elencoArticoli;
	double totale;

	public Carrello(int cliente, Articolo[] elencoArticoli) {
		this.cliente = cliente;
		this.elencoArticoli = elencoArticoli;
		this.totale = this.totale();
		}

	double totale() {
		int arrLen = this.elencoArticoli.length;
		double tot = 0;
		for(int i = 0; i < arrLen; i++) {
			tot += elencoArticoli[i].prezzo;
		}
		return tot;
	}
}
package sonstige;
import article.Article;

public class Sonstige extends Article{
	


	public int fsk;
	
	public Sonstige(int NFsk, String kategorie, String produkt, Double einkaufspreis, Double verkaufspreis, int prop) {
		super(kategorie, produkt, einkaufspreis, verkaufspreis, prop);
		fsk = NFsk;
 		//initialisierung der Klasse 
	}

	public int getFsk() {
		return fsk;
	}

	public void setFsk(int NFsk) {
		fsk = NFsk;
	}

}

package sonstige;
import article.Article;

public class Sonstige extends Article{
	


	public int fsk;
	
	public Sonstige(int NFsk, String kategorie, String produkt, Double einkaufspreis, Double verkaufspreis) {
		super(kategorie, produkt, einkaufspreis, verkaufspreis);
		fsk = NFsk;
		// TODO Auto-generated constructor stub
	}

	public int getMhd() {
		return fsk;
	}

	public void setMhd(int NFsk) {
		fsk = NFsk;
	}

}

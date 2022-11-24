package haushaltsartikel;
import article.Article;

public class Haushaltsartikel extends Article{
	


	public Double ra;
	
	public Haushaltsartikel(Double nRa, String kategorie, String produkt, Double einkaufspreis, Double verkaufspreis) {
		super(kategorie, produkt, einkaufspreis, verkaufspreis);
		ra = nRa;
//initialisierung der Klasse 
	}

	public Double getRa() {
		return ra;
	}

	public void setRa(Double nRa) {
		ra = nRa;
	}

}

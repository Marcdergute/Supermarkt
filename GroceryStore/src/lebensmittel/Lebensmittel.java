package lebensmittel;
import article.Article;

public class Lebensmittel extends Article{
	


	public String mhd;
	
	public Lebensmittel(String nMhd, String kategorie, String produkt, Double einkaufspreis, Double verkaufspreis, int prop) {
		super(kategorie, produkt, einkaufspreis, verkaufspreis, prop);
		mhd = nMhd;
 // //initialisierung der Klasse 
	}

	public String getMhd() {
		return mhd;
	}

	public void setMhd(String nMhd) {
		mhd = nMhd;
	}

}

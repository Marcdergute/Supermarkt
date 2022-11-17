package lebensmittel;
import article.Article;

public class Lebensmittel extends Article{
	


	public String mhd;
	
	public Lebensmittel(String nMhd, String kategorie, String produkt, Double einkaufspreis, Double verkaufspreis) {
		super(kategorie, produkt, einkaufspreis, verkaufspreis);
		mhd = nMhd;
		// TODO Auto-generated constructor stub
	}

	public String getMhd() {
		return mhd;
	}

	public void setMhd(String nMhd) {
		mhd = nMhd;
	}

}

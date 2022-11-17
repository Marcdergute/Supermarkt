package article;

import article.Article;

public class Article {
	
	public String kategorie;
    public String produkt;
    public Double einkaufspreis;
    public Double verkaufspreis;
    private String Mhd;
    private String Ra;
    private String Fsk;

 

    public Article(String kategorie, String produkt, Double einkaufspreis, Double verkaufspreis) {
		super();
		this.kategorie = kategorie;
		this.produkt = produkt;
		this.einkaufspreis = einkaufspreis;
		this.verkaufspreis = verkaufspreis;
	}

    public void setEigenschaften(Article pObj) {
    	if(pObj.getKategorie().equals("Lebensmittel"))
    	{
    		pObj.setMHD("Mindesthaltbarkeitsdatum");
    	}
    	else if (pObj.getKategorie().equals("Haushaltsartikel")) {
    		pObj.setRA("Recycling-Anteil");
    	}else if (pObj.getKategorie().equals("Sonstige")) {
    		pObj.setFSK("FSK-Kategorie");
    	}
    }
	public String getKategorie() {
        return kategorie;
    }

    public String getProdukt() {
        return produkt;
    }

    public Double getEinkaufspreis() {
        return einkaufspreis;
    }

    public Double getVerkaufspreis() {
        return verkaufspreis;
    }


    public boolean equals(Article obj) {
        return super.equals(obj);
    }

	public String getMHD() {
		return Mhd;
	}

	public void setMHD(String weitereEigenschaften) {
		this.Mhd = weitereEigenschaften;
	}
	
	public String getRA() {
		return Ra;
	}

	public void setRA(String weitereEigenschaften) {
		this.Ra = weitereEigenschaften;
	}
	
	public String getFSK() {
		return Fsk;
	}

	public void setFSK(String weitereEigenschaften) {
		this.Fsk = weitereEigenschaften;
	}
}

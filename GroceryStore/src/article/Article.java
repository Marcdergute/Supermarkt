package article;

import article.Article;

public class Article {
	
	
    public String produkt;
    public Double einkaufspreis;
    public Double verkaufspreis;
    public String kategorie;
    private String Ra;
    private String Fsk;

 

    public Article(String kategorie, String produkt, Double einkaufspreis, Double verkaufspreis) {
		super();
		this.kategorie = kategorie;
		this.produkt = produkt;
		this.einkaufspreis = einkaufspreis;
		this.verkaufspreis = verkaufspreis;
	}

    


    public String getProdukt() {
        return produkt;
    }
    
    public String getKategorie() {
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

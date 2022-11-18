package article;

import article.Article;

public class Article {


    public String produkt;
    public Double einkaufspreis;
    public Double verkaufspreis;
    public String kategorie;


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
        return kategorie;
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


}




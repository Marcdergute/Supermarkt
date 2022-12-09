package article;

import article.Article;

/**
 * Repräsentiert einen Artikel.
 */
public class Article {

    /** Der Name des Produkts. */
    public String produkt;
    
    /** Die Anzahl der Artikel. */
    public int prop;
    
    /** Der Einkaufspreis des Produkts. */
    public Double einkaufspreis;
    
    /** Der Verkaufspreis des Produkts. */
    public Double verkaufspreis;
    
    /** Die Kategorie des Produkts. */
    public String kategorie;

    /**
     * Erstellt eine neue Instanz der Klasse {@code Article}.
     * @param kategorie Die Kategorie des Produkts.
     * @param produkt Der Name des Produkts.
     * @param einkaufspreis Der Einkaufspreis des Produkts.
     * @param verkaufspreis Der Verkaufspreis des Produkts.
     * @param prop Die Anzahl der Artikel.
     */
    public Article(String kategorie, String produkt, Double einkaufspreis, Double verkaufspreis, int prop) {
        super();
        this.kategorie = kategorie;
        this.produkt = produkt;
        this.einkaufspreis = einkaufspreis;
        this.verkaufspreis = verkaufspreis;
        this.prop = prop;
    }

    /**
     * Gibt den Namen des Produkts zurück.
     * @return Den Namen des Produkts.
     */
    public String getProdukt() {
        return produkt;
    }

    /**
     * Gibt die Kategorie des Produkts zurück.
     * @return Die Kategorie des Produkts.
     */
    public String getKategorie() {
        return kategorie;
    }

    /**
     * Gibt den Einkaufspreis des Produkts zurück.
     * @return Den Einkaufspreis des Produkts.
     */
    public Double getEinkaufspreis() {
        return einkaufspreis;
    }

    /**
     * Gibt den Verkaufspreis des Produkts zurück.
     * @return Den Verkaufspreis des Produkts.
     */
    public Double getVerkaufspreis() {
        return verkaufspreis;
    }
    
    /**
     * Gibt die Anzahl der Artikel zurück.
     * @return Die Anzahl der Artikel.
     */
    public int getProp() {
        return prop;
    }

    /**
     * Vergleicht diesen Artikel mit einem anderen Objekt auf Gleichheit.
     *
     * @param obj Das andere Objekt, mit dem verglichen wird.
     * @return true, wenn die beiden Objekte gleich sind, false ansonsten.
     */
    public boolean equals(Article obj) {
        return super.equals(obj);
    }


}




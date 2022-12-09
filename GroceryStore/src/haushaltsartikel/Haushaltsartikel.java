/**
 * Eine Klasse, die verschiedene Haushaltsartikel repräsentiert.
 *
 * @author Marc Grethlein
 * @version 1.0
 */
package haushaltsartikel;

import article.Article;

public class Haushaltsartikel extends Article {

    /**
     * Der Recycling-Anteil des Artikels in Prozent.
     */
    public Double ra;

    /**
     * Erstellt ein neues Haushaltsartikel-Objekt mit den angegebenen Attributen.
     *
     * @param nRa Der Recycling-Anteil des Artikels in Prozent.
     * @param kategorie Die Kategorie des Artikels.
     * @param produkt Der Name des Produkts.
     * @param einkaufspreis Der Einkaufspreis des Artikels.
     * @param verkaufspreis Der Verkaufspreis des Artikels.
     * @param prop Die Menge des Artikels, die im Lager verfügbar ist.
     */
    public Haushaltsartikel(Double nRa, String kategorie, String produkt, Double einkaufspreis, Double verkaufspreis, int prop) {
        super(kategorie, produkt, einkaufspreis, verkaufspreis, prop);
        ra = nRa;
    }

    /**
     * Gibt den Recycling-Anteil des Artikels in Prozent zurück.
     *
     * @return Der Recycling-Anteil des Artikels in Prozent.
     */
    public Double getRa() {
        return ra;
    }


}
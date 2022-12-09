/**
 * Eine Klasse, die verschiedene sonstige Artikel repräsentiert.
 *
 * @author Marc Grethlein
 * @version 1.1
 */
package sonstige;

import article.Article;

public class Sonstige extends Article {

    /**
     * Die FSK (Freiwillige Selbstkontrolle der Filmwirtschaft) des Artikels.
     */
    public int fsk;

    /**
     * Erstellt ein neues Sonstiges-Objekt mit den angegebenen Attributen.
     *
     * @param NFsk Die FSK des Artikels.
     * @param kategorie Die Kategorie des Artikels.
     * @param produkt Der Name des Produkts.
     * @param einkaufspreis Der Einkaufspreis des Artikels.
     * @param verkaufspreis Der Verkaufspreis des Artikels.
     * @param prop gibt an ob dieses Produkt von einem bestimmten Warenkorb modus exkludiert ist
     */
    public Sonstige(int NFsk, String kategorie, String produkt, Double einkaufspreis, Double verkaufspreis, int prop) {
        super(kategorie, produkt, einkaufspreis, verkaufspreis, prop);
        fsk = NFsk;
    }

    /**
     * Gibt die FSK des Artikels zurück.
     *
     * @return Die FSK des Artikels.
     */
    public int getFsk() {
        return fsk;
    }
}


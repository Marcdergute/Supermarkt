/**
 * Eine Klasse, die verschiedene Lebensmittel-Artikel repräsentiert.
 *
 * @author Marc Grethlein
 * @version 1.1
 */
package lebensmittel;

import article.Article;

public class Lebensmittel extends Article {

    /**
     * Das Mindesthaltbarkeitsdatum des Artikels.
     */
    public String mhd;

    /**
     * Erstellt ein neues Lebensmittel-Objekt mit den angegebenen Attributen.
     *
     * @param nMhd Das Mindesthaltbarkeitsdatum des Artikels.
     * @param kategorie Die Kategorie des Artikels.
     * @param produkt Der Name des Produkts.
     * @param einkaufspreis Der Einkaufspreis des Artikels.
     * @param verkaufspreis Der Verkaufspreis des Artikels.
     * @param prop gibt an ob dieses Produkt von einem bestimmten Warenkorb modus exkludiert ist
     */
    public Lebensmittel(String nMhd, String kategorie, String produkt, Double einkaufspreis, Double verkaufspreis, int prop) {
        super(kategorie, produkt, einkaufspreis, verkaufspreis, prop);
        mhd = nMhd;
    }

    /**
     * Gibt das Mindesthaltbarkeitsdatum des Artikels zurück.
     *
     * @return Das Mindesthaltbarkeitsdatum des Artikels.
     */
    public String getMhd() {
        return mhd;
    }
}
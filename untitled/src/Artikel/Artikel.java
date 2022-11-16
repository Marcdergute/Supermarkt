package Artikel;
import Haushaltsartikel.Haushaltsartikel;
public class Artikel {
    public Haushaltsartikel kategorie;
    public String produkt;
    public Double einkaufspreis;
    public Double verkaufspreis;

    public Artikel(Haushaltsartikel nKategorie, String nProdukt, Double nEinkaufspreis, Double nVerkaufspreis) {
        kategorie = nKategorie;
        produkt = nProdukt;
        einkaufspreis = nEinkaufspreis;
        verkaufspreis = nVerkaufspreis;
    }

    public Haushaltsartikel getKategorie() {
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


    public boolean equals(Artikel obj) {
        return super.equals(obj);
    }
}

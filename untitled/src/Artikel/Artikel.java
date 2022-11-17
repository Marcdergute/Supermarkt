package Artikel;
import Kategorie.Kategorie;
public class Artikel {
    public Kategorie kategorie;
    public String produkt;
    public Double einkaufspreis;
    public Double verkaufspreis;

    public Artikel(Kategorie nKategorie, String nProdukt, Double nEinkaufspreis, Double nVerkaufspreis) {
        kategorie = nKategorie;
        produkt = nProdukt;
        einkaufspreis = nEinkaufspreis;
        verkaufspreis = nVerkaufspreis;
    }

    public Kategorie getKategorie() {
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

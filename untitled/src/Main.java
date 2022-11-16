import Artikel.Artikel  ;
import Haushaltsartikel.Haushaltsartikel;

public class Main {


    public static void main(String[] args) {

        Artikel b = new Artikel(new Haushaltsartikel(0.06),"Hi",0.99, 2.99);

        System.out.print(b.getEinkaufspreis() + " "+ b.getProdukt());
        System.out.println(  b.getKategorie().getRecyclingAnteil());

    }
}
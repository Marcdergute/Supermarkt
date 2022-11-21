package importing;

import article.Article;
import haushaltsartikel.Haushaltsartikel;
import lebensmittel.Lebensmittel;
import sonstige.Sonstige;
import warenkorb.Warenkorb;

import java.util.ArrayList;

public class Importing {

    public static ArrayList<Article> articleList = new ArrayList<Article>();
    public static ArrayList <Warenkorb> warenkorbList = new ArrayList<Warenkorb>();

    public static void  articleGenerate(){


        articleList.add(new Lebensmittel("19.05.22" , "Lebensmittel", "Mineralwasser",0.40, 0.89) );
        articleList.add(new Lebensmittel("06.08.22" , "Lebensmittel", "Toastbrot",0.50, 1.99) );
        articleList.add(new Lebensmittel("24.05.22", "Lebensmittel", "Butter",0.39, 1.49));
        articleList.add(new Lebensmittel("04.07.22", "Lebensmittel", "Wurst",0.69, 1.99));
        articleList.add(new Lebensmittel("15.01.22", "Lebensmittel", "Käse",0.49, 1.29));
        articleList.add(new Lebensmittel("10.10.22", "Lebensmittel", "Flasche Wein",2.30, 6.99));
        articleList.add(new Haushaltsartikel(0.5, "Haushaltsartikel", "Klobürste",0.99, 4.99));
        articleList.add(new Haushaltsartikel(0.75, "Haushaltsartikel", "Plastikbesteck",0.05, 0.69));
        articleList.add(new Haushaltsartikel(0.99, "Haushaltsartikel",  "Putzlappen",0.15, 1.19));
        articleList.add(new Haushaltsartikel(0.01, "Haushaltsartikel",  "Zahnpasta",0.50, 1.99));
        articleList.add(new Sonstige(18, "Sonstige", "DVD Actionfilm",0.99, 8.99));
        articleList.add(new Sonstige(0, "Sonstige", "DVD Familienfilm",0.89, 7.99));


    }


}

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


        articleList.add(new Lebensmittel(dateRandom() , "Lebensmittel", "Mineralwasser",0.40, 0.89) );
        articleList.add(new Lebensmittel(dateRandom() , "Lebensmittel", "Toastbrot",0.50, 1.99) );
        articleList.add(new Lebensmittel(dateRandom(), "Lebensmittel", "Butter",0.39, 1.49));
        articleList.add(new Lebensmittel(dateRandom(), "Lebensmittel", "Wurst",0.69, 1.99));
        articleList.add(new Lebensmittel(dateRandom(), "Lebensmittel", "Käse",0.49, 1.29));
        articleList.add(new Lebensmittel(dateRandom(), "Lebensmittel", "Flasche Wein",2.30, 6.99));
        articleList.add(new Haushaltsartikel(0.5, "Haushaltsartikel", "Klobürste",0.99, 4.99));
        articleList.add(new Haushaltsartikel(0.75, "Haushaltsartikel", "Plastikbesteck",0.05, 0.69));
        articleList.add(new Haushaltsartikel(0.99, "Haushaltsartikel",  "Putzlappen",0.15, 1.19));
        articleList.add(new Haushaltsartikel(0.01, "Haushaltsartikel",  "Zahnpasta",0.50, 1.99));
        articleList.add(new Sonstige(18, "Sonstige", "DVD Actionfilm",0.99, 8.99));
        articleList.add(new Sonstige(0, "Sonstige", "DVD Familienfilm",0.89, 7.99));


    }
    public static String randBetween(int start, int end) {
         int rand = start + (int)Math.round(Math.random() * (end - start));
         
         return Integer.toString(rand) ;
    }
    public static String dateRandom() {
    	
    	 return randBetween(1,28) + "." + randBetween(1,12) +"."+ randBetween(2023,2026);
    }


}

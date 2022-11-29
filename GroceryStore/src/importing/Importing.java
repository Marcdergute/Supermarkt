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
        articleList.add(new Lebensmittel(dateRandom(), "Lebensmittel", "Club Mate",0.49, 1.00));
        articleList.add(new Lebensmittel(dateRandom(), "Lebensmittel", "Nudeln",0.95, 2.99));
        articleList.add(new Lebensmittel(dateRandom(), "Lebensmittel", "Tomatensoße",0.80, 2.59));
        articleList.add(new Haushaltsartikel(randDouble(), "Haushaltsartikel", "Klobürste",0.99, 4.99));
        articleList.add(new Haushaltsartikel(randDouble(), "Haushaltsartikel", "Plastikbesteck",0.05, 0.69));
        articleList.add(new Haushaltsartikel(randDouble(), "Haushaltsartikel",  "Putzlappen",0.15, 1.19));
        articleList.add(new Haushaltsartikel(randDouble(), "Haushaltsartikel",  "Zahnpasta",0.50, 1.99));
        articleList.add(new Haushaltsartikel(randDouble(), "Haushaltsartikel",  "Seife",0.45, 1.99));
        articleList.add(new Sonstige(18, "Sonstige", "DVD Actionfilm",0.99, 18.99));
        articleList.add(new Sonstige(0, "Sonstige", "DVD Familienfilm",0.89, 7.99));
        articleList.add(new Sonstige(18, "Sonstige", "Auto",800.09, 5000.0));


    }
    public static String randBetween(int start, int end) {
         int rand = start + (int)Math.round(Math.random() * (end - start));
         
         return Integer.toString(rand) ;
    }
    public static double randDouble() {
        return  5 + (int)Math.round(Math.random() * (98 - 5));
        
        
   }
    public static String dateRandom() {
    	
    	 return randBetween(1,28) + "." + randBetween(1,12) +"."+ randBetween(2023,2026);
    }


}

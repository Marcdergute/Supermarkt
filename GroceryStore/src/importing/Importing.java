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

    	//0 = nothing, 1 = eco, 2 = youth
        articleList.add(new Lebensmittel(dateRandom() , "Groceries", "Bottle Water 0.5l",0.20, 0.69, 0));
        articleList.add(new Lebensmittel(dateRandom() , "Groceries", "Bottle Water 1l",0.40, 0.99, 0));
        articleList.add(new Lebensmittel(dateRandom() , "Groceries", "Bottle Water 1.5l",0.60, 1.29, 0));
        articleList.add(new Lebensmittel(dateRandom() , "Groceries", "Bottle Milk 1.5%",1.00, 1.49, 0));
        articleList.add(new Lebensmittel(dateRandom() , "Groceries", "Bottle Milk 3.5%",1.00, 1.49, 0));
        articleList.add(new Lebensmittel(dateRandom() , "Groceries", "Bottle Soy Milk",0.90, 1.29, 0));
        articleList.add(new Lebensmittel(dateRandom() , "Groceries", "Bottle Oat Milk",1.00, 1.49, 0));
        articleList.add(new Lebensmittel(dateRandom(), "Groceries", "Apples 1kg",0.40, 2.79, 0));
        articleList.add(new Lebensmittel(dateRandom(), "Groceries", "Banana 1x",0.10, 0.49, 0));
        articleList.add(new Lebensmittel(dateRandom(), "Groceries", "Avocado",0.20, 0.99, 0));
        articleList.add(new Lebensmittel(dateRandom(), "Groceries", "Cucumber",0.80, 1.99, 0));
        articleList.add(new Lebensmittel(dateRandom(), "Groceries", "Cherry Tomatoes 500g",2.90, 3.99, 0));
        articleList.add(new Lebensmittel(dateRandom(), "Groceries", "Roma Tomatoes 500g",1.90, 2.49, 0));
        articleList.add(new Lebensmittel(dateRandom(), "Groceries", "Campari Tomatoes 500g",2.10, 2.99, 0));
        articleList.add(new Lebensmittel(dateRandom() , "Groceries", "Toast 500g",0.50, 1.99, 0));
        articleList.add(new Lebensmittel(dateRandom(), "Groceries", "Butter 250g",0.30, 1.49, 0));
        articleList.add(new Lebensmittel(dateRandom(), "Groceries", "4x Sausage 500g",2.60, 5.99, 1));
        articleList.add(new Lebensmittel(dateRandom(), "Groceries", "Prosciutto 80g",1.50, 3.79, 1));
        articleList.add(new Lebensmittel(dateRandom(), "Groceries", "Bacon 200g",1.40, 3.49, 1));
        articleList.add(new Lebensmittel(dateRandom(), "Groceries", "Minced Beef 500g",2.40, 3.99, 1));
        articleList.add(new Lebensmittel(dateRandom(), "Groceries", "Chicken Breast 600g",3.90, 5.99, 1));
        articleList.add(new Lebensmittel(dateRandom(), "Groceries", "Cheddar 150g",1.20, 2.99, 1));
        articleList.add(new Lebensmittel(dateRandom(), "Groceries", "Gauda Young 400g",1.90, 3.29, 1));
        articleList.add(new Lebensmittel(dateRandom(), "Groceries", "Bread 500g",0.50, 1.99, 0));
        articleList.add(new Lebensmittel(dateRandom(), "Groceries", "Brezel 100g",0.20, 0.69, 0));
        articleList.add(new Lebensmittel(dateRandom(), "Groceries", "Olive Oil 0.75l",3.10, 5.29, 0));
        articleList.add(new Lebensmittel(dateRandom(), "Groceries", "Sunflower Oil 0.75l",2.10, 3.49, 0));
        articleList.add(new Lebensmittel(dateRandom(), "Groceries", "Rape Oil 0.75l",2.10, 3.49, 0));
        articleList.add(new Lebensmittel(dateRandom(), "Groceries", "Wine",2.30, 6.99, 2));
        articleList.add(new Lebensmittel(dateRandom(), "Groceries", "Beer 6x 0.33l",1.30, 4.49, 2));
        articleList.add(new Lebensmittel(dateRandom(), "Groceries", "Beer 20x 0.5l",5.80, 18.99, 2));
        articleList.add(new Lebensmittel(dateRandom(), "Groceries", "Wine",2.30, 6.99, 2));
        articleList.add(new Lebensmittel(dateRandom(), "Groceries", "Wine",2.30, 6.99, 2));
        articleList.add(new Haushaltsartikel(0.50, "Household Funds", "Toilet Brush",0.90, 4.99, 0));
        articleList.add(new Haushaltsartikel(0.75, "Household Funds", "Plastic Cutlery",0.15, 0.69, 1));
        articleList.add(new Haushaltsartikel(0.99, "Household Funds",  "Cleaning Rags",0.15, 1.19, 0));
        articleList.add(new Haushaltsartikel(0.30, "Household Funds",  "Toothpaste",0.50, 1.99, 0));
        articleList.add(new Haushaltsartikel(0.30, "Household Funds",  "All-Purpose_Cleaner",1.50, 3.99, 0));
        articleList.add(new Haushaltsartikel(0.40, "Household Funds",  "Glass Cleaner",0.50, 1.99, 0));
        articleList.add(new Haushaltsartikel(0.01, "Household Funds",  "Soap",0.40, 1.49, 0));
        articleList.add(new Haushaltsartikel(0.10, "Household Funds",  "Light Bulb E27 40Watt",3.10, 5.99, 0));
        articleList.add(new Haushaltsartikel(0.01, "Household Funds",  "Light Bulb E14 40Watt",4.00, 6.99, 0));
        articleList.add(new Sonstige(18, "Other", "DVD ES",1.99, 8.99, 2));
        articleList.add(new Sonstige(0, "Other", "DVD Disney Pixar Finding Nemo",1.89, 9.49, 0));
        articleList.add(new Sonstige(0, "Other", "DVD Disney Frozen",1.89, 9.49, 0));
        articleList.add(new Sonstige(12, "Other", "DVD Back to the Future",0.89, 8.99, 0));
        articleList.add(new Sonstige(12, "Other", "DVD Back to the Future II",0.89, 8.99, 0));
        articleList.add(new Sonstige(12, "Other", "DVD Back to the Future III",0.89, 8.99, 0));
        articleList.add(new Sonstige(12, "Other", "DVD Transformers",0.89, 10.99, 0));
        articleList.add(new Sonstige(16, "Other", "DVD The Godfather",0.89, 7.99, 2));
        articleList.add(new Sonstige(12, "Other", "DVD Avatar",1.99, 10.99, 0));
        articleList.add(new Sonstige(12, "Other", "DVD Interstellar",1.89, 10.99, 0));
        articleList.add(new Sonstige(12, "Other", "DVD Marvel Avengers: Endgame",1.89, 10.99, 0));


    }
    public static String randBetween(int start, int end) {
         int rand = start + (int)Math.round(Math.random() * (end - start));
         
         return Integer.toString(rand) ;
    }
    public static String dateRandom() {
    	
    	 return randBetween(1,28) + "." + randBetween(1,12) +"."+ randBetween(2023,2026);
    }


}

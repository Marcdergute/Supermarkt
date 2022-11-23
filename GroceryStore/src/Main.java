
import article.Article  ;
import lebensmittel.Lebensmittel;
import haushaltsartikel.Haushaltsartikel;
import sonstige.Sonstige;
import StorePanel.OptionPaneExample;
import StorePanel.StorePanel;
import java.util.ArrayList;
import java.util.Random;

import warenkorb.Warenkorb;
import importing.Importing;

import static importing.Importing.articleGenerate;


public class Main {

	public static ArrayList <Article> articleList = new ArrayList<Article>();
	public static ArrayList <Warenkorb> warenkorbList = new ArrayList<Warenkorb>();
	public static double dailyIncome;


	

	public static void main(String[] args) {
		
		articleGenerate();

		StorePanel.startStorePanel();

	}
}





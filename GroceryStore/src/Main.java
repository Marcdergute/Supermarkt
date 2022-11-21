
import article.Article  ;
import lebensmittel.Lebensmittel;
import haushaltsartikel.Haushaltsartikel;
import sonstige.Sonstige;
import StorePanel.StorePanel;
import java.util.ArrayList;

import warenkorb.Warenkorb;
import importing.Importing;

import static importing.Importing.articleGenerate;


public class Main {

	public static ArrayList <Article> articleList = new ArrayList<Article>();
	public static ArrayList <Warenkorb> warenkorbList = new ArrayList<Warenkorb>();



	public static void allArticlePrint(){
		System.out.println("#  Kategorie    Produkt     Einkaufspreis Verkaufspreis Weiteres ");
		for (int i = 0; i < articleList.size(); i++) {

			System.out.print(i + " ");
			System.out.print(articleList.get(i).getKategorie() + " ");
			System.out.print(articleList.get(i).getEinkaufspreis() + " ");
			System.out.print(articleList.get(i).getVerkaufspreis() + " ");
			System.out.print(articleList.get(i).getProdukt() + " ");

			try {
				Lebensmittel b = (Lebensmittel) articleList.get(i);
				System.out.println(b.getMhd());
			} catch (ClassCastException exc){}
			try {
				Haushaltsartikel b = (Haushaltsartikel) articleList.get(i);
				System.out.println(b.getRa());
			}catch (ClassCastException exc){}
			try {
				Sonstige b = (Sonstige) articleList.get(i);
				System.out.println(b.getFsk());
			}catch (ClassCastException exc){}
		}
	}

	public static String getSpecialProperty(Article article){
		try {
			Lebensmittel b = (Lebensmittel) article;
			return b.getMhd();
		} catch (ClassCastException exc){}
		try {
			Haushaltsartikel b = (Haushaltsartikel) article;
			return String.valueOf(b.getRa());
		}catch (ClassCastException exc){}
		try {
			Sonstige b = (Sonstige) article;
			String d = String.valueOf(b.getFsk());
			return d;
		}catch (ClassCastException exc){}
		return null;
	}
	public static Article findArticle(String produkt) {

		for (int i = 0; i < articleList.size(); i++) {
			if (articleList.get(i).getProdukt() == produkt) {
				return articleList.get(i);
			}

		}

		return null;
	}
	public static String[] getAllProdukt(){
		String[] produkte = new String[articleList.size()];
		for (int i = 0; i < articleList.size(); i++) {
			produkte[i] = articleList.get(i).getProdukt();



		}
		return produkte;
	}
	public static void main(String[] args) {

		articleGenerate();
		
		StorePanel.startStorePanel();

	}
}
		
		
    


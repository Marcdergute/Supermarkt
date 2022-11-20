
import article.Article  ;
import lebensmittel.Lebensmittel;
import haushaltsartikel.Haushaltsartikel;
import sonstige.Sonstige;
import StorePanel.StorePanel;
import java.util.ArrayList;

import warenkorb.Warenkorb;



public class Main {

	public static ArrayList <Article> articleList = new ArrayList<Article>();
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

	public static void allArticlePrint(){
		System.out.println("#  Kategorie    Produkt     Einkaufspreis Verkaufspreis Weiteres ");
		for (int i = 0; i < articleList.size(); i++) {

			System.out.print(i + " ");
			System.out.print(articleList.get(i).getKategorie() + " ");
			System.out.print(articleList.get(i).getEinkaufspreis() + " ");
			System.out.print(articleList.get(i).getVerkaufspreis() + " ");
			System.out.print(articleList.get(i).getProdukt() + " ");



//			if(articleList.get(i).getKategorie() == "Lebensmittel"){
//				Lebensmittel b = (Lebensmittel) articleList.get(0);
//
//				System.out.println(b.getMhd());
//			}
//			if(articleList.get(i).getKategorie() == "Haushaltsartikel"){
//				Haushaltsartikel c = (Haushaltsartikel) articleList.get(0);
//				System.out.println(c.getRa());
//			}
//			if(articleList.get(i).getKategorie() == "Sonstige"){
//				Sonstige d = (Sonstige) articleList.get(0);
//				System.out.println(d.getFsk());
//			}

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

		warenkorbList.add(new Warenkorb(3));
		warenkorbList.get(0).warenkorbAdd(articleList.get(5));
		warenkorbList.get(0).warenkorbAdd(findArticle("Zahnpasta"));
		warenkorbList.get(0).warenkorbPrint();
		System.out.println(getSpecialProperty(warenkorbList.get(0).list.get(0)));
		System.out.println(warenkorbList.get(0).cost);
		warenkorbList.remove(0);
		System.out.println(warenkorbList.size());
		
		StorePanel.startStorePanel();
	}
}
		
		
    


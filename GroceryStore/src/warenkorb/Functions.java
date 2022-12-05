package warenkorb;

import java.util.ArrayList;
import java.util.Random;

import article.Article;
import haushaltsartikel.Haushaltsartikel;
import lebensmittel.Lebensmittel;
import sonstige.Sonstige;
import static importing.Importing.articleList;

public class Functions {
	public static double dailyIncome;
	
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
			return String.valueOf(b.getRa()*100);
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

	public static void pay(Warenkorb warenkorb) {
		dailyIncome += warenkorb.getCost();
		warenkorb.setPayed(true);
		
		
	}
	public static Warenkorb gift(Double budget){
		Warenkorb w = new Warenkorb(5);
		Random random = new Random();
		while(budget >= 0.69) {
			int r = random.nextInt(articleList.size());
			if (budget >= articleList.get(r).getVerkaufspreis()) {
				if(w.warenkorbAdd(articleList.get(r)))
				budget -= articleList.get(r).getVerkaufspreis();
			}
		}
		return w;
	}
	public static Warenkorb addShoppingCart(int mode){
		Warenkorb w = new Warenkorb(mode);
		
		return w;
	}
	public static boolean addArticleToShoppingCart(Warenkorb w, int index) {
		
		return w.warenkorbAdd(articleList.get(index));
	}
	
	
	public static ArrayList<Integer> highestProduct( Warenkorb warenkorb){
		ArrayList<Integer> highestProductNumber = new ArrayList<Integer>();
		double recyclingRate = 0;
		int highestRecyclingRate = -1;
		int highestMinimumShelfLife = -1;
		int year = 0;
		int month = 0;
		int day = 0;
		for(int i = 0; i< warenkorb.list.size(); i++) {
			Article article = warenkorb.list.get(i);
			if(article.kategorie == "Household Funds") {
				if(recyclingRate < Double.parseDouble(getSpecialProperty(article))/100) {
					recyclingRate = Double.parseDouble(getSpecialProperty(article))/100;
					highestRecyclingRate = i;
				}
			}
			if(article.kategorie == "Groceries") {
				String[] MinimumShelfLife = new String[getSpecialProperty(article).length()];
				MinimumShelfLife = getSpecialProperty(article).split("[.]", 3);
				int nyear = Integer.valueOf(MinimumShelfLife[2]);
				int nmonth = Integer.valueOf(MinimumShelfLife[1]);
				int nday = Integer.valueOf(MinimumShelfLife[1]);
				if(nyear > year) {
					year = nyear;
					month = nmonth;
					day = nday;
					highestMinimumShelfLife = i;
					
				}
				if(nyear == year && nmonth > month) {
					year = nyear;
					month = nmonth;
					day = nday;
					highestMinimumShelfLife = i;
					
				}
				if(nyear == year && nmonth == month && nday > day) {
					year = nyear;
					month = nmonth;
					day = nday;
					highestMinimumShelfLife = i;
					
				}
			}

		}
		if(highestRecyclingRate != -1) {
			highestProductNumber.add(highestRecyclingRate);
		}
		if(highestMinimumShelfLife != -1) {
			highestProductNumber.add(highestMinimumShelfLife);
		}

		return highestProductNumber; 
	}
	public static ArrayList<Integer> lowestProduct( Warenkorb warenkorb){
		ArrayList<Integer> lowestProductNumber = new ArrayList<Integer>();
		double recyclingRate = 1000;
		int lowestRecyclingRate = -1;
		int lowestMinimumShelfLife = -1;
		int year = 9999;
		int month = 99;
		int day = 99;
		for(int i = 0; i< warenkorb.list.size(); i++) {
			Article article = warenkorb.list.get(i);
			if(article.kategorie == "Household Funds") {
				if(recyclingRate > Double.parseDouble(getSpecialProperty(article))/100) {
					recyclingRate = Double.parseDouble(getSpecialProperty(article))/100;
					lowestRecyclingRate = i;
				}
			}
			if(article.kategorie == "Groceries") {
				String[] MinimumShelfLife = new String[getSpecialProperty(article).length()];
				MinimumShelfLife = getSpecialProperty(article).split("[.]", 3);
				int nyear = Integer.valueOf(MinimumShelfLife[2]);
				int nmonth = Integer.valueOf(MinimumShelfLife[1]);
				int nday = Integer.valueOf(MinimumShelfLife[1]);
				if(nyear < year) {
					year = nyear;
					month = nmonth;
					day = nday;
					lowestMinimumShelfLife = i;
					
				}
				if(nyear == year && nmonth < month) {
					year = nyear;
					month = nmonth;
					day = nday;
					lowestMinimumShelfLife = i;
					
				}
				if(nyear == year && nmonth == month && nday < day) {
					year = nyear;
					month = nmonth;
					day = nday;
					lowestMinimumShelfLife = i;
					
				}
			}

		}
		if(lowestRecyclingRate != -1) {
			lowestProductNumber.add(lowestRecyclingRate);
		}
		if(lowestMinimumShelfLife != -1) {
			lowestProductNumber.add(lowestMinimumShelfLife);
		}

		return lowestProductNumber; 
	}

}

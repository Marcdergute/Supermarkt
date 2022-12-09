/**
 * Eine Klasse, die verschiedene Funktionen für den Warenkorb bereitstellt.
 *
 * @author Marc Grethlein und Benjamin Barth
 * @version 1.15
 */
package warenkorb;

import java.util.ArrayList;
import java.util.Random;

import article.Article;
import haushaltsartikel.Haushaltsartikel;
import lebensmittel.Lebensmittel;
import sonstige.Sonstige;
import static importing.Importing.articleList;

public class Functions {
	// Eine statische Variable zum Speichern des täglichen Einkommens.
	public static double dailyIncome;
	
	/**
     * Gibt alle Artikel aus.
     *
     * Diese Methode durchläuft die Liste aller Artikel und gibt jeden einzelnen Artikel auf der Konsole aus.
     * Dabei werden Kategorie, Produkt, Einkaufspreis, Verkaufspreis und das spezielle Merkmal des Artikels (z.B. das Mindesthaltbarkeitsdatum bei Lebensmitteln) angezeigt.
     */
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
	
	/**

	Diese Funktion gibt ein spezielles Merkmal eines Artikels zurück.
	@param article Der Artikel, dessen spezielles Merkmal zurückgegeben werden soll
	@return Das spezielle Merkmal des Artikels. Dies kann entweder das Mindesthaltbarkeitsdatum bei Lebensmitteln, 
	die Recycling-Anteil bei Haushaltsartikeln 
	oder die FSK-Kennzahl bei Sonstigen sein
	*/
	public static String getSpecialProperty(Article article) {
	    if (article instanceof Lebensmittel) {
	        return ((Lebensmittel) article).getMhd();
	    } else if (article instanceof Haushaltsartikel) {
	        return String.valueOf(((Haushaltsartikel) article).getRa() * 100);
	    } else if (article instanceof Sonstige) {
	        return String.valueOf(((Sonstige) article).getFsk());
	    }
	    return null;
	}
	
	/**

	Die Methode findArticle durchläuft eine Liste von Artikeln und sucht nach einem Artikel mit dem angegebenen Namen.
	@param produkt der Name des gesuchten Artikels
	@return Der gefundene Artikel, oder null, falls kein Artikel mit dem angegebenen Namen gefunden wurde.
	*/
	public static Article findArticle(String produkt) {

		for (int i = 0; i < articleList.size(); i++) {
			if (articleList.get(i).getProdukt() == produkt) {
				return articleList.get(i);
			}

		}

		return null;
	}
	
	/**

	Gibt eine Liste von Produkten (Namen) zurück.
	@return eine Liste von Produkten
	*/
	public static String[] getAllProdukt(){
		String[] produkte = new String[articleList.size()];
		for (int i = 0; i < articleList.size(); i++) {
			produkte[i] = articleList.get(i).getProdukt();



		}
		return produkte;
	}

	/**

	Die Methode pay() verarbeitet den Kauf eines Warenkorbes. Es wird das Tageseinkommen um den Gesamtpreis des Warenkorbes erhöht und der Warenkorb wird als bezahlt markiert.
	@param warenkorb der zu bezahlende Warenkorb
	*/
	public static void pay(Warenkorb warenkorb) {
		dailyIncome += warenkorb.getCost();
		warenkorb.setPayed(true);
		
		
	}
	
	/**

	Die Methode gift() erstellt einen neuen Warenkorb und füllt ihn mit zufälligen Artikeln, bis das gegebene Budget aufgebraucht ist.
	@param budget das zur Verfügung stehende Budget für den Warenkorb
	@return der erstellte und gefüllte Warenkorb
	*/
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
	
	/**

	Diese Methode erstellt einen neuen Warenkorb und gibt ihn zurück.

	@param mode Der Modus des Warenkorbs.

	@return Der erstellte Warenkorb.
	*/
	public static Warenkorb addShoppingCart(int mode){
		Warenkorb w = new Warenkorb(mode);
		
		return w;
	}
	
	/**

	Diese Methode fügt einen Artikel in den angegebenen Warenkorb.
	@param w Der Warenkorb, in den der Artikel hinzugefügt werden soll.
	@param index Der Index des Artikels, der hinzugefügt werden soll.
	@return true, wenn der Artikel erfolgreich hinzugefügt wurde, false andernfalls.
	*/
	public static boolean addArticleToShoppingCart(Warenkorb w, int index) {
		
		return w.warenkorbAdd(articleList.get(index));
	}
	
	/**

	Diese Funktion ermittelt das Produkt mit dem höchsten Recycling-Anteil und das Produkt mit der längsten Haltbarkeit im gegebenen Warenkorb.
	@param warenkorb Der Warenkorb, dessen Produkte untersucht werden sollen.
	@return Eine Liste der Indizes der Produkte mit dem höchsten Recycling-Anteil und der längsten Haltbarkeit im Warenkorb.
	*/
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
	
	/**

	Diese Methode sucht im übergebenen Warenkorb nach dem Produkt mit dem geringsten Recyclingfaktor in der Kategorie "Haushaltsartikel"
	und dem Produkt mit der kürzesten Mindesthaltbarkeitsdauer in der Kategorie "Lebensmittelartikel".
	Die Index der gefundenen Produkte werden in einer Liste zurückgegeben.
	@param warenkorb Der Warenkorb, in dem die Produkte gesucht werden sollen
	@return Eine Liste mit dem Index der gefundenen Produkte
	*/
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

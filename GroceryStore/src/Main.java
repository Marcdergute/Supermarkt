
import article.Article  ;
import lebensmittel.Lebensmittel;
import haushaltsartikel.Haushaltsartikel;
import sonstige.Sonstige;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
     

    public static void main(String[] args) {
    	
    	
    	List <Article> list = new ArrayList<Article>();
    	
    	list.add(new Lebensmittel("19.05.22" , "Lebensmittel", "Mineralwasser",0.40, 0.89) );
    	list.add(new Lebensmittel("06.08.22" , "Lebensmittel", "Toastbrot",0.50, 1.99) );
    	list.add(new Lebensmittel("24.05.22", "Lebensmittel", "Butter",0.39, 1.49));
    	list.add(new Lebensmittel("04.07.22", "Lebensmittel", "Wurst",0.69, 1.99));
    	list.add(new Lebensmittel("15.01.22", "Lebensmittel", "Käse",0.49, 1.29));
    	list.add(new Lebensmittel("10.10.22", "Lebensmittel", "Flasche Wein",2.30, 6.99));
    	list.add(new Haushaltsartikel(0.5, "Haushaltsartikel", "Klobürste",0.99, 4.99));
    	list.add(new Haushaltsartikel(0.75, "Haushaltsartikel", "Plastikbesteck",0.05, 0.69));
    	list.add(new Haushaltsartikel(0.99, "Haushaltsartikel",  "Putzlappen",0.15, 1.19));
    	list.add(new Haushaltsartikel(0.01, "Haushaltsartikel",  "Zahnpasta",0.50, 1.99));
    	list.add(new Sonstige(18, "Sonstige", "DVD Actionfilm",0.99, 8.99));
    	list.add(new Sonstige(0, "Sonstige", "DVD Familienfilm",0.89, 7.99));



    	System.out.println("#  Kategorie    Produkt     Einkaufspreis Verkaufspreis Weiteres ");
    	for (int i = 0; i < list.size(); i++) {

			System.out.print(i +" ");
			System.out.print(list.get(i).getKategorie()+ " ");
			System.out.print(list.get(i).getEinkaufspreis()+" ");
			System.out.print(list.get(i).getVerkaufspreis()+" ");
			System.out.print(list.get(i).getProdukt()+" " );


			try {
				Lebensmittel b = (Lebensmittel) list.get(i);
				System.out.println(b.getMhd());
			} catch (ClassCastException exc){}
				try {
					Haushaltsartikel b = (Haushaltsartikel) list.get(i);
					System.out.println(b.getRa());
				}catch (ClassCastException exc){}
					try {
						Sonstige b = (Sonstige) list.get(i);
						System.out.println(b.getFsk());
					}catch (ClassCastException exc){}







    	}
       

    }
}
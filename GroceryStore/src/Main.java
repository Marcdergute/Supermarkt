
import article.Article  ;
import lebensmittel.Lebensmittel;
import haushaltsartikel.Haushaltsartikel;
import sonstige.Sonstige;
import StorePanel.StorePanel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import warenkorb.Warenkorb;

import java.util.ArrayList;

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
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Grocery Store");
		StorePanel storePanel = new StorePanel();
		
		Create(storePanel);
		
		window.add(storePanel);
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);






    	}
    	
       

    
    public static void Create(JPanel storePanel) {
    	
    	//creates Main Panels
    	JPanel modePanel = new JPanel();
		JPanel shoppingCard = new JPanel();
		shoppingCard.setLayout(new BorderLayout());
		JPanel outputPanel = new JPanel();
		
		
		//creates Elements for modePanel
		JCheckBox ecoBtn = new JCheckBox("Öko Modus");
		JCheckBox u18Btn = new JCheckBox("U18 Modus");
		JCheckBox empBtn = new JCheckBox("Mitarbeiter Modus");
		JCheckBox savBtn = new JCheckBox("Spar Modus");
		JButton addCard = new JButton("Warenkorb hinzufügen");
		
		//Creates Elements for outputPanel
		JLabel hint = new JLabel("Hinweis:");
		JLabel finalPrice = new JLabel("Gesamptpreis:");
		
	
		//Card Selector
		JTabbedPane CardSelector = new JTabbedPane(JTabbedPane.LEFT,JTabbedPane.SCROLL_TAB_LAYOUT);
		JPanel card1 = new JPanel(); //Creates shopping card
		card1.setLayout(new BorderLayout());
		JPanel card2 = new JPanel();
		card2.setLayout(new BorderLayout());
		JPanel card3 = new JPanel();
		card3.setLayout(new BorderLayout());
		JPanel card4 = new JPanel();
		card4.setLayout(new BorderLayout());
		
		//Sets background color
		card1.setBackground(Color.RED); 
		card2.setBackground(Color.BLUE);
		card3.setBackground(Color.GREEN);
		card4.setBackground(Color.BLACK);
		
		
		//TODO: Create a "add card" function which adds a card
		
		
		//Only for test run>>>>>>>>>>>>>>>>>>
		//TODO: Get Products
		String comboBoxListe[] = {"Tee", "Wurst",
	            "Zahnpasta", "Klopapier", "Film",
	            "Milch", "Eier", "Brot",
	            "Zahnpast", "Butter", "Orange",
	            "Banane", "Lebensmittelfarbe", "Bier",
	            "Wasser", "Pizza"};
		//<<<<<<<<<<<<<<<<<<
		
		JPanel cardGrid = new JPanel();
		cardGrid.setLayout(new GridLayout(1,1));
		
		CardSelector.addTab("Warenkorb 1", card1);//Adds Card
		JComboBox<?> productSelection1 = new JComboBox<Object>(comboBoxListe);
		CardSelector.addTab("Warenkorb 2", card2);
		JComboBox<?> productSelection2 = new JComboBox<Object>(comboBoxListe);
		CardSelector.addTab("Warenkorb 3", card3);
		JComboBox<?> productSelection3 = new JComboBox<Object>(comboBoxListe);
		CardSelector.addTab("Warenkorb 4", card4);
		JComboBox<?> productSelection4 = new JComboBox<Object>(comboBoxListe);

		//Creates Card LAyout
		card1.add(productSelection1, BorderLayout.PAGE_START);
		card1.add(cardGrid, BorderLayout.CENTER);
		card2.add(productSelection2, BorderLayout.PAGE_START);
		card2.add(cardGrid, BorderLayout.CENTER);
		card3.add(productSelection3, BorderLayout.PAGE_START);
		card3.add(cardGrid, BorderLayout.CENTER);
		card4.add(productSelection4, BorderLayout.PAGE_START);
		card4.add(cardGrid, BorderLayout.CENTER);
		
		
		
		
		//modePanel
		modePanel.add(ecoBtn);
		modePanel.add(u18Btn);
		modePanel.add(empBtn);
		modePanel.add(savBtn);
		modePanel.add(addCard);
		storePanel.add(modePanel, BorderLayout.PAGE_START);
		
		//ShoppingCard
		shoppingCard.add(CardSelector);
		storePanel.add(shoppingCard, BorderLayout.CENTER);
		
		//output Panel
		outputPanel.add(hint);
		outputPanel.add(finalPrice);
		storePanel.add(outputPanel, BorderLayout.PAGE_END);

		
	}
}

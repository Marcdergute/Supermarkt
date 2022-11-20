package StorePanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;

public class StorePanel extends JPanel{
	
	private static int cardCounter = 0;
	
	public StorePanel() {
		this.setPreferredSize(new Dimension(1024, 768));
		this.setLayout(new BorderLayout());
		
		
		
	}
	
	public static void startStorePanel(){
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
		
		JTabbedPane CardSelector = new JTabbedPane(JTabbedPane.LEFT,JTabbedPane.SCROLL_TAB_LAYOUT);
		String comboBoxList[] = {"Tee", "Wurst",
	            "Zahnpasta", "Klopapier", "Film",
	            "Milch", "Eier", "Brot",
	            "Zahnpast", "Butter", "Orange",
	            "Banane", "Lebensmittelfarbe", "Bier",
	            "Wasser", "Pizza"};
		JPanel cardGrid = new JPanel();
		cardGrid.setLayout(new GridLayout(1,1));
		
		//creates Elements for modePanel
		JCheckBox ecoBtn = new JCheckBox("Öko Modus");
		JCheckBox u18Btn = new JCheckBox("U18 Modus");
		JCheckBox empBtn = new JCheckBox("Mitarbeiter Modus");
		JCheckBox savBtn = new JCheckBox("Spar Modus");
		JButton addCard = new JButton("Warenkorb hinzufügen");
		addCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addShoppingCard(CardSelector, comboBoxList, cardGrid);
			}
		});
		
		//Creates Elements for outputPanel
		JLabel hint = new JLabel("Hinweis:");
		JLabel finalPrice = new JLabel("Gesamptpreis:");
			
		
		//TODO: Create a "add card" function which adds a card
		
		
		//Only for test run>>>>>>>>>>>>>>>>>>
		//TODO: Get Products
		
		//<<<<<<<<<<<<<<<<<<
	
		
		
		
		
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
	
	public static void addShoppingCard(JTabbedPane CardSelector, String[] comboBoxList, JPanel cardGrid) {
		
		cardCounter++;
		JPanel card = new JPanel(); //Creates shopping card
		card.setLayout(new BorderLayout());
		
		CardSelector.addTab("Warenkorb " + cardCounter, card);//Adds Card
		JComboBox<?> productSelection1 = new JComboBox<Object>(comboBoxList);
		
		card.add(productSelection1, BorderLayout.PAGE_START);
		card.add(cardGrid, BorderLayout.CENTER);
	}
	
	

}

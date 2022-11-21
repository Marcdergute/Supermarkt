package StorePanel;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import warenkorb.Warenkorb;

import static importing.Importing.articleList;


public class StorePanel extends JPanel{
	
	public static ArrayList<JPanel> cardList = new ArrayList<JPanel>();
	public static ArrayList <Warenkorb> warenkorbList = new ArrayList<Warenkorb>();


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
		String comboBoxList[] = new String[articleList.size()];
		for(int i = 0; i <= articleList.size()-1; i++) {
			comboBoxList[i]  = articleList.get(i).produkt +" "+ articleList.get(i).verkaufspreis + "€";
		}
	
		JPanel cardGrid = new JPanel();
		cardGrid.setLayout(new GridLayout(1,1));
		
		//creates Elements for modePanel
		ButtonGroup modeGroup = new ButtonGroup();
		JCheckBox ecoBtn = new JCheckBox("Öko Modus");
		modeGroup.add(ecoBtn);
		JCheckBox u18Btn = new JCheckBox("U18 Modus");
		modeGroup.add(u18Btn);
		JCheckBox empBtn = new JCheckBox("Mitarbeiter Modus");
		modeGroup.add(empBtn);
		JCheckBox savBtn = new JCheckBox("Spar Modus");
		modeGroup.add(savBtn);
		JCheckBox gifBtn = new JCheckBox("Gift Cart");
		modeGroup.add(gifBtn);
		
		
		JButton addCard = new JButton("Add Card");
		addCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isEcoSelected = ecoBtn.isSelected();
				boolean isU18Selected = u18Btn.isSelected();
				boolean isEmpSelected = empBtn.isSelected();
				boolean isSavSelected = savBtn.isSelected();
				boolean isGifSelected = gifBtn.isSelected();
				int mode;
				
				if (isEcoSelected) {
					System.out.println("Eco is selected");
					mode = 1;
				}else if(isU18Selected) {
					System.out.println("U18 is selected");
					mode = 2;
				}else if(isEmpSelected) {
					System.out.println("Emp is selected");
					mode = 3;
				}else if(isSavSelected) {
					System.out.println("Sav is selected");
					mode = 4;
				}else if(isGifSelected){
					System.out.println("Gif is selected");
					mode = 0;
					//TODO: gift() aufrufen....
				}else {
					System.out.println("Nothing is selected");
					mode = 0;
				}

				addShoppingCard(CardSelector, comboBoxList, cardGrid, mode);
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
		modePanel.add(gifBtn);
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
	
	
	public static void addShoppingCard(JTabbedPane CardSelector, String[] comboBoxList, JPanel cardGrid, int mode) {
		
		warenkorbList.add(new Warenkorb(mode));
		
		cardList.add(new JPanel()); //Creates shopping card
		cardList.get(cardCounter).setLayout(new BorderLayout());
		CardSelector.addTab("Warenkorb " + (cardCounter+1), cardList.get(cardCounter));//Adds Card	//TODO: Random Christmas name generator https://www.fantasynamegenerators.com/christmas-elf-names.php
		
		JPanel topProductSelection = new JPanel();
		JComboBox<?> productSelection1 = new JComboBox<Object>(comboBoxList);
		JButton addProductBtn = new JButton("+");
		
		cardList.get(cardCounter).add(topProductSelection, BorderLayout.PAGE_START);
		topProductSelection.setLayout(new BoxLayout(topProductSelection, BoxLayout.X_AXIS));
		topProductSelection.add(productSelection1);
		topProductSelection.add(addProductBtn);
		
		cardList.get(cardCounter).add(cardGrid, BorderLayout.CENTER);
		cardCounter++;
		System.out.println(cardList.size());
	}
	
	

}

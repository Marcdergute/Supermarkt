package StorePanel;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import warenkorb.Warenkorb;
import warenkorb.Functions;
import static importing.Importing.articleList;


public class StorePanel extends JPanel{
	static JFrame window = new JFrame();
	static JPanel shoppingCart = new JPanel();
	public static ArrayList<JPanel> cartList = new ArrayList<JPanel>();
	public static ArrayList<JLabel> productListLabel = new ArrayList<JLabel>();
	public static ArrayList<JPanel> productListPanel = new ArrayList<JPanel>();
	public static ArrayList<JButton> productListButton = new ArrayList<JButton>();
	public static ArrayList <Warenkorb> warenkorbList = new ArrayList<Warenkorb>();

	//Creates Elements for outputPanel
	static JLabel hint = new JLabel("Hint:");
	static JLabel finalPrice = new JLabel("Total Price:");
	
	static String cartName;
	static int giftCartCounter = 1;
	static int mode;
	static int selectedCart = 0;
	static int labelCounter = 0;


	
	private static int cartCounter = 0;
	

	
	public StorePanel() {
		this.setPreferredSize(new Dimension(1024, 768));
		this.setLayout(new BorderLayout());
		
		//Change the Frame Icon to a 
		ImageIcon icon = null;
		java.net.URL imgURL = StorePanel.class.getResource("/icon/icon_256.gif");
		if (imgURL != null) {
	         icon = new ImageIcon(imgURL);
	         window.setIconImage(icon.getImage());
	      } else {
	         JOptionPane.showMessageDialog(window, "Icon image not found.");
	      }
		//setIconImage(new ImageIcon(getClass().getResource("/icon/Market_Icon.png")).getImage());
		
	}
	
	public static void startStorePanel(){
		
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
		
		shoppingCart.setLayout(new BorderLayout());
		JPanel outputPanel = new JPanel();
		
		JPanel cartGridPanel = new JPanel();
		cartGridPanel.setLayout(new BoxLayout(cartGridPanel, BoxLayout.Y_AXIS));
		
		JScrollPane cartGrid = new JScrollPane(cartGridPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
												ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		
				
		JTabbedPane CartSelector = new JTabbedPane(JTabbedPane.LEFT,JTabbedPane.SCROLL_TAB_LAYOUT);
		
		CartSelector.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				selectedCart = CartSelector.getSelectedIndex();
				System.out.print("Funktion wird ausgeführt");
				writeShoppingCart(cartGrid, cartGridPanel);
			}
		});
		
		String comboBoxList[] = new String[articleList.size()];
		for(int i = 0; i <= articleList.size()-1; i++) {
			comboBoxList[i]  = articleList.get(i).produkt +" "+ articleList.get(i).verkaufspreis + "€";
		}
	
		
		//creates Elements for modePanel
		ButtonGroup modeGroup = new ButtonGroup();
		JCheckBox ecoBtn = new JCheckBox("Eco Mode");
		modeGroup.add(ecoBtn);
		JCheckBox u18Btn = new JCheckBox("Youth Mode");
		modeGroup.add(u18Btn);
		JCheckBox empBtn = new JCheckBox("Employee Mode");
		modeGroup.add(empBtn);
		JCheckBox savBtn = new JCheckBox("Save Money Mode");
		modeGroup.add(savBtn);
		JCheckBox gifBtn = new JCheckBox("Gift Cart");
		modeGroup.add(gifBtn);
		
		
		JButton addCart = new JButton("Add Card"); 
		addCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isEcoSelected = ecoBtn.isSelected();
				boolean isU18Selected = u18Btn.isSelected();
				boolean isEmpSelected = empBtn.isSelected();
				boolean isSavSelected = savBtn.isSelected();
				boolean isGifSelected = gifBtn.isSelected();
				boolean test = true;
				
				if (isEcoSelected) {
					System.out.println("Eco is selected");
					warenkorbList.add(Functions.addShoppingCart(1));
				}else if(isU18Selected) {
					System.out.println("U18 is selected");
					warenkorbList.add(new Warenkorb(2));
				}else if(isEmpSelected) {
					System.out.println("Emp is selected");
					warenkorbList.add(new Warenkorb(3));
				}else if(isSavSelected) {
					System.out.println("Sav is selected");
					warenkorbList.add(new Warenkorb(4));
				}else if(isGifSelected){
					System.out.println("Gif is selected");
					PopUpPane giftValue = new PopUpPane();
					try {
						warenkorbList.add(Functions.gift(giftValue.getGiftCartValue()));
						hint.setForeground(Color.black);
						hint.setText("Hint: "); 
						cartName = "Gift Cart " + giftCartCounter;
						giftCartCounter++;
					} catch (Exception e2) {
						hint.setForeground(Color.red);
						hint.setText("Hint: Enter a Number!");
						test = false;
					}
						
					
				}else {
					//System.out.println("Nothing is selected");
					warenkorbList.add(new Warenkorb(0));
				}	
				if(test == true) {
					addShoppingCard(CartSelector, comboBoxList, cartGrid, cartGridPanel);
				}
			}
		});
		
		//Creates pay Button
		JButton payBtn = new JButton("Pay");
		
		
		
			
		
		//TODO: Create a "add card" function which adds a card
	
		//modePanel
		modePanel.add(ecoBtn);
		modePanel.add(u18Btn);
		modePanel.add(empBtn);
		modePanel.add(savBtn);
		modePanel.add(gifBtn);
		modePanel.add(addCart);
		storePanel.add(modePanel, BorderLayout.PAGE_START);
		
		//ShoppingCard
		shoppingCart.add(CartSelector);
		
		storePanel.add(shoppingCart, BorderLayout.CENTER);
		

		
		
		//output Panel
		outputPanel.add(hint);
		outputPanel.add(finalPrice);
		outputPanel.add(payBtn);
		storePanel.add(outputPanel, BorderLayout.PAGE_END);
		

		
	}
	
	
	public static void addShoppingCard(JTabbedPane CartSelector, String[] comboBoxList, JScrollPane cartGrid, JPanel cartGridPanel) {

		cartList.add(new JPanel()); //Creates shopping card
		cartList.get(cartCounter).setLayout(new BorderLayout());
		CartSelector.addTab(cartName, cartList.get(cartCounter));
		//Adds Card	//TODO: Random Christmas name generator https://www.fantasynamegenerators.com/christmas-elf-names.php
		
		
		if(mode != 6) {
			JPanel topProductSelection = new JPanel();
			JComboBox<?> productSelection1 = new JComboBox<Object>(comboBoxList);
			
			JButton addProductBtn = new JButton("+");
			addProductBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e3) {
					//System.out.println(productSelection1.getSelectedIndex());
					//Adds a product to the shopping Cart >>>>>>>>>>>>>>>
					Functions.addArticleToShoppingCart(warenkorbList.get(selectedCart), productSelection1.getSelectedIndex());
					//warenkorbList.get(selectedCart).warenkorbAdd(articleList.get(productSelection1.getSelectedIndex()));
					//<<<<<<<<<<<<<<<<<<<<<<<
					writeShoppingCart(cartGrid, cartGridPanel);
					//warenkorbList.get(selectedCart).warenkorbPrint();
				}
			});
			cartList.get(cartCounter).add(topProductSelection, BorderLayout.PAGE_START);
			topProductSelection.setLayout(new BoxLayout(topProductSelection, BoxLayout.X_AXIS));
			topProductSelection.add(productSelection1);
			topProductSelection.add(addProductBtn);
		}
		
		
		
		cartCounter++;
		//System.out.println(cartList.size());
	}
	
	public static void writeShoppingCart(JScrollPane cartGrid, JPanel cartGridPanel) {
	
		productListPanel.clear();
		productListLabel.clear();
		productListButton.clear();
		labelCounter = 0;
		
		cartGridPanel.removeAll();
		
		System.out.print("In Funktion ");

		String[][] data = new String[warenkorbList.get(selectedCart).getList().size()][4];
		//cartGridPanel.removeAll();
		//productList.clear();
		for(int i = 0; i < warenkorbList.get(selectedCart).getList().size(); i++) {


			
			
			productListPanel.add(new JPanel());
			productListPanel.get(i).setLayout(new BoxLayout(productListPanel.get(i), BoxLayout.X_AXIS));
			
			productListLabel.add(new JLabel("  "+warenkorbList.get(selectedCart).getList().get(i).produkt +"     "));
			productListPanel.get(i).add(productListLabel.get(labelCounter));
			labelCounter ++;
			productListLabel.add(new JLabel(warenkorbList.get(selectedCart).getList().get(i).kategorie +"     "));
			productListPanel.get(i).add(productListLabel.get(labelCounter));
			labelCounter ++;
			productListLabel.add(new JLabel(Functions.getSpecialProperty(warenkorbList.get(selectedCart).getList().get(i))+"     "));
			productListPanel.get(i).add(productListLabel.get(labelCounter));
			labelCounter ++;
			productListLabel.add(new JLabel(Double.toString(warenkorbList.get(selectedCart).getList().get(i).verkaufspreis)+"€"+"     "));
			productListPanel.get(i).add(productListLabel.get(labelCounter));
			labelCounter ++;
			
			productListButton.add(new JButton("-"));
			productListButton.get(i).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e4) {

					System.out.println("button "+ e4 +" pressed!" );
				}
			});
			productListPanel.get(i).add(productListButton.get(i));
			
			cartGridPanel.add(productListPanel.get(i));
			productListPanel.get(i).setAlignmentX(LEFT_ALIGNMENT);
			cartGridPanel.updateUI();
			
			//productList.add(new JLabel());
			//productList.get(i).setText(product);
			
			
			//cartGridPanel.add(productList.get(i));
			
			//System.out.println("Ausgeführt!" + i);
		}
		

		
		cartList.get(selectedCart).add(cartGrid, BorderLayout.CENTER);
		
		finalPrice.setText("Final Price: " + warenkorbList.get(selectedCart).getCost()+ "€");

	}
	
	
	

}

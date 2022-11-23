package StorePanel;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import warenkorb.Warenkorb;
import warenkorb.Functions;
import StorePanel.OptionPaneExample;

import static importing.Importing.articleList;


public class StorePanel extends JPanel{
	static JFrame window = new JFrame();
	static JPanel shoppingCart = new JPanel();
	public static ArrayList<JPanel> cartList = new ArrayList<JPanel>();
	public static ArrayList<JLabel> productList = new ArrayList<JLabel>();
	public static ArrayList <Warenkorb> warenkorbList = new ArrayList<Warenkorb>();
	//Creates Elements for outputPanel
	static JLabel hint = new JLabel("Hint:");
	static JLabel finalPrice = new JLabel("Total Price:");
	
	
	static int mode;
	static int selectedCart = 0;
	

	private static int cartCounter = 0;
	
	public StorePanel() {
		this.setPreferredSize(new Dimension(1024, 768));
		this.setLayout(new BorderLayout());
		
		
		
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
				writeShoppingCart(cartGridPanel, cartGrid);
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
					mode = 5;
					OptionPaneExample giftValue = new OptionPaneExample();
					try {
						warenkorbList.add(Functions.gift(giftValue.getGiftCartValue()));
						hint.setForeground(Color.black);
						hint.setText("Hint: ");
					} catch (Exception e2) {
						hint.setForeground(Color.red);
						hint.setText("Hint: Enter a Number!");
						test = false;
					}
						
					
				}else {
					//System.out.println("Nothing is selected");
					mode = 0;
				}	
				if(test == true) {
					addShoppingCard(CartSelector, comboBoxList, cartGridPanel, cartGrid);
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
	
	
	public static void addShoppingCard(JTabbedPane CartSelector, String[] comboBoxList, JPanel cartGridPanel, JScrollPane cartGrid) {
		if(mode != 5) {
		warenkorbList.add(new Warenkorb(mode));
		}
		
		cartList.add(new JPanel()); //Creates shopping card
		cartList.get(cartCounter).setLayout(new BorderLayout());
		CartSelector.addTab("Shopping Card" + (cartCounter+1), cartList.get(cartCounter));
		//Adds Card	//TODO: Random Christmas name generator https://www.fantasynamegenerators.com/christmas-elf-names.php
		
		
		if(mode != 5) {
			JPanel topProductSelection = new JPanel();
			JComboBox<?> productSelection1 = new JComboBox<Object>(comboBoxList);
			
			JButton addProductBtn = new JButton("+");
			addProductBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e3) {
					//System.out.println(productSelection1.getSelectedIndex());
					//Adds a product to the shopping Cart >>>>>>>>>>>>>>>
					warenkorbList.get(selectedCart).warenkorbAdd(articleList.get(productSelection1.getSelectedIndex()));
					//<<<<<<<<<<<<<<<<<<<<<<<
					writeShoppingCart(cartGridPanel, cartGrid);
					//warenkorbList.get(selectedCart).warenkorbPrint();
				}
			});
			cartList.get(cartCounter).add(topProductSelection, BorderLayout.PAGE_START);
			topProductSelection.setLayout(new BoxLayout(topProductSelection, BoxLayout.X_AXIS));
			topProductSelection.add(productSelection1);
			topProductSelection.add(addProductBtn);
		}else {
			warenkorbList.get(cartCounter).warenkorbPrint();
		}
		
		
		
		cartCounter++;
		//System.out.println(cartList.size());
	}
	
	public static void writeShoppingCart(JPanel cartGridPanel, JScrollPane cartGrid) {
		
		cartGridPanel.removeAll();
		productList.clear();
		for(int i = 0; i < warenkorbList.get(selectedCart).getList().size(); i++) {
			//		
			String product = warenkorbList.get(selectedCart).getList().get(i).produkt;
			

			productList.add(new JLabel());
			productList.get(i).setText(product);
			cartGridPanel.add(productList.get(i));
			cartGridPanel.updateUI();
			
		}
		
		

		cartList.get(selectedCart).add(cartGrid, BorderLayout.CENTER);
		finalPrice.setText("Final Price: " + warenkorbList.get(selectedCart).getCost()+ "€");
		
		
	}
	
	
	

}

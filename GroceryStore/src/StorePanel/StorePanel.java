package StorePanel;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.DimensionUIResource;

import warenkorb.Warenkorb;
import warenkorb.Functions;
import static importing.Importing.articleList;


@SuppressWarnings("serial")
public class StorePanel extends JPanel{
	static JFrame window = new JFrame();
	static JPanel shoppingCart = new JPanel();
	public static ArrayList<JPanel> cartList = new ArrayList<JPanel>();
	public static ArrayList<JLabel> productListLabel = new ArrayList<JLabel>();
	public static ArrayList<JPanel> productListPanel = new ArrayList<JPanel>();
	public static ArrayList<JPanel> productListLayoutPanel = new ArrayList<JPanel>();
	public static ArrayList<JRadioButton> modePanelRadioButton = new ArrayList<JRadioButton>();
	public static ArrayList<JButton> productListButton = new ArrayList<JButton>();
	public static ArrayList <Warenkorb> warenkorbList = new ArrayList<Warenkorb>();
	public static ArrayList <Boolean> payedCarts = new ArrayList<Boolean>();
	static boolean test;

	//Creates Elements for outputPanel
	static JLabel hint = new JLabel("Hint:", SwingConstants.LEFT);
	static JLabel finalPrice = new JLabel("Total Price:", SwingConstants.LEFT);
	
	static String cartName;
	static int giftCartCounter = 1;
	static int mode;
	static int selectedCart = 0;
	static int labelCounter = 0;
	static int panelCounter = 0;
	static String[] selectedHighProduct = {"",""};
	static String[] selectedLowProduct = {"", ""};


	
	private static int cartCounter = 0;
	
	public StorePanel() {
		
		this.setLayout(new BorderLayout());
		
		//Change the Frame Icon to a 
		ImageIcon icon = null;
		URL imgURL = StorePanel.class.getResource("/icon/Market_Icon.png");
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
		window.setResizable(true);
		window.setTitle("Grocery Store");
		window.setMinimumSize(new Dimension(1000,500));
		StorePanel storePanel = new StorePanel();
		
		Create(storePanel);
		
		hint.setPreferredSize(new Dimension(300 ,50));
		finalPrice.setPreferredSize(new Dimension(200,50));
		
		window.add(storePanel);
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
	
	private void setMinimumSize(int i, int j) {
		// TODO Auto-generated method stub
		
	}

	public static void Create(JPanel storePanel) {
		//Creates Menu>>>>>>>>
		JMenuBar menu = new JMenuBar();
		
		JMenu option = new JMenu("Options");		
		JMenuItem highest = new JMenuItem("Show highest BBD and Recycling Value");
		JMenuItem lowest = new JMenuItem("Show Lowest BBD and Recycling Value");
		JMenuItem hideLowestHighest = new JMenuItem("Hide Higlighted Elements");
		option.add(highest);
		option.add(lowest);
		option.add(hideLowestHighest);
		
		JMenu store = new JMenu("Store");
		JMenuItem getRevenue = new JMenuItem("Get total Revenue");
		store.add(getRevenue);
		
				
		
				
		menu.add(option);
		menu.add(store);
		window.setJMenuBar(menu);
		//<<<<<<<<<<<
		
		
    	//creates Main Panels
    	JPanel modePanel = new JPanel();
		
		shoppingCart.setLayout(new BorderLayout());
		JPanel outputPanel = new JPanel();
		
		JPanel cartGridPanel = new JPanel();
		cartGridPanel.setLayout(new BoxLayout(cartGridPanel, BoxLayout.Y_AXIS));
		
		JScrollPane cartGrid = new JScrollPane(cartGridPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
												ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		//Add Action Listener to Menu Items>>>>>>>>
		highest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e11) {
				try {
					ArrayList<Integer> highestProduct = Functions.highestProduct(warenkorbList.get(selectedCart));

					if(highestProduct.size() == 1) {
						selectedHighProduct[0]= warenkorbList.get(selectedCart).getList().get(highestProduct.get(0)).produkt;
						selectedHighProduct[1]= warenkorbList.get(selectedCart).getList().get(highestProduct.get(0)).produkt;
						writeShoppingCart(cartGrid, cartGridPanel);
					}else if(highestProduct.size() == 2) {						
						selectedHighProduct[0]= warenkorbList.get(selectedCart).getList().get(highestProduct.get(0)).produkt;
						selectedHighProduct[1]= warenkorbList.get(selectedCart).getList().get(highestProduct.get(1)).produkt;
						writeShoppingCart(cartGrid, cartGridPanel);
					}
				} catch (Exception e) {
					hint.setText("Hint: First create a shopping cart!");
					hint.setForeground(Color.decode(ColorPalette.getColorPalette(2)));
				}			
			}
		});
		
		lowest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e12) {
				try {
					ArrayList<Integer> lowestProduct = Functions.lowestProduct(warenkorbList.get(selectedCart));
					if(lowestProduct.size() == 1) {
						selectedLowProduct[0]= warenkorbList.get(selectedCart).getList().get(lowestProduct.get(0)).produkt;
						selectedLowProduct[1]= warenkorbList.get(selectedCart).getList().get(lowestProduct.get(0)).produkt;
						writeShoppingCart(cartGrid, cartGridPanel);
					}else if(lowestProduct.size() == 2) {						
						selectedLowProduct[0]= warenkorbList.get(selectedCart).getList().get(lowestProduct.get(0)).produkt;
						selectedLowProduct[1]= warenkorbList.get(selectedCart).getList().get(lowestProduct.get(1)).produkt;
						writeShoppingCart(cartGrid, cartGridPanel);
					}
				} catch (Exception e) {
					hint.setText("Hint: First create a shopping cart!");
					hint.setForeground(Color.decode(ColorPalette.getColorPalette(2)));
				}	
			}
		});
		
		hideLowestHighest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e13) {
				try {
					selectedHighProduct[0] = "";
					selectedHighProduct[1] = "";
					selectedLowProduct[0] = "";
					selectedLowProduct[1] = "";
					writeShoppingCart(cartGrid, cartGridPanel);
				}catch (Exception e){
					hint.setText("Hint: First create a shopping cart!");
					hint.setForeground(Color.decode(ColorPalette.getColorPalette(2)));				
				}
			}
		});
		getRevenue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e14) {
				new IncomePopUpPane();
			}
		});
		//<<<<<<<<<<<<<<
		JButton payBtn = new JButton("Pay");
				
		JTabbedPane CartSelector = new JTabbedPane(JTabbedPane.LEFT,JTabbedPane.SCROLL_TAB_LAYOUT);
		
		CartSelector.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				selectedCart = CartSelector.getSelectedIndex();
				if(cartCounter >= 1) {
					if(payedCarts.get(selectedCart) == true) {
						hint.setText("Hint: This Cart is Payed");
						hint.setForeground(Color.decode(ColorPalette.getColorPalette(5)));
						payBtn.setVisible(false);
					}else if(payedCarts.get(selectedCart)==false) {
						hint.setText("Hint:");
						hint.setForeground(Color.black);
						payBtn.setVisible(true);
					}
				}
				writeShoppingCart(cartGrid, cartGridPanel);
			}
		});
		
		String comboBoxListV[] = new String[articleList.size()];
		for(int i = 0; i <= articleList.size()-1; i++) {
			comboBoxListV[i]  = articleList.get(i).produkt +" "+ articleList.get(i).verkaufspreis + "€";
		}
		String comboBoxListE[] = new String[articleList.size()];
		for(int i = 0; i <= articleList.size()-1; i++) {
			comboBoxListE[i]  = articleList.get(i).produkt +" "+ articleList.get(i).einkaufspreis + "€";
		}
		
		//creates Elements for modePanel
		ButtonGroup modeGroup = new ButtonGroup();
		
		//Standard Button
		modePanelRadioButton.add(new JRadioButton("Standard", true));
		modePanelRadioButton.get(0).setToolTipText("Choose whatever you want");
		
		//Eco Mode Button
		modePanelRadioButton.add(new JRadioButton("Eco"));
		modePanelRadioButton.get(1).setToolTipText("No Plastic and Animal Products");

		//Youth Mode Button
		modePanelRadioButton.add(new JRadioButton("Youth"));
		modePanelRadioButton.get(2).setToolTipText("No Alcohol and Movies with a high FSK");
		
		//Employee Mode Button
		modePanelRadioButton.add(new JRadioButton("Employee"));
		modePanelRadioButton.get(3).setToolTipText("Get the lower buying Price");
		
		//Save Money Mode Button
		modePanelRadioButton.add(new JRadioButton("Save Money"));
		modePanelRadioButton.get(4).setToolTipText("The maximum Cart Value is 50€");
		
		//Gift Cart Button
		modePanelRadioButton.add(new JRadioButton("Gift Cart"));
		modePanelRadioButton.get(5).setToolTipText("Create a random filled Cart with a chosen Value");
		
		//get the selected RadioButton to set the Cart in the desired Mode
		JButton addCart = new JButton("Add Card"); 
		addCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isStdSelected = modePanelRadioButton.get(0).isSelected();
				boolean isEcoSelected = modePanelRadioButton.get(1).isSelected();
				boolean isU18Selected = modePanelRadioButton.get(2).isSelected();
				boolean isEmpSelected = modePanelRadioButton.get(3).isSelected();
				boolean isSavSelected = modePanelRadioButton.get(4).isSelected();
				boolean isGifSelected = modePanelRadioButton.get(5).isSelected();
				test = true;
				
				if(isGifSelected == false) {
					try {
						CartNamePopUpPane cartNamePane = new CartNamePopUpPane();
						cartName = cartNamePane.getCartNameValue();
						if(cartName.length()< 3) {
							hint.setForeground(Color.decode(ColorPalette.getColorPalette(2)));
							hint.setText("Hint: Your name must contain at least 3 characters!");
							test = false;
						}else if(cartName.equals("random")) {
							cartName = cartNamePane.getRandomName();
						}
					} catch (Exception e2) {
						hint.setForeground(Color.decode(ColorPalette.getColorPalette(2)));
						hint.setText("Hint: Enter a Name with at least 3 Characters!");
						test = false;
					}
					
				}
				if(test == true) {
					if (isEcoSelected) {
						warenkorbList.add(Functions.addShoppingCart(1));
						cartName = cartName + " (Eco)";
					}else if(isU18Selected) {
						warenkorbList.add(new Warenkorb(2));
						cartName = cartName + " (U18)";
					}else if(isEmpSelected) {
						warenkorbList.add(new Warenkorb(3));
						cartName = cartName + " (Empl)";
					}else if(isSavSelected) {
						warenkorbList.add(new Warenkorb(4));
						cartName = cartName + " (Save)";
					}else if(isGifSelected){
						PopUpPane giftValue = new PopUpPane();
						try {
							warenkorbList.add(Functions.gift(giftValue.getGiftCartValue()));
							cartName = "Gift Cart " + giftCartCounter;
							giftCartCounter++;
						} catch (Exception e2) {
							hint.setForeground(Color.decode(ColorPalette.getColorPalette(2)));
							hint.setText("Hint: Enter a Number!");
							test = false;
						}
							
						
					}else if(isStdSelected){
						warenkorbList.add(new Warenkorb(0));
					}	
					if(test == true) {
						if(isGifSelected) {
							test  = false;
						}
						hint.setForeground(Color.black);
						hint.setText("Hint: ");
						addShoppingCard(CartSelector, comboBoxListV, comboBoxListE, cartGrid, cartGridPanel);
					}
				}
			}
		});
		
		//Creates pay Button
		
		
		payBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e20) {
				if(warenkorbList.get(selectedCart).getList().size()> 0) {
					Functions.pay(warenkorbList.get(selectedCart));
					payedCarts.set(selectedCart, true);
					payBtn.setVisible(false);
					hint.setText("Hint: This Cart is Payed");
					hint.setForeground(Color.decode(ColorPalette.getColorPalette(5)));
					CartSelector.setForegroundAt(selectedCart, Color.decode(ColorPalette.getColorPalette(5)));
				} else{
					hint.setForeground(Color.decode(ColorPalette.getColorPalette(2)));
					hint.setText("Hint: There's nothing in your Shopping Cart!");
				}
			
				//CartSelector.removeTab(cartList.get(selectedCart));
			}
		});
	
		//designing Elements
		//mode Radio Buttons
		for(int i = 0; i<modePanelRadioButton.size(); i++) {
			//modePanelRadioButton.get(i).setBackground(Color.decode(ColorPalette.getColorPalette(0)));
			modePanelRadioButton.get(i).setPreferredSize(new Dimension(105, 25));
			modePanelRadioButton.get(i).setFocusable(false);
			modePanelRadioButton.get(i).setBackground(Color.decode(ColorPalette.getColorPalette(6)));
			modeGroup.add(modePanelRadioButton.get(i));
			modePanel.add(modePanelRadioButton.get(i));
		}
		//Add Cart Button
		addCart.setBorderPainted(false);
		addCart.setFocusable(false);
		addCart.setPreferredSize(new Dimension(90, 25));
		addCart.setBackground(Color.decode(ColorPalette.getColorPalette(6)));
		modePanel.add(addCart);
		
		modePanel.setBackground(Color.white);
		storePanel.add(modePanel, BorderLayout.PAGE_START);
		
		//ShoppingCard
		shoppingCart.add(CartSelector);
		
		shoppingCart.setBackground(Color.decode(ColorPalette.getColorPalette(1)));
		storePanel.add(shoppingCart, BorderLayout.CENTER);		
		
		//output Panel
		outputPanel.add(hint);
		outputPanel.add(finalPrice);
		
		payBtn.setFocusable(false);
		payBtn.setBorderPainted(false);
		payBtn.setBackground(Color.decode(ColorPalette.getColorPalette(6)));
		outputPanel.add(payBtn);
		
		outputPanel.setBackground(Color.white);
		storePanel.add(outputPanel, BorderLayout.PAGE_END);		
	}
	
	
	public static void addShoppingCard(JTabbedPane CartSelector, String[] comboBoxListV, String[] comboBoxListE, JScrollPane cartGrid, JPanel cartGridPanel) {

		cartList.add(new JPanel()); //Creates shopping card
		cartList.get(cartCounter).setLayout(new BorderLayout());
		CartSelector.addTab(cartName, cartList.get(cartCounter));
		cartName = "";
		
		if(test == true) {
			JPanel topProductSelection = new JPanel();
			
			if(warenkorbList.get(cartCounter).property == 3) {
				JComboBox<?> productSelection1 = new JComboBox<Object>(comboBoxListE);	
				JButton addProductBtn = new JButton("+");
				addProductBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e3) {
						//Adds a product to the shopping Cart >>>>>>>>>>>>>>>
						Functions.addArticleToShoppingCart(warenkorbList.get(selectedCart), productSelection1.getSelectedIndex());
						//warenkorbList.get(selectedCart).warenkorbAdd(articleList.get(productSelection1.getSelectedIndex()));
						//<<<<<<<<<<<<<<<<<<<<<<<
						writeShoppingCart(cartGrid, cartGridPanel);
						hint.setForeground(Color.black);
						hint.setText("Hint:");
						//warenkorbList.get(selectedCart).warenkorbPrint();
					}
				});
				topProductSelection.add(productSelection1);
				topProductSelection.add(addProductBtn);
			}else{
				JComboBox<?> productSelection1 = new JComboBox<Object>(comboBoxListV);	
				JButton addProductBtn = new JButton("+");
				addProductBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e3) {
						//Adds a product to the shopping Cart >>>>>>>>>>>>>>>
						Functions.addArticleToShoppingCart(warenkorbList.get(selectedCart), productSelection1.getSelectedIndex());
						//warenkorbList.get(selectedCart).warenkorbAdd(articleList.get(productSelection1.getSelectedIndex()));
						//<<<<<<<<<<<<<<<<<<<<<<<
						writeShoppingCart(cartGrid, cartGridPanel);
						hint.setForeground(Color.black);
						hint.setText("Hint:");
						//warenkorbList.get(selectedCart).warenkorbPrint();
					}
				});
				topProductSelection.add(productSelection1);
				topProductSelection.add(addProductBtn);
			}
			cartList.get(cartCounter).add(topProductSelection, BorderLayout.PAGE_START);
			topProductSelection.setLayout(new BoxLayout(topProductSelection, BoxLayout.X_AXIS));			
			
		}	
		test = true;
		payedCarts.add(false);
		cartCounter++;
	}
	
	public static void writeShoppingCart(JScrollPane cartGrid, JPanel cartGridPanel) {
	
		productListPanel.clear();
		productListLabel.clear();
		productListButton.clear();
		productListLayoutPanel.clear();
		labelCounter = 0;
		panelCounter = 0;
		
		
		cartGridPanel.removeAll();

		
		for(int i = 0; i <= warenkorbList.get(selectedCart).getList().size();i++) {	
				
			productListPanel.add(new JPanel());
			productListPanel.get(i).setLayout(new BorderLayout());
			
			
			//Adding Product to the Panel
			if(i == 0) {
				productListLabel.add(new JLabel("Product Name"));
				productListLabel.get(labelCounter).setFont(new Font(null, Font.BOLD, 16));			
			}else {
				productListLabel.add(new JLabel(warenkorbList.get(selectedCart).getList().get(i-1).produkt));
			}
			productListLabel.get(labelCounter).setPreferredSize(new Dimension(200, 30));
			productListLayoutPanel.add(new JPanel());
			productListLayoutPanel.get(panelCounter).add(productListLabel.get(labelCounter));

			productListLayoutPanel.get(0).setBackground(Color.decode(ColorPalette.getColorPalette(6)));
			productListPanel.get(i).add(productListLayoutPanel.get(panelCounter), BorderLayout.LINE_START);
			labelCounter ++;
			panelCounter ++;
			
			
			//Adding Category to the panel
			if(i==0) {
				productListLabel.add(new JLabel("Category"));
				productListLabel.get(labelCounter).setFont(new Font(null, Font.BOLD, 16));
				
			}else {
				productListLabel.add(new JLabel(warenkorbList.get(selectedCart).getList().get(i-1).kategorie));
				
			}
			productListLabel.get(labelCounter).setPreferredSize(new Dimension(200, 30));
			productListLayoutPanel.add(new JPanel());
			productListLayoutPanel.get(panelCounter).add(productListLabel.get(labelCounter));
			
			productListLayoutPanel.get(1).setBackground(Color.decode(ColorPalette.getColorPalette(6)));
			productListPanel.get(i).add(productListLayoutPanel.get(panelCounter), BorderLayout.CENTER);	
			labelCounter ++;
			
			
			//Adding Property to the panel
			if(i==0) {
				productListLabel.add(new JLabel("Property"));
				productListLabel.get(labelCounter).setFont(new Font(null, Font.BOLD, 16));
			}else {	
				
				String property = Functions.getSpecialProperty(warenkorbList.get(selectedCart).getList().get(i-1));
				String[] format = property.split("\\.");
				if(format.length == 3) {
					productListLabel.add(new JLabel("BBD: "+ Functions.getSpecialProperty(warenkorbList.get(selectedCart).getList().get(i-1))));
				}else if(format.length == 1){
					productListLabel.add(new JLabel("FSK: "+ Functions.getSpecialProperty(warenkorbList.get(selectedCart).getList().get(i-1))));
				}else if(format.length == 2) {
					productListLabel.add(new JLabel(Functions.getSpecialProperty(warenkorbList.get(selectedCart).getList().get(i-1))+"%"));
				}
			}
			productListLabel.get(labelCounter).setPreferredSize(new Dimension(100, 30));
			productListLayoutPanel.get(panelCounter).add(productListLabel.get(labelCounter));
			productListPanel.get(i).add(productListLayoutPanel.get(panelCounter), BorderLayout.CENTER);	
			//Highlights the lowest or the highest BBD or Recycling Value in blue or red>>>>>
			if(i!=0) {
				if(warenkorbList.get(selectedCart).getList().get(i-1).produkt == selectedHighProduct[0] || warenkorbList.get(selectedCart).getList().get(i-1).produkt == selectedHighProduct[1]) {
					productListLabel.get(labelCounter).setForeground(Color.decode(ColorPalette.getColorPalette(2)));
				}else if(warenkorbList.get(selectedCart).getList().get(i-1).produkt == selectedLowProduct[0] || warenkorbList.get(selectedCart).getList().get(i-1).produkt == selectedLowProduct[1]) {
					productListLabel.get(labelCounter).setForeground(Color.decode(ColorPalette.getColorPalette(3)));
				}
			}
			//<<<<<<<<<<<<<<
			labelCounter ++;
			panelCounter ++;
			
			
			//Adding Price to the Panel
			if(i==0) {
				productListLabel.add(new JLabel("Price"));
				productListLabel.get(labelCounter).setFont(new Font(null, Font.BOLD, 16));
				productListLabel.get(labelCounter).setPreferredSize(new Dimension(143, 30));
			}else {
				if(warenkorbList.get(selectedCart).property == 3) {
					productListLabel.add(new JLabel(Double.toString(warenkorbList.get(selectedCart).getList().get(i-1).einkaufspreis)+"€"));
				}else {
					productListLabel.add(new JLabel(Double.toString(warenkorbList.get(selectedCart).getList().get(i-1).verkaufspreis)+"€"));

				}	
				productListLabel.get(labelCounter).setPreferredSize(new Dimension(100, 30));
			}
			
			productListLayoutPanel.add(new JPanel());
			productListLayoutPanel.get(panelCounter).add(productListLabel.get(labelCounter));
			
			productListLayoutPanel.get(2).setBackground(Color.decode(ColorPalette.getColorPalette(4)));
			productListPanel.get(i).add(productListLayoutPanel.get(panelCounter), BorderLayout.LINE_END);	
			labelCounter ++;
			
			
			//Adding the removeButton to the panel
			if(i!=0) {
				productListButton.add(new JButton("-"));
				productListButton.get(i-1).setName(Integer.toString(i-1));
				productListButton.get(i-1).setFocusable(false);
				productListButton.get(i-1).setBorderPainted(false);
				productListButton.get(i-1).setBackground(Color.white);
				productListButton.get(i-1).addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e4) {
	        	            warenkorbList.get(selectedCart).warenkorbDeleteArticle((Integer.parseInt(((JButton) e4.getSource()).getName())));	        	                 	            
	        	            //Warenkorb.warenkorbDeleteArticle(warenkorbList.get(selectedCart).getList().get(Integer.parseInt(((JButton) e4.getSource()).getName())));
	        	            writeShoppingCart(cartGrid, cartGridPanel);
	        	            //The Article
	        	            //warenkorbList.get(selectedCart).getList().get(Integer.parseInt(((JButton) e4.getSource()).getName()));
				}});
				productListLayoutPanel.get(panelCounter).add(productListButton.get(i-1));
			}
			productListPanel.get(i).add(productListLayoutPanel.get(panelCounter), BorderLayout.LINE_END);
			panelCounter++;
			
			cartGridPanel.add(productListPanel.get(i));
			productListPanel.get(i).setAlignmentX(LEFT_ALIGNMENT);
			
			cartGridPanel.updateUI();
			
		}
		for(int c = 3; c < productListLayoutPanel.size(); c++) {
			productListLayoutPanel.get(c).setBackground(Color.decode(ColorPalette.getColorPalette(1)));
		}
		for(int o = 0; o < 3; o++) {
			productListLayoutPanel.get(o).setBackground(Color.decode(ColorPalette.getColorPalette(0)));
		}
		for(int z = 0; z < 4; z++) {
			productListLabel.get(z).setForeground(Color.white);
		}
		
		cartGridPanel.updateUI();
		cartList.get(selectedCart).add(cartGrid, BorderLayout.CENTER);
		
		finalPrice.setText("Final Price: " + warenkorbList.get(selectedCart).getCost()+ "€");

	}

}

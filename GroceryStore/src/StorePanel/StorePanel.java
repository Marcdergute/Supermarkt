package StorePanel;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import article.Article;
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
	public static ArrayList<JButton> productListButton = new ArrayList<JButton>();
	public static ArrayList <Warenkorb> warenkorbList = new ArrayList<Warenkorb>();
	static boolean test;
	public static DecimalFormat f = new DecimalFormat("#0.00");

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
		this.setPreferredSize(new Dimension(1024, 768));
		window.setMinimumSize(new Dimension(800,500));
		this.setLayout(new BorderLayout());
		
		//Change the Frame Icon to a 
		ImageIcon icon = null;
		java.net.URL imgURL = StorePanel.class.getResource("/icon/Market_Icon.png");
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
		StorePanel storePanel = new StorePanel();
		
		Create(storePanel);
		
		hint.setPreferredSize(new Dimension(300 ,50));
		finalPrice.setPreferredSize(new Dimension(200,50));
		
		
		
		
		
		window.add(storePanel);
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
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
					hint.setForeground(Color.red);
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
					hint.setForeground(Color.red);
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
				} catch (Exception e) {
					hint.setText("Hint: First create a shopping cart!");
					hint.setForeground(Color.red);
				}	
			}
		});
		//<<<<<<<<<<<<<<
		
				
		JTabbedPane CartSelector = new JTabbedPane(JTabbedPane.LEFT,JTabbedPane.SCROLL_TAB_LAYOUT);
		
		CartSelector.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				selectedCart = CartSelector.getSelectedIndex();
				//System.out.println(selectedCart);
				writeShoppingCart(cartGrid, cartGridPanel);
			}
		});
		
		String comboBoxList[] = new String[articleList.size()];
	

		
		for(int i = 0; i <= articleList.size()-1; i++) {
			comboBoxList[i]  = articleList.get(i).produkt +" "+ articleList.get(i).verkaufspreis + "€";
		}
		
		
		
	
	
		
		//creates Elements for modePanel
		ButtonGroup modeGroup = new ButtonGroup();
		JRadioButton  stdBtn = new JRadioButton ("Standard Mode", true);
		modeGroup.add(stdBtn);
		JRadioButton  ecoBtn = new JRadioButton ("Eco Mode");
		modeGroup.add(ecoBtn);
		JRadioButton u18Btn = new JRadioButton ("Youth Mode");
		modeGroup.add(u18Btn);
		JRadioButton  empBtn = new JRadioButton ("Employee Mode");
		modeGroup.add(empBtn);
		JRadioButton  savBtn = new JRadioButton ("Save Money Mode");
		modeGroup.add(savBtn);
		JRadioButton  gifBtn = new JRadioButton ("Gift Cart");
		modeGroup.add(gifBtn);
		
		
		JButton addCart = new JButton("Add Card"); 
		addCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isStdSelected = stdBtn.isSelected();
				boolean isEcoSelected = ecoBtn.isSelected();
				boolean isU18Selected = u18Btn.isSelected();
				boolean isEmpSelected = empBtn.isSelected();
				boolean isSavSelected = savBtn.isSelected();
				boolean isGifSelected = gifBtn.isSelected();
				test = true;
				
				if(isGifSelected == false) {
					CartNamePopUpPane cartNamePane = new CartNamePopUpPane();
					cartName = cartNamePane.getCartNameValue();
					if(cartName.length()< 3) {
						hint.setForeground(Color.red);
						hint.setText("Hint: Your name must contain at least 3 characters!");
						test = false;
					}else if(cartName.equals("random")) {
						cartName = cartNamePane.getRandomName();
						hint.setForeground(Color.black);
						hint.setText("Hint: "); 		
					}else{
						hint.setForeground(Color.black);
						hint.setText("Hint: "); 
					}
				}
				if(test == true) {
					if (isEcoSelected) {

						warenkorbList.add(Functions.addShoppingCart(1));
					}else if(isU18Selected) {
						warenkorbList.add(new Warenkorb(2));
					}else if(isEmpSelected) {
						warenkorbList.add(new Warenkorb(3));
					}else if(isSavSelected) {
						warenkorbList.add(new Warenkorb(4));
					}else if(isGifSelected){
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
							
						
					}else if(isStdSelected){
						warenkorbList.add(new Warenkorb(0));
					}	
					if(test == true) {
						if(isGifSelected) {
							test  = false;
						}
						addShoppingCard(CartSelector, comboBoxList, cartGrid, cartGridPanel);
					}
				}
			}
		});
		
		//Creates pay Button
		JButton payBtn = new JButton("Pay");
		
		payBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e20) {
				try {
					
					CartSelector.setForegroundAt(selectedCart, Color.green);
					//CartSelector.removeTabAt(selectedCart);
					//cartCounter--;
				} catch (Exception e) {
					System.out.println("An Error occured!");
				}
			
				//CartSelector.removeTab(cartList.get(selectedCart));
			}
		});
	
		//modePanel
		modePanel.add(stdBtn);
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
		cartName = "";
		
		if(test == true) {
			JPanel topProductSelection = new JPanel();
			if(warenkorbList.get(cartCounter).property == 3) {
				for(int i = 0; i <= articleList.size()-1; i++) {
					comboBoxList[i]  = articleList.get(i).produkt +" "+ f.format(articleList.get(i).einkaufspreis) + "€";
				}
			}
			JComboBox<?> productSelection1 = new JComboBox<Object>(comboBoxList);
			
			JButton addProductBtn = new JButton("+");
			addProductBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e3) {
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
		test = true;	
		cartCounter++;
	}
	
	public static void writeShoppingCart(JScrollPane cartGrid, JPanel cartGridPanel) {
	
		productListPanel.clear();
		productListLabel.clear();
		productListButton.clear();
		labelCounter = 0;
		
		cartGridPanel.removeAll();

		
		for(int i = 0; i <= warenkorbList.get(selectedCart).getList().size();i++) {	
			
			//if(i == -1) {
//					System.out.println("hallo"+i);
////				for(int k = 0; k < 1; k++) {
////					productListPanel.add(new JPanel());
////					productListPanel.get(i).setLayout(new BorderLayout());
////					productListLabel.add(new JLabel("Article Name"));
////					productListLabel.get(labelCounter).setPreferredSize(new Dimension(200, 30));
////					productListLayoutPanel.add(new JPanel());
////					productListLayoutPanel.get(panelCounter).add(productListLabel.get(labelCounter));
////					productListPanel.get(i).add(productListLayoutPanel.get(panelCounter), BorderLayout.LINE_START);
////					labelCounter ++;
////					panelCounter ++;
////				}
//				i=i+1;
//				System.out.println(i);
//			}
			
				
			productListPanel.add(new JPanel());
			productListPanel.get(i).setLayout(new BorderLayout());
			
			
			//Adding Product to the Panel
			if(i == 0) {
				productListLabel.add(new JLabel("Product Name"));
				productListLabel.get(labelCounter).setFont(new Font("Calibri", Font.BOLD, 16));
			}else {
				productListLabel.add(new JLabel(warenkorbList.get(selectedCart).getList().get(i-1).produkt));
			}
			productListLabel.get(labelCounter).setPreferredSize(new Dimension(200, 30));
			productListLayoutPanel.add(new JPanel());
			productListLayoutPanel.get(panelCounter).add(productListLabel.get(labelCounter));
			productListPanel.get(i).add(productListLayoutPanel.get(panelCounter), BorderLayout.LINE_START);
			labelCounter ++;
			panelCounter ++;
			
			
			//Adding Category to the panel
			if(i==0) {
				productListLabel.add(new JLabel("Category"));
				productListLabel.get(labelCounter).setFont(new Font("Calibri", Font.BOLD, 16));
				
			}else {
				productListLabel.add(new JLabel(warenkorbList.get(selectedCart).getList().get(i-1).kategorie));
				
			}
			productListLabel.get(labelCounter).setPreferredSize(new Dimension(200, 30));
			productListLayoutPanel.add(new JPanel());
			productListLayoutPanel.get(panelCounter).add(productListLabel.get(labelCounter));
			productListPanel.get(i).add(productListLayoutPanel.get(panelCounter), BorderLayout.CENTER);	
			labelCounter ++;
			
			
			//Adding Property to the panel
			if(i==0) {
				productListLabel.add(new JLabel("Property"));
				productListLabel.get(labelCounter).setFont(new Font("Calibri", Font.BOLD, 16));
			}else {
				productListLabel.add(new JLabel(Functions.getSpecialProperty(warenkorbList.get(selectedCart).getList().get(i-1))));
			}
			productListLabel.get(labelCounter).setPreferredSize(new Dimension(100, 30));
			productListLayoutPanel.get(panelCounter).add(productListLabel.get(labelCounter));
			productListPanel.get(i).add(productListLayoutPanel.get(panelCounter), BorderLayout.CENTER);	
			productListLabel.get(labelCounter).setForeground(Color.black);
			//Highlights the lowest or the highest BBD or Recycling Value in blue or red>>>>>
			if(i!=0) {
				if(warenkorbList.get(selectedCart).getList().get(i-1).produkt == selectedHighProduct[0] || warenkorbList.get(selectedCart).getList().get(i-1).produkt == selectedHighProduct[1]) {
					productListLabel.get(labelCounter).setForeground(Color.red);
				}else if(warenkorbList.get(selectedCart).getList().get(i-1).produkt == selectedLowProduct[0] || warenkorbList.get(selectedCart).getList().get(i-1).produkt == selectedLowProduct[1]) {
					productListLabel.get(labelCounter).setForeground(Color.blue);
				}
			}
			//<<<<<<<<<<<<<<
			labelCounter ++;
			panelCounter ++;
			
			
			//Adding Price to the Panel
			
			if(warenkorbList.get(selectedCart).property == 3) {
			productListLabel.add(new JLabel(f.format(warenkorbList.get(selectedCart).getList().get(i).einkaufspreis)+"€"+"     "));
		}
				else {
					productListLabel.add(new JLabel(f.format(warenkorbList.get(selectedCart).getList().get(i).verkaufspreis)+"€"+"     "));
				}
			productListLabel.get(labelCounter).setPreferredSize(new Dimension(100, 30));
			productListLayoutPanel.add(new JPanel());
			productListLayoutPanel.get(panelCounter).add(productListLabel.get(labelCounter));
			productListPanel.get(i).add(productListLayoutPanel.get(panelCounter), BorderLayout.LINE_END);	
			labelCounter ++;
			
			
			//Adding the removeButton to the panel
			if(i!=0) {
				productListButton.add(new JButton("-"));
				productListButton.get(i-1).setName(Integer.toString(i-1));
				productListButton.get(i-1).addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e4) {
	        	            System.out.println(((JButton) e4.getSource()).getName()); // get the index as a string from the button
	        	            System.out.println(warenkorbList.get(selectedCart).getList().get((Integer.parseInt(((JButton) e4.getSource()).getName()))).produkt);
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
		cartGridPanel.updateUI();
		cartList.get(selectedCart).add(cartGrid, BorderLayout.CENTER);
		
		finalPrice.setText("Final Price: " +f.format( warenkorbList.get(selectedCart).getCost())+ "€");

	}

}

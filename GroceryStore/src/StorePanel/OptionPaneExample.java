package StorePanel;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import StorePanel.StorePanel;


public class OptionPaneExample {
	String giftCartValue;
	JFrame giftCart;
	public OptionPaneExample() {
		giftCart = new JFrame();
		giftCartValue = JOptionPane.showInputDialog(giftCart,"Enter your Giftcart Value!");   
		
	}
	
	public Double getGiftCartValue() {
		return Double.parseDouble(giftCartValue);
	}
}

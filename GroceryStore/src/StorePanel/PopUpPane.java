package StorePanel;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class PopUpPane {
	String giftCartValue;
	JFrame giftCart;
	public PopUpPane() {
		giftCart = new JFrame();
		giftCartValue = JOptionPane.showInputDialog(giftCart,"Enter your Giftcart Value!");   
		
	}
	
	public Double getGiftCartValue() {
		return Double.parseDouble(giftCartValue);
	}
}

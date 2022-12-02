package StorePanel;

import javax.swing.JDialog;
import javax.swing.JLabel;
import static warenkorb.Functions.dailyIncome;
public class IncomePopUpPane{
	
    public IncomePopUpPane(){
    
        JDialog incomePane = new JDialog();
        incomePane.setTitle("Daily Income");
        incomePane.setSize(300,200);
        incomePane.setModal(true);
        incomePane.setLocationRelativeTo(null);
        incomePane.add(new JLabel("The Daily Income is: "+ Double.toString(dailyIncome)+"€"));
        incomePane.setVisible(true);
    }
}

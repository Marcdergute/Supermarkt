package StorePanel;

import javax.swing.JDialog;
import javax.swing.JLabel;
import warenkorb.Functions;
import static warenkorb.Functions.dailyIncome;
public class IncomePopUpPane{
    public static void main(String[] args){
    
        JDialog incomePane = new JDialog();
        incomePane.setTitle("Daily Income");
        incomePane.setSize(300,200);
        incomePane.setModal(true);
        incomePane.setLocationRelativeTo(null);
        incomePane.add(new JLabel(dailyIncome);
        incomePane.setVisible(true);
    }
}


import article.Article  ;
import StorePanel.StorePanel;
import java.util.ArrayList;
import warenkorb.Warenkorb;
import static importing.Importing.articleGenerate;


public class Main {

	public static ArrayList <Article> articleList = new ArrayList<Article>();
	public static ArrayList <Warenkorb> warenkorbList = new ArrayList<Warenkorb>();
	


	

	public static void main(String[] args) {
		
		articleGenerate();

		StorePanel.startStorePanel();

		
	}

}





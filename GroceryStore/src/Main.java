/**
 * Die Hauptklasse der Anwendung.
 *
 * @author Marc Grethlein
 * 
 */
import StorePanel.StorePanel;
import static importing.Importing.articleGenerate;

public class Main {

    /**
     * Die Hauptmethode der Anwendung.
     *
     * Generiert Artikel und startet das Hauptfenster der Anwendung.
     *
     * @param args Ein Array von Argumenten, die von der Kommandozeile übergeben werden.
     */
    public static void main(String[] args) {
        articleGenerate();
        StorePanel.startStorePanel();
    }
}
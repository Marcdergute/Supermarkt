/**

Die Klasse Warenkorb stellt einen Warenkorb in einem Geschäft dar.

Ein Warenkorb hat eine Eigenschaft (Property), eine Liste von Artikeln, die sich im Warenkorb befinden,

einen Gesamtpreis für die Artikel im Warenkorb und einen Wert, der angibt, ob der Warenkorb bereits bezahlt wurde.
*/

package warenkorb;

import article.Article;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Warenkorb {

	/**

	Liste der Artikel, die sich im Warenkorb befinden.
	*/
	public List<Article> list = new ArrayList<Article>();
	/*
	Eigenschaft des Warenkorbs 
	*/
	public int property;
	/*
	Gesamtpreis der Artikel im Warenkorb.
	*/
	public double cost;
	/*
	Gibt an, ob der Warenkorb bereits bezahlt wurde.
	*/
	public boolean payed;
	/*
	Gibt an, ob ein Artikel zum Warenkorb hinzugefügt oder daraus entfernt wird.
	*/
	public boolean addRemove;
	/**

	Konstruktor der Klasse Warenkorb. Erstellt einen neuen Warenkorb mit der angegebenen Eigenschaft.
	@param property Eigenschaft des Warenkorbs
	*/



    public Warenkorb(int property) {

        this.property = property;
        this.cost = 0;
        this.payed = false;

    }

    /**

    Gibt die Liste der Artikel im Warenkorb zurück.
    @return Die Liste der Artikel im Warenkorb.
    */
    public List<Article> getList() {
    return list;
    }
    /**

    Gibt eine bestimmte Eigenschaft des Warenkorbs zurück.
    @return Die Eigenschaft des Warenkorbs.
    */
    public int getProperty() {
    return property;
    }
    /**

    Gibt den Gesamtkosten des Warenkorbs zurück.
    @return Die Gesamtkosten des Warenkorbs.
    */
    public double getCost() {
    return cost;
    }
    /**

    Gibt zurück, ob der Warenkorb bezahlt wurde oder nicht.
    @return true, wenn der Warenkorb bezahlt wurde, andernfalls false.
    */
    public boolean isPayed() {
    return payed;
    }
    /**

    Setzt den Warenkorb als bezahlt oder nicht bezahlt.
    @param payed true, wenn der Warenkorb bezahlt wurde, andernfalls false.
    */
    public void setPayed(boolean payed) {
    this.payed = payed;
    }
    /**

    Fügt einen Artikel dem Warenkorb hinzu, wenn die Bedingungen der Eigenschaft des Warenkorbs erfüllt sind.
    @param article Der Artikel, der hinzugefügt werden soll.
    @return true, wenn der Artikel hinzugefügt wurde, false, wenn die Bedingungen der Eigenschaft des Warenkorbs nicht erfüllt sind.
    */
    public boolean warenkorbAdd(Article article) {
        if (check(article)) {
            list.add(article);
            addRemove = true;
            calculateCost(article);
            return true;
        }
        return false;

    }
    
    /**
    Entfernt einen Artikel aus dem Warenkorb.
    @param i Der Index des Artikels, der entfernt werden soll.
    @return true, wenn der Artikel erfolgreich entfernt wurde, false, wenn der Artikel nicht gefunden wurde.
    */
    public boolean warenkorbDeleteArticle(int i) {
    	//calculateCost(article);
    	addRemove = false;
    	calculateCost(list.get(i));
    	list.remove(i);
        return true;

    }
    
    /**

    Gibt den Inhalt des Warenkorbs auf der Konsole aus.
    */
    public void warenkorbPrint() {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(i + " ");
            System.out.print(list.get(i).getKategorie() + " ");
            System.out.print(list.get(i).getVerkaufspreis() + "€ ");
            System.out.println(list.get(i).getProdukt() + " ");

        }
    }
    /**

    Überprüft, ob ein Artikel dem Warenkorb hinzugefügt oder entfernt werden darf auf Grund von den Eigenschaften des Warenkorbs (property).

    @param article Artikel, der überprüft wird

    @return true, wenn der Artikel dem Warenkorb hinzugefügt oder entfernt werden kann, andernfalls false
    */
    public boolean check(Article article) {
        if (property == 1) {
            if (article.getProp() == 1) {
                return false;
            } else return true;
        } else if (property == 2) {
            if (article.getProp() == 2) {
                return false;
            } else return true;
        }else if (property == 3) {
            return true;
        }
        else if (property == 4) {
        	
            if (cost+article.verkaufspreis >= 50) {
                return false;
            } else return true;
        }
        else if (property == 5)  return true;
        else if (property == 0)  return true;
        return false;

    }
    /**

    Berechnet die Gesamtkosten des Warenkorbs basierend auf dem Einkaufspreis oder dem Verkaufspreis
    der Artikel und ob sie hinzugefügt oder entfernt werden.
    @param article der Artikel, dessen Kosten berechnet werden sollen
    */
    public void calculateCost(Article article) {
    	if(addRemove == true) {
    		if (property == 3) {
    			cost += article.einkaufspreis;
    			cost = Math.round(cost*100.0)/100.0;
    		} 
    		else {
    			cost += article.verkaufspreis;
    			cost = Math.round(cost*100.0 )/100.0;
    		}
    	}else {
    		if (property == 3) {
    			cost -= article.einkaufspreis;
    			cost = Math.round(cost*100.0)/100.0;
    		} 
    		else {
    			cost -= article.verkaufspreis;
    			cost = Math.round(cost*100.0 )/100.0;
    		}
    	}
    }
    


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Warenkorb)) return false;
        Warenkorb warenkorb = (Warenkorb) o;
        return property == warenkorb.property && Double.compare(warenkorb.cost, cost) == 0 && payed == warenkorb.payed && Objects.equals(list, warenkorb.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list, property, cost, payed);
    }
}

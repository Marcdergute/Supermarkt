package warenkorb;

import article.Article;

import java.util.ArrayList;
import java.util.List;


public class Warenkorb {

    public List<Article> list = new ArrayList<Article>();
    public int property;
    public double cost;
    public boolean payed;


    public Warenkorb(int property) {

        this.property = property;
        this.cost = 0;
        this.payed = false;

    }

    public List<Article> getList() {
        return list;
    }

    public int getProperty() {
        return property;
    }

    public double getCost() {
        return cost;
    }

    public boolean isPayed() {
        return payed;
    }

    public boolean warenkorbAdd(Article article) {
        if (check(article)) {
            list.add(article);
            calculateCost(article);
            return true;
        }
        return false;

        //TODO: Überprüfung der Eigenschaften

    }

    public void warenkorbPrint() {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(i + " ");
            System.out.print(list.get(i).getKategorie() + " ");
            System.out.print(list.get(i).getEinkaufspreis() + " ");
            System.out.print(list.get(i).getVerkaufspreis() + " ");
            System.out.println(list.get(i).getProdukt() + " ");

        }
    }

    public boolean check(Article article) {
        if (property == 1) {
            if (article.getProdukt() == "Wurst" || article.getProdukt() == "Plastikbesteck") {
                return false;
            } else return true;
        } else if (property == 2) {
            if (article.getProdukt() == "Flasche Wein" || article.getProdukt() == "DVD Actionfilm") {
                return false;
            } else return true;
        }else if (property == 3) {
            return true;
        }
        else if (property == 4) {
            if (cost <= 50) {
                return false;
            } else return true;
        }

        return false;

    }

    public void calculateCost(Article article) {
        if (property == 3) {
            cost += article.einkaufspreis;
        } else cost += article.verkaufspreis;
    }
}

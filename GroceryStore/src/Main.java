
import article.Article  ;

public class Main {


    public static void main(String[] args) {

    	Article a = new Article("Lebensmittel","Mineralwasser",0.40, 0.89);
        a.setMHD("");
        Article b = new Article("Lebensmittel","Toastbrot",0.50, 1.99);
        b.setMHD("");
        Article c = new Article("Lebensmittel","Butter",0.39, 1.49);
        c.setMHD("");
        Article d = new Article("Lebensmittel","Wurst",0.69, 1.99);
        d.setMHD("");
        Article e = new Article("Lebensmittel","Käse",0.49, 1.29);
        e.setMHD("");
        Article f = new Article("Lebensmittel","Flasche Wein",2.30, 6.99);
        f.setMHD("");
        Article g = new Article("Haushaltsartikel","Klobürste",0.99, 4.99);
        g.setRA("");
        Article h = new Article("Haushaltsartikel","Plastikbesteck",0.05, 0.69);
        h.setRA("");
        Article i = new Article("Haushaltsartikel","Putzlappen",0.15, 1.19);
        i.setRA("");
        Article j = new Article("Haushaltsartikel","Zahnpasta",0.50, 1.99);
        j.setRA("");
        Article k = new Article("Sonstige","DVD Actionfilm",0.99, 8.99);
        k.setFSK("");
        Article l = new Article("Sonstige","DVD Familienfilm",0.89, 7.99);
        l.setFSK("");

        System.out.println(g.getRA());
        System.out.println(a.getMHD());
        System.out.println(a.getKategorie());
        System.out.println(a.getEinkaufspreis());
        System.out.println(a.getVerkaufspreis());
        System.out.println(a.getProdukt());
        System.out.println(a.getClass());

    }
}
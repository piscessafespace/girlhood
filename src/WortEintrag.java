import java.util.*;
import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Klasse für einen WortEintrag
 * @author Aho 5bhit
 * @version 19.01.2024
 */
public class WortEintrag {

    // Instanzvariablen für das Wort und die URL
    private String wort;
    private String url;

    // Statische Methode zum Überprüfen der Gültigkeit einer URL
    public static boolean checkURL(String u) throws NullPointerException {
        if(u == null) {
            throw new NullPointerException("URL hat nichts drinnen");
        }
        else {
            try {
                URL web = new URL(u);
                web.toURI();
                return true;
            } catch(MalformedURLException e) {
                return false;
            } catch(URISyntaxException e) {
                return false;
            }
        }
    }

    // Konstruktor für die Klasse
    public WortEintrag(String w, String u) {
        // Überprüft die Gültigkeit der URL und setzt sie nur, wenn gültig
        if(checkURL(u)) {
            this.url = u;
        }
        // Setzt das Wort unabhängig von der Gültigkeit der URL
        this.wort = w;
    }

    // Methode zum Setzen des Worts mit Überprüfung der Mindestlänge
    public void setWort(String w) {
        try {
            if(wort.length() >= 2) {
                this.wort = w;
            } else {
                throw new IllegalArgumentException("Das Wort ist zu kurz!");
            }
        } catch(IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Methode zum Abrufen des Worts
    public String getWort() {
        return this.wort;
    }

    // Methode zum Abrufen der URL
    public String getUrl() {
        return this.url;
    }

    // Methode zum Setzen der URL mit Überprüfung der Gültigkeit
    public void setUrl(String u) {
        if(checkURL(u)) {
            this.url = u;
        }
        else {
            JOptionPane.showMessageDialog(null, "Die URL ist ungültig!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Überschriebene toString-Methode für die Textdarstellung des Objekts
    @Override
    public String toString() {
        return this.wort + " ; " + this.url;
    }
}

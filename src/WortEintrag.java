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

    private  String wort;
    private String url;

    public static boolean checkURL(String u) throws NullPointerException{
        if(u==null) {
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
    public WortEintrag(String w, String u){
        if(checkURL(u)==true){
            this.url = u;
        }
        this.wort = w;
    }

    public void setWort(String w) {
        try {
            if(wort.length() >= 2) {
                this.wort = w;
            }
            else {
                throw new IllegalArgumentException("Das Wort ist zu kurz!");
            }
        }
        catch(IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

}

import java.util.*;

/**
 * Klasse für einen Worttrainer
 * @author Aho 5bhit
 * @version 19.01.2024
 * If only              ╱|、
 * meow               (˚ˎ。7
 * meow                |、˜〵
 * meow               じしˍ,)ノ
 * &  meow             ▒▒▒▒▒▒
 */

public class WortTrainer {

    private WortListe l; // Instanzvariable für die Wortliste

    private int questions; // Anzahl der gestellten Fragen
    private int right;     // Anzahl der richtigen Antworten
    private int wrong;     // Anzahl der falschen Antworten

    // Konstruktor, initialisiert den Worttrainer mit einer gegebenen Wortliste
    public WortTrainer(WortListe liste){
        this.l = liste;
        this.questions = 0;
        this.right = 0;
        this.wrong = 0;
    }

    // Getter-Methode für die Anzahl der gestellten Fragen
    public int getQuestions(){
        return this.questions;
    }

    // Methode zum Hinzufügen von Fragen zur Gesamtanzahl
    public void addQuestions(int n){
        this.questions += n;
    }

    // Methode zum Setzen der Gesamtanzahl der Fragen
    public void setQuestions(int n){
        this.questions = n;
    }

    // Getter-Methode für die Anzahl der falschen Antworten
    public int getWrong(){
        return this.wrong;
    }

    // Getter-Methode für die Anzahl der richtigen Antworten
    public int getRight(){
        return this.right;
    }

    // Setter-Methode für die Anzahl der falschen Antworten
    public void setWrong(int n){
        this.right = n;
    }

    // Setter-Methode für die Anzahl der richtigen Antworten
    public void setRight(int n){
        this.wrong = n;
    }

    // Methode zum Hinzufügen von falschen Antworten zur Gesamtanzahl
    public void addWrong(int n){
        this.right += n;
    }

    // Methode zum Hinzufügen von richtigen Antworten zur Gesamtanzahl
    public void addRight(int n){
        this.wrong += n;
    }

    // Methode zur Berechnung der Fehlerquote
    public String getFehlerQuote(){
        return new String("Von meow " + questions + " Fragen sind meow " + right + " meowichtig & " + wrong + " meowalsch");
    }

    // Methode zum Erhalten eines zufälligen WortEintrags aus der Wortliste
    public WortEintrag getZufallsWort() {
        Random random = new Random(this.l.getLength());
        int r = random.nextInt(this.l.getLength());

        for (int i = 0; i < this.l.getLength(); i++) {
            // Überprüfen, ob der Eintrag an der zufälligen Position nicht null ist
            if (this.l.getEintrag(r) != null) {
                return this.l.getEintrag(r);
            }
        }
        return null; // Rückgabe null, wenn kein gültiger Eintrag gefunden wurde
    }

    // Methode zum Erhalten eines WortEintrags an einer bestimmten Position in der Wortliste
    public WortEintrag getWort(int iii){
        return this.l.getEintrag(iii);
    }

    // Methode zum Erhalten der gesamten Wortliste
    public WortListe getWortListe(){
        return this.l;
    }

    // Methode zur Überprüfung der Antwort auf eine Frage an einer bestimmten Position in der Wortliste
    public boolean check(String w, int iii){
        this.questions++;

        // Überprüfen, ob die eingegebene Antwort mit dem WortEintrag übereinstimmt
        if(this.l.getEintrag(iii).getWort().equals(w)) {
            this.right++;
            return true;
        }
        this.wrong++;
        return false;
    }

    // Methode zur Überprüfung der Antwort (ohne Beachtung der Groß- und Kleinschreibung) auf eine Frage
    public boolean checkIgnoreCase(String w, int iii){
        this.questions++;

        // Überprüfen, ob die eingegebene Antwort (ignoriert Groß- und Kleinschreibung) mit dem WortEintrag übereinstimmt
        if(this.l.getEintrag(iii).getWort().toUpperCase().equals(w.toUpperCase())) {
            this.right++;
            return true;
        }
        this.wrong++;
        return false;
    }
}

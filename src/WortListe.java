import java.util.Arrays;

/**
 * Klasse für eine Wortliste Klasse
 * @author Aho 5bhit
 * @version 19.01.2024
 */
public class WortListe {

    private WortEintrag[] eintrag; // Array, das die WortEinträge speichert

    // Konstruktor für eine leere Wortliste
    public WortListe() {
        this.eintrag = new WortEintrag[0];
    }

    // Konstruktor für eine Wortliste mit einer maximalen Anzahl von Einträgen
    public WortListe(int maxw) {
        this.eintrag = new WortEintrag[maxw];
    }

    // Methode zum Hinzufügen eines WortEintrags zur Liste
    public boolean addWort(WortEintrag www) {
        boolean added = false;

        for (int i = 0; i < eintrag.length && !added; i++) {
            if (this.eintrag[i] == null) {
                this.eintrag[i] = www;
                added = true;
            }
        }

        // Wenn kein Platz gefunden wurde, wird das Array um einen Platz erweitert
        if (!added) {
            this.eintrag = Arrays.copyOf(this.eintrag, this.eintrag.length + 1);
            this.eintrag[this.eintrag.length - 1] = www;
        }
        return added;
    }

    // Methode zum Abrufen eines WortEintrags an einer bestimmten Position im Array
    public WortEintrag getEintrag(int index) {
        for (int i = 0; i < eintrag.length; i++) {
            if (eintrag[i] != null) {
                if (i == index) {
                    return this.eintrag[i];
                }
            }
        }
        // Wenn die angegebene Position nicht vorhanden ist, wird der erste Eintrag zurückgegeben
        return this.eintrag[0];
    }

    // Methode zum Abrufen des gesamten Arrays von WortEinträgen
    public WortEintrag[] getEintragArray() {
        return this.eintrag;
    }

    // Methode zur Rückgabe der Länge der Wortliste (Anzahl der Einträge)
    public int getLength(){
        return eintrag.length;
    }

    // Überschriebene Methode für die Darstellung der Wortliste als String
    @Override
    public String toString(){
        String liste = "";

        // Zusammenstellung der Wortliste als Zeichenkette
        for(int i = 0 ; i < getLength() ; i++){
            liste += "\n" + this.eintrag[i];
        }
        return liste;
    }

    // Methode zum Löschen eines WortEintrags anhand des Wortes
    public boolean DelWort(String word){
        for(int i = 0 ; i < getLength() ; i++){
            if (eintrag[i] != null) {
                if(eintrag[i].getWort().equals(word)) {
                    eintrag[i] = null; // Löschen des Eintrags
                    return true;
                }
            }
        }
        return false; // Rückgabe false, wenn das Wort nicht gefunden wurde
    }
}

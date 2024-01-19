import java.util.Arrays;
/**
 * Klasse für eine Wortliste Klasse
 * @author Aho 5bhit
 * @version 19.01.2024
 */
public class WortListe {

    private WortEintrag[] eintrag;

    public WortListe() {
        this.eintrag = new WortEintrag[0];

    }

    public WortListe(int maxw) {
        this.eintrag = new WortEintrag[maxw];

    }

    public boolean addWort(WortEintrag www) {
        boolean added = false;

        for (int i = 0; i < eintrag.length && added == false; i++) {
            if (this.eintrag[i] == null) {
                this.eintrag[i] = www;
                added = true;

            }
        }
        if (added == false) {
            this.eintrag = Arrays.copyOf(this.eintrag, this.eintrag.length + 1);
            this.eintrag[this.eintrag.length - 1] = www;

        }
        return added;

    }

    public WortEintrag getEintrag(int index) {
        for (int i = 0; i < eintrag.length; i++) {
            if (eintrag[i] != null) {
                if (i == index) {
                    return this.eintrag[i];

                }
            }
        }
        return this.eintrag[0];

    }

    public WortEintrag[] getEintragArray() {
        return this.eintrag;

    }

    public int getLength(){
        return eintrag.length;
    }

    @Override
    public String toString(){
        String liste = "";

        for(int i = 0 ; i < getLength() ; i++){
            liste += "\n" + this.eintrag[i];

        }
        return liste;

    }

    public boolean DelWort(String word){
        for(int i = 0 ; i < getLength() ; i++){
            if (eintrag[i] != null) {
                if(eintrag[i].getWort().equals(word)) {
                    eintrag[i] = null;
                    return true;
                }
            }
        }
        return false;
    }
}

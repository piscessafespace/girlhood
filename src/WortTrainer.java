import java.util.*;

/**
 * Klasse für einen Worttrainer
 * @author Aho 5bhit
 * @version 19.01.2024
 * If only              ╱|、
 * meow               (˚ˎ。7
 * meow                |、˜〵
 * meow               じしˍ,)ノ
 * &  meow        ▒▒▒▒▒▒
 */

public class WortTrainer {

    private WortListe l;

    private int questions;
    private int right;
    private int wrong;

    public WortTrainer(WortListe liste){

        this.l = liste;
        this.questions = 0;
        this.right= 0;
        this.wrong =0;

    }

    public int getQuestions(){
        return this.questions;

    }

    public void addQuestions(int n){
        this.questions += n;

    }

    public void setQuestions(int n){
        this.questions = n;

    }


    public int getWrong(){
        return this.wrong;

    }

    public int getRight(){
        return this.right;

    }

    public void setWrong(int n){
        this.right = n;

    }

    public void setRight(int n){
        this.wrong = n;

    }

    public void addWrong(int n){
        this.right += n;

    }

    public void addRight(int n){
        this.wrong += n;

    }

    public String getFehlerQuote(){
        return new String("Von meow " +questions+ " Fragen sind meow "+right+" meowichtig & "+wrong+" meowalsch");

    }

    public WortEintrag getZufallsWort() {
        Random random = new Random(this.l.getLength());
        int r = random.nextInt(this.l.getLength());

        for (int i = 0; i < this.l.getLength(); i++) {
            if(this.l.getEintrag(r)!=null){
                return this.l.getEintrag(r);

            }
        }
        return null;

    }

    //Das werden wir dann in der App Klasse verwenden
    public WortEintrag getWort(int iii){
        return this.l.getEintrag(iii);

    }

    //Das hier auch
    public WortListe getWortListe(){
        return this.l;

    }

    public boolean check(String w, int iii){
        this.questions++;

        if(this.l.getEintrag(iii).getWort().equals(w)) {
            this.right++;
            return true;

        }
        this.wrong++;
        return false;

    }


    public boolean checkIgnoreCase(String w, int iii){
        this.questions++;

        //macht eif beide Woerter in uppercase und schaut nach ob sie immernoch dasselbe wort sind, wenn ja gibts noch einen Extra Punkt
        if(this.l.getEintrag(iii).getWort().toUpperCase().equals(w.toUpperCase())) {
            this.right++;
            return true;

        }
        this.wrong++;
        return false;

    }
}

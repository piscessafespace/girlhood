import java.util.*;

/**
 * Klasse für einen Worttrainer
 * @author Aho 5bhit
 * @version 19.01.2024
 */

public class WortTrainer {

    private int questions;
    private int right;
    private int wrong;

    public WortTrainer(){

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
}

import java.io.*;
import java.util.Scanner;
/**
 * Die Klasse SpeicherLaden
 * @author Aho 5bhit
 * @version 19.01.2024
 */
public class SpeichernLadenTxt implements SuLInterface{
    private WortTrainer trainer;
    private String filename = "Worttrainer.txt";

    public SpeichernLadenTxt(WortTrainer t){
        this.trainer = t;
    }

    public WortEintrag getWort(int index) {
        return this.trainer.getWort(index);
    }

    public int getTrue(){
        return this.trainer.getRight();
    }

    public int getFalse(){
        return this.trainer.getWrong();
    }

    public int getTries(){
        return this.trainer.getQuestions();
    }

    public void speichern(String filename) throws IOException{
        File f = new File(filename);
        BufferedWriter writer = null;
        writer = new BufferedWriter(new FileWriter(f));
        writer.write(trainer.getQuestions() + System.lineSeparator() +trainer.getRight() + System.lineSeparator() +trainer.getWrong() + System.lineSeparator());
        writer.close();
    }

    public void speichern() throws IOException{
        speichern(this.filename);
    }


    public void laden(String filename) throws IOException {
        Scanner reader = new Scanner(new BufferedReader(new FileReader(filename)));
        try {
            int fragen = Integer.parseInt(reader.nextLine());
            int richtige = Integer.parseInt(reader.nextLine());
            int falsche = Integer.parseInt(reader.nextLine());
            trainer.addQuestions(fragen);
            trainer.addRight(richtige);
            trainer.addWrong(falsche);
        } finally {
            reader.close();
        }
    }

    public void laden() throws IOException {
        laden(this.filename);
    }
}

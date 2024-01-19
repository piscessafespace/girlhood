import java.io.*;
import java.util.Scanner;
/**
 * Die Klasse SpeicherLaden
 * @author Aho 5bhit
 * @version 19.01.2024
 */
public class SpeichernLadenTxt implements SuLInterface{
    // Klasse zum Speichern und Laden von WortTrainer-Daten in einer Textdatei

        // Instanzvariable für den WortTrainer
        private WortTrainer trainer;

        // Standarddateiname für das Speichern und Laden
        private String filename = "Worttrainer.txt";

        // Konstruktor, der den WortTrainer übernimmt
        public SpeichernLadenTxt(WortTrainer t){
            this.trainer = t;
        }

        // Methode, um ein WortEintrag-Objekt anhand des Index zu erhalten
        public WortEintrag getWort(int index) {
            return this.trainer.getWort(index);
        }

        // Methoden, um die Anzahl der richtigen, falschen und insgesamt gestellten Fragen abzurufen
        public int getTrue(){
            return this.trainer.getRight();
        }

        public int getFalse(){
            return this.trainer.getWrong();
        }

        public int getTries(){
            return this.trainer.getQuestions();
        }

        // Methode zum Speichern von Trainerdaten in einer Textdatei
        public void speichern(String filename) throws IOException{
            File f = new File(filename);
            BufferedWriter writer = null;
            try {
                // FileWriter zum Schreiben in die Datei
                writer = new BufferedWriter(new FileWriter(f));
                // Schreibe Anzahl der Fragen, Anzahl der richtigen und Anzahl der falschen Antworten, jeweils durch Zeilenumbruch getrennt
                writer.write(trainer.getQuestions() + System.lineSeparator() + trainer.getRight() + System.lineSeparator() + trainer.getWrong() + System.lineSeparator());
            } finally {
                // Schließe den BufferedWriter
                if (writer != null) {
                    writer.close();
                }
            }
        }

        // Überladene Methode, um Trainerdaten in die Standarddatei zu speichern
        public void speichern() throws IOException{
            speichern(this.filename);
        }

        // Methode zum Laden von Trainerdaten aus einer Textdatei
        public void laden(String filename) throws IOException {
            Scanner reader = new Scanner(new BufferedReader(new FileReader(filename)));
            try {
                // Lese Anzahl der Fragen, Anzahl der richtigen und Anzahl der falschen Antworten aus der Datei
                int fragen = Integer.parseInt(reader.nextLine());
                int richtige = Integer.parseInt(reader.nextLine());
                int falsche = Integer.parseInt(reader.nextLine());
                // Aktualisiere den Trainer mit den geladenen Werten
                trainer.addQuestions(fragen);
                trainer.addRight(richtige);
                trainer.addWrong(falsche);
            } finally {
                // Schließe den Scanner
                if (reader != null) {
                    reader.close();
                }
            }
        }

        // Überladene Methode, um Trainerdaten aus der Standarddatei zu laden
        public void laden() throws IOException {
            laden(this.filename);
        }

}

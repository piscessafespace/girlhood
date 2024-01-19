import javax.swing.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

/**
 * Main fuer WortTrainer
 * @author Aho 5bhit
 * @version 19.01.2024
 */

public class App {

    public static void main(String[] args){

        //Wörter initialisieren
        WortEintrag we1 = new WortEintrag("Hund", "https://assets.elanco.com/8e0bf1c2-1ae4-001f-9257-f2be3c683fb1/7ae66d97-8aaa-43c2-a9a9-8a0ede30a1be/labrador_retriever_liegt_bei_sonnenschein_im_park.jpg");
        WortEintrag we2 = new WortEintrag("Apfel", "https://www.mcdonalds.at/wp-content/uploads/2023/02/1500x1500-web-pop-neu-happy-meal-apfel-768x768.png");
        WortEintrag we3 = new WortEintrag("Fussball", "https://assets-de.imgfoot.com/ballon-derbystar-bundesliga-img2.jpg");
        WortEintrag we4 = new WortEintrag("Brot", "https://www.ndr.de/ratgeber/kochen/brot524_v-fullhd.jpg");
        WortEintrag we5 = new WortEintrag("Haus", "https://www.snoozeproject.de/files/uploads/2021/12/Traumdeutung-Haus.jpg");
        WortEintrag we6 = new WortEintrag("Haare", "https://meraki-hairdesign.ch/wp-content/uploads/2021/07/haare-faerben-600.jpg");

        //Wörter zur Liste hinzufügen
        WortListe wl = new WortListe();
        wl.addWort(we1);
        wl.addWort(we2);
        wl.addWort(we3);
        wl.addWort(we4);
        wl.addWort(we5);
        wl.addWort(we6);

        //Trainer erstellen
        WortTrainer wt = new WortTrainer(wl);

        //speichern und laden deklarieren und versuchen zu laden
        SuLInterface speichern = new SpeichernLadenTxt(wt);
        SuLInterface laden = new SpeichernLadenTxt(wt);
        try {
            laden.laden();
        } catch (IOException e) {
            System.out.println("laden misslungen");
        }

        //Random, Image, und 2 variablen erstellen
        Random r = new Random();
        ImageIcon icon;
        boolean right = false, beenden = false;

        //Solang nicht beendet wird
        while(!beenden){
            //Random Wort
            WortEintrag zufall = wt.getWortListe().getEintragArray()[r.nextInt(wt.getWortListe().getEintragArray().length)];
            //Führ es dasselbe Wort aus solang nicht richtig beantwortet wurde
            do {
                //Bildausgabe
                try {
                    icon = new ImageIcon(new URL(zufall.getUrl()));
                    JOptionPane.showMessageDialog(null, "Was ist auf diesem Bild zu sehen?", "Image", JOptionPane.INFORMATION_MESSAGE, icon);
                    String antwort = JOptionPane.showInputDialog(null, "Was hast du auf dem Bild vorhin gesehen?", "Frage", JOptionPane.QUESTION_MESSAGE).toString();

                    //Wenn nicht geantwortet wurde soll speichern und das Programm aufhören
                    if(antwort.equals("")){
                        try {
                            speichern.speichern();

                        } catch (IOException e) {
                            System.out.println("Speichern fehlgeschlagen");

                        }

                        beenden = true;
                        break;
                    }

                    //Wenn das Wort übereinstimmt
                    if(antwort.equals(zufall.getWort())){
                        JOptionPane.showMessageDialog(null, "Super, richtig!");
                        wt.addRight(1);
                        wt.addQuestions(1);
                        right = true;

                        //Wenn das Wort nicht übereinstimmt
                    }else{
                        JOptionPane.showMessageDialog(null, "Leider falsch!");
                        wt.addWrong(1);
                        wt.addQuestions(1);
                        right = false;

                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();

                }
            } while (!right);

        }

        //Fehlerquote soll ausgegeben werden
        JOptionPane.showMessageDialog(null, wt.getFehlerQuote(), "Auswertung",JOptionPane.INFORMATION_MESSAGE);
    }
}

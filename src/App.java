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

        //HAB COOLERE BILDER GEFUNDEN HAHAH AICH LIEBE PINTEREST
        WortEintrag we1 = new WortEintrag("Madoka Kaname", "https://i.pinimg.com/736x/45/09/c7/4509c76ea660d121c11c303a31908c23.jpg");
        WortEintrag we2 = new WortEintrag("Homura Akemi", "https://i.pinimg.com/736x/68/fd/b6/68fdb6b53feb132bad8845b246aaba19.jpg");
        WortEintrag we3 = new WortEintrag("Sayaka Miki", "https://i.pinimg.com/736x/f5/71/7a/f5717a7bf73600a02ff9638712847744.jpg");
        WortEintrag we4 = new WortEintrag("Kyoko Sakura", "https://i.pinimg.com/736x/64/32/9a/64329ab49b4c6f66c89dd9537d667725.jpg");
        WortEintrag we5 = new WortEintrag("Nagisa Momoe", "https://i.pinimg.com/736x/d6/02/53/d602534dc7c676657797b6ad804c287f.jpg");
        WortEintrag we6 = new WortEintrag("Mami Tomoe", "https://i.pinimg.com/736x/5f/37/47/5f3747763fda0366c2e5e27dfa0dfcd5.jpg");

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
/*
*⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⡿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⠟⠻⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⠏⠀⠙⠻⣦⠀⠀⢀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⠏⠀⠀⠈⠻⣄⠀⠀⠀⠀⠀⢀⣠⣤⣶⣶⣶⣶⣤⡄⠀⠀⠀⠀
⠀⠀⠀⠀⢰⡖⠒⠶⠤⣤⣤⣀⠀⠀⠀⠀⣼⠏⠀⠀⠀⣠⡾⠳⣤⡏⠉⠙⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠏⠀⠀⠀⠀⠀⢹⡄⠀⣠⡶⠞⠋⠉⠉⠀⠀⠀⢈⣿⡇⠀⠀⠀⠀
⠀⠀⠀⠠⣿⠀⠀⠀⠀⠀⠈⠉⠛⠷⣤⣠⡿⠀⠀⠀⣰⢿⡀⠀⠈⠀⢀⣤⠿⠒⠛⠛⠛⠛⠛⠛⠛⠓⠲⠶⢄⣼⣀⠀⠀⠀⠀⠀⢈⡿⠚⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡇⠀⠀⠀⠀
⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠌⠻⣇⠀⠀⣼⠋⠀⣩⡷⠦⠶⠋⠁⠀⠀⠀⠀⠀⠀⠀⣀⡀⠀⠀⠀⠀⠈⠙⠻⠦⣄⠀⣴⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⢸⡇⠀⠀⠀⠀
⠀⠀⠀⠀⢻⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⡽⣧⡀⢁⡼⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣷⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⣧⡀⠀⠀⣠⡴⠛⣿⠁⠀⠀⠀⠀⢸⣾⠇⠀⠀⠀⠀
⠀⠀⠀⠀⢸⡇⠀⠀⠀⠀⠀⠘⣷⡲⠶⣄⡉⢸⣷⠋⠀⠀⠀⠀⠀⠀⠀⠀⢰⡖⠀⠀⠀⠀⠀⠀⡿⠀⠀⠀⠀⠀⢀⠀⠀⠀⠀⠈⠻⣶⠛⠉⠀⠞⠁⠀⠀⠀⠀⢰⣿⡟⠀⠀⠀⠀⠀
⠀⠀⠀⣠⡾⢿⡆⠀⠀⠀⠀⠀⠈⠛⢶⣤⣭⡟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⣄⠀⢀⡷⠀⠀⡀⠀⠀⠈⣧⠀⠀⠀⠀⠀⠙⢧⡀⠀⠀⠀⠀⠀⠀⠀⣰⣿⣄⠀⠀⠀⠀⠀
⠀⠴⠿⢿⡶⠃⢻⣄⠀⠀⠀⠀⠀⠀⠀⣼⠟⠀⠀⢀⡀⠀⠀⠀⠀⠀⠀⢠⡟⠀⠀⠀⠀⠀⠀⣸⡇⠀⠀⢳⡀⠀⠀⠸⡄⠀⠀⠀⠀⠀⠈⣿⡟⠓⠀⠀⠀⠀⣴⠏⠰⣭⣷⡦⠄⠀⠀
⠀⠀⢠⡿⠁⠀⠀⠙⣷⡄⠀⢀⣀⣴⣿⠏⠀⠀⠀⢸⡇⠀⠀⠀⠀⠀⠀⣸⣇⠀⠀⠀⠀⢀⠀⣿⡄⣀⣀⣸⣧⠀⠀⠀⣿⠀⠀⠀⠀⠀⠀⠘⣿⡘⠻⢦⡀⠀⣿⠀⠀⠹⣇⠀⠀⠀⠀
⠀⠀⣾⠇⠀⠀⠀⠀⢈⣿⠀⡈⢉⣽⠃⠀⠀⠀⠀⣿⠀⠀⢀⣤⡾⠋⠉⣹⠛⠁⠀⠀⢰⡟⢰⡟⣷⠀⠀⠀⣿⣿⠳⢦⣸⡇⠀⠀⡄⠀⠀⠀⣘⢧⡀⠈⡇⠀⣿⠀⠀⠀⣹⣧⠀⠀⠀
⠀⠀⡿⣀⠀⠀⢀⣾⠛⣿⣆⣸⣿⠇⣶⠃⠀⠀⠀⣿⣦⠞⠁⢸⡇⠀⣼⢿⠀⠀⠀⣰⣿⠀⡸⠀⠘⣧⠀⠀⢸⣿⣆⠀⠘⣿⢆⢀⡇⠀⠀⠀⣽⡜⢿⣴⣶⣴⠏⠀⠀⠀⣷⣜⢳⣄⠀
⢠⢱⣷⣿⠀⠀⣾⢁⣼⠁⣿⡿⡋⢸⡏⠀⠀⢠⠀⢸⡇⠀⠀⣿⠃⢸⠃⢸⠀⠀⣴⠋⡸⣰⠇⠀⠀⠈⢧⡀⠀⡇⠹⣆⠀⣿⡎⣀⡃⠀⠀⠀⡿⣿⢶⣿⣿⡿⡄⠀⠀⠀⢸⡏⠙⠛⠓
⢠⣿⣿⡇⠀⣼⢃⡾⢃⣾⣿⣧⣵⣿⠁⠀⠀⠈⣇⢸⡇⠀⢸⢻⣦⡇⠀⢸⠀⣴⠃⢀⣷⠟⠀⠀⠀⠀⠀⠳⣄⢹⠀⢹⡄⡧⢷⣽⠃⠀⣀⠀⢾⣿⣾⣿⣋⠀⠹⣆⠀⢆⢸⡇⠀⠀⠀
⠈⠉⣿⡇⢸⣏⣼⣅⣼⣿⣟⣩⣾⣿⠀⠀⠀⠀⣿⣾⢷⣀⡿⢸⡿⠀⠀⣧⣼⠃⠀⣸⠏⠀⠀⠀⠀⢠⡤⢄⣙⢿⣇⠀⣿⠁⢸⡿⠀⢀⡟⢀⡾⠿⠿⣿⣿⣆⢀⡙⣦⡌⢸⠃⠀⠀⠀
⠀⠀⢿⡇⣸⡇⠉⠉⢉⠉⠁⢭⣿⣿⡀⠀⡇⠀⢹⡏⠘⣿⡇⠈⠁⣀⣰⣿⣄⡀⠘⠁⠀⠀⠀⠀⠀⢀⣿⠿⠶⠶⣽⣄⡈⠀⢸⡇⠀⣼⣇⣾⡅⠀⠀⠟⠛⠛⣿⣿⣿⢿⡟⠀⠀⠀⠀
⠀⠀⠈⣿⣻⣷⢠⠉⠁⠉⠻⠟⠁⠈⢹⣶⣿⡄⢸⣇⠀⠹⣿⠞⠉⠉⠀⠀⠈⠙⠃⠀⠀⠀⠀⠀⠀⠀⠁⠀⠀⠀⠀⠈⢻⣦⢸⠃⢀⣿⣿⣿⣷⡀⠀⠀⢀⣠⣿⣿⣿⣾⠃⠀⠀⠀⠀
⠀⠀⠀⠹⣿⣿⣾⣧⡀⠀⠀⠀⠀⢠⣾⣿⣿⣧⠀⢿⡀⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡀⠀⠀⠀⠀⠀⠀⠀⠀⣼⠀⢸⣿⣿⣿⣿⡟⠋⠉⣩⣩⡿⠃⡿⠃⠀⠀⠀⠀⠀
⠀⠀⠀⠀⢻⣏⢿⣏⡻⠲⢤⣄⣴⣿⣿⣿⣧⣿⣧⡸⣇⠀⠀⠀⠀⠀⠀⠀⢀⡴⠛⠛⠛⠛⠛⠛⠉⠙⢷⡀⠀⠀⠀⠀⠀⢘⣿⣶⣿⣿⣿⣿⣿⣷⡀⠰⣯⡟⠁⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠉⠉⠻⣷⣠⣤⣿⣿⢿⡟⢿⣿⡿⠿⣿⣿⣄⡀⠀⠀⠀⠀⠀⢸⡇⠀⠀⠀⠀⠀⠀⠀⠀⢘⡇⠀⠀⢀⣠⡴⣿⣻⣿⢿⣿⠃⠘⣿⢻⣄⣼⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠈⢿⣧⣿⣿⣟⠀⣀⣿⣇⠀⠙⣿⣏⣽⣷⣶⣤⣤⣄⣸⣇⣀⡀⠀⠀⠀⣀⣀⣠⣼⡷⠞⠻⢯⣾⣄⢹⣿⠃⠛⢃⡴⢾⡟⣮⡿⠁⠀⠀⣀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⣶⣦⣀⠙⣿⠈⢿⠿⡿⠉⢹⣦⣴⣟⣙⣿⠀⠻⠂⡀⠈⠹⢿⣿⣭⠉⢻⣿⣿⠟⣿⣽⡇⠀⠀⠘⠙⠛⠛⢛⡷⣶⡾⠁⠀⠀⠘⣷⣤⠶⠚⣽⠇⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠹⣆⣉⣿⡿⠀⠘⢦⣄⠀⠀⠉⠹⡍⠉⠉⠱⡄⠠⡇⠀⠀⠛⠛⠓⠂⠘⠿⠟⠁⠉⠛⢷⡞⢇⠀⠀⠀⠀⢀⠁⠀⠀⢀⡴⠀⠀⠉⠁⢠⣾⣇⣀⣀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⣠⡤⠼⠟⠋⠀⠀⠀⠀⢈⣙⣿⠗⠒⠃⠀⣀⡼⢃⣀⣠⣴⣷⠦⣶⠛⡗⠲⡖⠀⢻⢸⡷⣾⣧⣈⠓⠲⢤⣄⣼⣧⡴⣿⣉⣀⠀⠀⠀⠀⠀⢸⣿⣿⡿⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠈⠙⠳⣶⠶⠀⣀⣤⣶⣶⠿⠋⠀⠀⢀⣴⠿⠿⣶⣶⡿⠾⢿⡟⠀⣀⣀⠀⢰⣷⠀⢸⢨⣙⠉⣿⠳⠤⠞⠛⠋⠀⣽⠃⠀⠀⠻⠿⠶⢦⣤⣤⣈⣻⣿⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⢹⣿⡶⠟⠛⠻⣶⢶⣤⣀⣤⣿⡉⠀⠀⢀⡾⠟⢷⣄⣼⠁⢀⡁⣹⠀⢸⣿⠀⢸⢀⣼⣄⣿⡆⢀⣤⣄⡀⠀⠈⢹⣿⡗⠀⣠⣤⣀⡟⠁⢻⠛⠉⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⢠⣶⡿⠛⠉⠙⠓⠲⣤⣇⠀⠀⠀⠀⠘⣷⣀⣶⠏⠀⢀⡈⠛⠟⠉⠉⠻⣿⠀⢸⢿⠀⢸⣿⠀⠈⠙⣿⠉⠀⠀⠙⣆⣠⡟⠀⠙⠋⠁⠀⠀⠀⣰⡟⠀⢀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⣾⡏⠀⠀⠀⠀⠀⠀⠈⠙⠆⠀⠀⠀⠀⣼⡿⣿⣷⣾⣿⣇⠀⠀⠀⠀⣰⡟⠓⠛⠛⠲⢾⡃⠀⠀⠀⠈⣶⣤⣤⣴⣿⡏⠀⠀⠀⠀⠀⠀⠀⠐⠛⠉⠉⠙⠻⣦⡀⠀⠀⠀⠀
⠀⠀⠀⠀⣿⡇⠀⠀⠀⠀⠀⠀⠀⢀⣤⠞⠛⢧⡾⠋⠀⠸⠷⠾⣿⣏⣻⣦⡤⠴⠋⠀⠀⠀⠀⠀⠀⢷⣵⣤⠶⣾⠿⣿⣿⣿⠏⠻⣦⣀⠤⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⣽⡇⠀⠀⠀⠀
⠀⠀⠀⠀⠘⢿⣄⠀⠀⠀⠀⠀⠀⢸⣇⣀⣠⠾⢿⡿⠿⢶⣶⣶⣶⣯⡉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠚⠿⢤⣽⣤⣼⣯⣥⣤⣤⣾⣿⠀⣸⣷⡀⠀⠀⠀⠀⠀⠀⣸⣿⠇⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠙⢦⣄⠀⠀⠀⠀⠀⠙⢿⡻⠇⠀⠛⠀⠀⠀⠀⠈⢻⣷⣄⠀⠀⠀⣠⣴⣿⣿⣦⡀⠀⠀⠀⣼⣿⠛⠛⠛⠛⠋⠛⠋⠁⠀⠛⣤⡇⠀⠀⠀⠀⠀⣴⣿⠏⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠉⠻⣶⣄⠀⠀⠀⠈⠙⠻⣇⠀⢀⣆⠐⠲⠶⣤⣹⣿⣷⣶⡿⠟⠋⠁⠙⢿⣿⣶⣤⣾⡿⠋⠀⠀⠀⠀⢰⣄⢀⣸⡿⠋⠉⠀⠀⠀⠀⣠⣾⡿⠃⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⠶⣤⣄⡀⠀⠈⠉⠙⢿⣤⣄⠀⠀⠈⡈⠛⠛⠓⠒⠒⢠⠒⠲⠾⡿⠿⠟⠉⠉⠀⣠⣤⣤⠾⠋⠉⠉⠀⠀⠀⠀⣀⣴⡿⠟⠋⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠛⠶⠦⣤⣀⣈⣿⡳⣶⠟⠛⠛⠦⣤⣀⣀⣼⣦⣄⡤⠷⠤⠄⠤⢴⣾⠋⠀⠀⠀⠀⠀⣀⣀⣤⣴⠿⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠀⢸⡆⠀⠀⠀⠀⠀⢸⣿⢸⠀⠀⠀⠀⠀⠀⢸⡏⢀⣀⣠⡤⠶⠾⠛⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⡄⠀⠀⠀⠀⢸⣿⣾⡀⠀⠀⠀⠀⢀⣿⠛⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
 */

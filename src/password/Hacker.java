package password;

import java.awt.List;

/**
 * Rechnet die Anzahl der benötigten Versuche, um ein Passwort herauszufinden.
 */
public class Hacker {

    /**
     * Sucht nach einem Password im Wörterbuch
     */
    public static int findInWoerterbuch(String input) {
        List mostCommonPasswords = new Woerterbuch().getPasswords();
        int count = -1;
        for (int i = 0; i < mostCommonPasswords.getItemCount(); i++) {
            if (input.equals(mostCommonPasswords.getItem(i))) {
                count = i;
                break;
            }
        }
        return count;
    }

    /**
     * Überprüfe, ob das Password eine Zahl ist.
     * Ist das Passwort eine Zahl, wird die Zahl zurückgegeben. Diese entspricht der Anzahl Versuche.
     */
    public static double findInteger(String input) {
        double number;
        try {
            number = Double.parseDouble(input);
            return number;
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * Überprüfe, ob das Password nur kleine Chars enthält.
     */
    public static double findSmallCharsOnly(String pw){
        double tries = 0;
        for(int i = 0; i < pw.length(); i++) {
            char j = 97;
            int count = 0;
            while (j != pw.charAt(i) && j < 122) {
                j++;
                count++;
            }
            if (j == 122) {
                return -1;
            }
            tries += (long) (count * Math.pow((25), pw.length() - i - 1));
        }
        return tries;
    }

    /**
     * Überprüfe, ob das Password nur grosse Chars enthält.
     */
    public static double findSmallLargeCharsOnly(String pw){
        double tries = 0;
        for(int i = 0; i < pw.length(); i++) {
            char j = 65;
            int count = 0;
            while (j != pw.charAt(i) && j < 122) {
                j++;
                count++;
                if (j == 91) j = 97;
            }
            if (j == 122) {
                return -1;
            }
            tries += (long) (count * Math.pow((50), pw.length() - i - 1));
        }
        return tries;
    }

    /**
     * Überprüfe, ob das Password nur Chars und Numbers enthält.
     */
    public static double findCharsAndNumbers(String pw){
        double tries = 0;
        for(int i = 0; i < pw.length(); i++) {
            char j = 48;
            int count = 0;
            while (j != pw.charAt(i) && j < 122) {
                j++;
                count++;
                if (j == 58) j = 65;
                if (j == 91) j = 97;
            }
            if (j == 122) {
                return -1;
            }
            tries += (long) (count * Math.pow((59), pw.length() - i - 1));
        }
        return tries;
    }

    /**
     * Rechnet, wie lange es dauert, wenn alle Möglichkeiten ausprobiert werden sollen.
     */
    public static double findByBruteForce(String pw) {
        double tries = 0;
        for(int i = 0; i < pw.length(); i++) {
            char j = 0;
            int count = 0;
            while (j != pw.charAt(i) && j < 256) {
                j++;
                count++;
            }
            tries += (long) (count * Math.pow(256, pw.length() - i - 1));
        }
        return tries;
    }

}

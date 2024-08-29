package methoden;

import methoden.woerterbuch.WoerterbuchLoader;

import java.awt.List;

/**
 * Sucht nach einem Password im Wörterbuch
 */
public class Woerterbuch implements SuchMethoden {

    private final List wb;
    private boolean found = false;

    public Woerterbuch() {
        wb = new WoerterbuchLoader().getPasswords();
    }

    @Override
    public double suche(String input) {
        found = false;
        double count = 0;
        for (int i = 0; i < wb.getItemCount(); i++) {
            if (input.equals(wb.getItem(i))) {
                count = i;
                found = true;
                return count;
            }
        }
        return count;
    }

    @Override
    public boolean gefunden() {
        return found;
    }

    @Override
    public void printMessage() {
        System.out.print("\u001B[96m" + "* Wörterbuch * " + "\u001B[0m" + "Das Passwort ist im " + "\u001B[96m" + "Wörterbuch" + "\u001B[0m" + ", ");
    }

}

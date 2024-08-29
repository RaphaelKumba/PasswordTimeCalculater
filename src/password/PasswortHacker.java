package password;

import formatter.FormatterNumber;
import formatter.FormatterTime;
import methoden.SuchMethoden;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class PasswortHacker {

    private final ArrayList<SuchMethoden> suchMethoden;

    public PasswortHacker(ArrayList<SuchMethoden> methoden) {
        this.suchMethoden = methoden;
    }

    // Main Loop
    public void start() {
        while (true) {
            System.out.println("\u001B[31m" + "++ PASSWORT HACKER ++ " + "\u001B[0m" + "Tippe ein Passwort ein:");
            passwortZeitRechnen(passwortEingeben());
        }
    }

    // Scanner um Passwort zu testen
    public String passwortEingeben() {
        Scanner scanner = new Scanner(System.in);
        return  scanner.nextLine();
    }

    // Rechnet die Zeit mithilfe der mitgelieferten SuchMethoden.
    public void passwortZeitRechnen(String password) {
        double count = 0;
        for (SuchMethoden methode: suchMethoden) {
            count += methode.suche(password);
            if (methode.gefunden()) {
                methode.printMessage();
                break;
            }
        }

        String result = FormatterNumber.formatResult(BigDecimal.valueOf(count).toPlainString());
        System.out.println("es werden " + "\u001B[31m" + result + "\u001B[0m" + " Versuche benötigt.");
        System.out.println("Der Computer hackt dieses Passwort in " + "\u001B[92m" + FormatterTime.getTimeFormatted(count) + "\u001B[0m" + ".\n");

    }

}

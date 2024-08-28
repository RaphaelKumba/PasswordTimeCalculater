package password;

import java.math.BigDecimal;
import java.util.Scanner;


/**
 * Rechnet, wie lange es braucht um ein eingegebenes Passwort zu hacken.
 * Das Resultat ist nur eine Approximation.
 */
public class PasswordHacker {

    public static void main(String[] args) {
        PasswordHacker passwordHacker = new PasswordHacker();
        passwordHacker.start();
    }

    // Main Loop
    public void start() {
        while (true) {
            System.out.println("*PASSWORT HACKER* Tippe ein Passwort ein:");
            rechnePasswortZeit(readPassword());
        }
    }

    // Passwort schreiben
    public String readPassword() {
        Scanner scanner = new Scanner(System.in);
        return  scanner.nextLine();
    }

    /**
     * Rechnet die nötige Zeit, um ein Passwort zu Häcken.
     * Das Ergebnis ist nur eine Annäherung.
     * Es wird davon ausgegangen, dass wenn ein Versuch ein Resultat > 0 zurückgibt, das Passwort gefunden wurde.
     */
    public void rechnePasswortZeit(String password) {

        // Suche im Wörterbuch
        if (Hacker.findInWoerterbuch(password) > 0) {
            printLexiconMessage();
            printer(Hacker.findInWoerterbuch(password));

        // Suche nach Zahlen
        } else if (Hacker.findInteger(password) > 0d){
            printIntegerMessage();
            printer(Hacker.findInteger(password));

        // Suche Kleinbuchstaben
        } else if (Hacker.findSmallCharsOnly(password) > 0d) {
            printSmallCharsMessage();
            printer(Hacker.findSmallCharsOnly(password));

        // Suche Klein- und Grossbuchstaben
        } else if (Hacker.findSmallLargeCharsOnly(password) > 0d) {
            printSmallLargeCharsMessage();
            printer(Hacker.findSmallLargeCharsOnly(password));

        // Suche Buchstaben und Zahlen
        } else if (Hacker.findCharsAndNumbers(password) > 0d) {
            printCharsNumbersMessage();
            printer(Hacker.findCharsAndNumbers(password));

        // Suche alles
        } else {
            printBruteForceMessage();
            printer(Hacker.findByBruteForce(password));
        }
    }

    // Private Printer Methoden
    private void printer(double value) {
        String result = FormatterNumber.formatResult(BigDecimal.valueOf(value).toPlainString());

        System.out.println("es werden " + "\u001B[31m" + result + "\u001B[0m" + " Versuche benötigt.");
        System.out.println("Der Computer braucht " + "\u001B[92m" + FormatterTime.getTimeFormatted(value) + "\u001B[0m" + ".\n");
    }

    private void printLexiconMessage() {
        System.out.print("Das Password ist im " + "\u001B[96m" + "Lexicon" + "\u001B[0m" + ", ");
    }

    private void printIntegerMessage() {
        System.out.print("Das Password ist eine " + "\u001B[96m" + "Zahl" + "\u001B[0m" + ", ");
    }

    private void printSmallCharsMessage() {
        System.out.print("Das Password ist " + "\u001B[96m" + "nur Klein geschrieben" + "\u001B[0m" + ", ");
    }

    private void printSmallLargeCharsMessage() {
        System.out.print("Das Password ist " + "\u001B[96m" + "nur Klein und Gross geschrieben" + "\u001B[0m" + ", ");
    }

    private void printCharsNumbersMessage() {
        System.out.print("Das Password enthält nur " + "\u001B[96m" + "Buchstaben" + "\u001B[0m" + " und " + "\u001B[96m" + "Zahlen" + "\u001B[0m" + ", ");
    }

    private void printBruteForceMessage() {
        System.out.print("Das Password ist " + "\u001B[96m" + "Nicht" + "\u001B[0m" + " bekannt, ");
    }
}

package methoden;

public class Zahlen implements SuchMethoden {

    private boolean found = false;

    @Override
    public double suche(String input) {
        found = false;
        double number;
        try {
            number = Double.parseDouble(input);
            found = true;
            return number;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public boolean gefunden() {
        return found;
    }

    @Override
    public void printMessage() {
        System.out.print("\u001B[96m" + "* Zahlen * " + "Das Passwort ist eine " + "\u001B[96m" + "Zahl" + "\u001B[0m" + ", ");
    }
}

package methoden;

public class BruteForce implements SuchMethoden {

    public BruteForce() {}

    @Override
    public double suche(String input) {
        double tries = 0;
        for(int i = 0; i < input.length(); i++) {
            char j = 0;
            int count = 0;
            while (j != input.charAt(i) && j < 256) {
                j++;
                count++;
            }
            tries += (long) (count * Math.pow(256, input.length() - i - 1));
        }
        return tries;
    }

    @Override
    public boolean gefunden() {
        return true;
    }

    @Override
    public void printMessage() {
        System.out.print("\u001B[96m" + "* Brute Force * " + "\u001B[0m" + "Das Passwort ist " + "\u001B[96m" + "Nicht" + "\u001B[0m" + " bekannt, ");
    }
}

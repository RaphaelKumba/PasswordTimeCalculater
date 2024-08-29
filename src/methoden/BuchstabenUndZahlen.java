package methoden;

public class BuchstabenUndZahlen implements SuchMethoden {

    private boolean found = false;
    private final int char0 = 48;
    private final int char9 = 57;
    private final int A = 65;
    private final int Z = 90;
    private final int a = 97;
    private final int z = 122;

    public BuchstabenUndZahlen() {}

    @Override
    public double suche(String pw){
        found = false;
        double tries = 0;
        for(int i = 0; i < pw.length(); i++) {
            char j = char0;
            int count = 0;
            while (j != pw.charAt(i) && j <= z) {
                j++;
                count++;
                if (j == char9) j = A;
                if (j == Z) j = a;
            }
            if (j > z) {
                return 0;
            }
            tries += (long) (count * Math.pow((62), pw.length() - i - 1));
        }
        found = true;
        return tries;
    }

    @Override
    public boolean gefunden() {
        return found;
    }

    @Override
    public void printMessage() {
        System.out.print("\u001B[96m" + "* Buchstaben und Zahlen * " + "\u001B[0m" + "Das Passwort enthält nur " + "\u001B[96m" + "Buchstaben" + "\u001B[0m" + " und " + "\u001B[96m" + "Zahlen" + "\u001B[0m" + ", ");
    }
}

package methoden;

public class Buchstaben implements SuchMethoden {

    private boolean found = false;
    private final int A = 65;
    private final int Z = 90;
    private final int a = 97;
    private final int z = 122;

    public Buchstaben() {}

    @Override
    public double suche(String pw){
        found = false;
        double tries = 0;
        for(int i = 0; i < pw.length(); i++) {
            char j = A;
            int count = 0;
            while (j != pw.charAt(i) && j <= z) {
                j++;
                count++;
                if (j == Z) j = a;
            }
            if (j > z) {
                return 0;
            }
            tries += (long) (count * Math.pow((52), pw.length() - i - 1));
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
        System.out.print("\u001B[96m" + "* Buchstaben * " + "\u001B[0m" + "Das Passwort ist " + "\u001B[96m" + "nur Klein und Gross geschrieben" + "\u001B[0m" + ", ");
    }
}

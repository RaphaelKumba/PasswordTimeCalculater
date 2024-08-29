package methoden;

public class GrossBuchstaben implements SuchMethoden {

    private boolean found = false;
    private final int A = 65;
    private final int Z = 90;

    public GrossBuchstaben() {}

    @Override
    public double suche(String pw){
        found = false;
        double tries = 0;
        for(int i = 0; i < pw.length(); i++) {
            char j = A;
            int count = 0;
            while (j != pw.charAt(i) && j <= Z) {
                j++;
                count++;
            }
            if (j > Z) {
                return 0;
            }
            tries += (long) (count * Math.pow((26), pw.length() - i - 1));
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
        System.out.print("\u001B[96m" + "* Grossbuchstaben * " + "\u001B[0m" + "Das Passwort ist " + "\u001B[96m" + "nur Gross geschrieben" + "\u001B[0m" + ", ");
    }

}

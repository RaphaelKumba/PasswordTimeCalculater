package password;

import methoden.BruteForce;
import methoden.Buchstaben;
import methoden.BuchstabenUndZahlen;
import methoden.GrossBuchstaben;
import methoden.KleinBuchstaben;
import methoden.SuchMethoden;
import methoden.Woerterbuch;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        ArrayList<SuchMethoden> suchMethoden = new ArrayList<>();
        suchMethoden.add(new Woerterbuch());
        suchMethoden.add(new KleinBuchstaben());
        suchMethoden.add(new GrossBuchstaben());
        suchMethoden.add(new Buchstaben());
        suchMethoden.add(new BuchstabenUndZahlen());
        suchMethoden.add(new BruteForce());

        new PasswortHacker(suchMethoden).start();
    }

}

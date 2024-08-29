package methoden.woerterbuch;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Ladet die Wörterbuchdatei und erstellt eine Liste mit den Einträgen.
 */
public class WoerterbuchLoader {

    private final List commonPasswords = new List();

    public List getPasswords() {
        read();
        return commonPasswords;
    }

    private void read() {
        try {
            File file = new File("src/methoden/woerterbuch/woerterbuch.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null) {
                commonPasswords.add(line);
            }
            fr.close();
        }
        catch(IOException e) {
            System.out.println("Error reading file...");
        }
    }
}

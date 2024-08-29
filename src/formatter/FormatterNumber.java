package formatter;

/**
 * Formatiert den Zahlenstring, um die Leserlichkeit zu verbessern.
 * Nimmt einen String, welcher eine Zahl repräsentiert entgegen.
 * Gibt den vereinfachten String zurück.
 * Beispiel: 9573938423 wird zu 9 573 938 423
 */
public class FormatterNumber {
    public static String formatResult(String s) {
        for (int i = 0; i < s.length(); i++) if (s.charAt(i) == '.') s = s.substring(0, i);

        StringBuilder string = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if ((s.length() - i) % 3 == 0 && i > 0) string.append(" ");
            string.append(s.charAt(i));
        }
        return string.toString();
    }
}

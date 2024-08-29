package formatter;


/**
 * Wandelt Sekunden in Zeit um.
 * Nimmt Sekunden entgegen.
 * Gibt einen Zeit String zurück.
 */
public class FormatterTime {
    static int SECOND = 1;
    static int MINUTE = 60 * SECOND;
    static int HOUR = 60 * MINUTE;
    static int DAY = 24 * HOUR;
    static int MONTH = 30 * DAY;
    static int YEAR = 365 * DAY;

    public static String getTimeFormatted(double time) {
        double value = time / 10_000_000_000d;

        int yr = (int) (value / YEAR);
        int mn = (int) value / MONTH - ((int) value / YEAR) * 12;
        int d = (int) value / DAY - ((int) value / MONTH ) * 30;

        int h = (int) value / HOUR - ((int) value / DAY) * 24;
        int m = (int) value / MINUTE - ((int) value / HOUR) * 60;
        int s = (int) value / SECOND - ((int) value / MINUTE) * 60;

        String year = "";
        if (yr != 0) year = yr + " Jahre, ";

        String month = "";
        if (mn != 0) month = mn + " Monate, ";

        String days = "";
        if (d != 0) days = d + " Tage, ";

        String hours = "";
        if (h != 0) hours = h + " Stunden, ";

        String min = "";
        if (m != 0) min = m + " Minuten, ";

        String sec = s + " Sekunden";

        return year + month + days + hours + min + sec;
    }
}

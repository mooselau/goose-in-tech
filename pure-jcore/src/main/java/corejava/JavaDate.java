package corejava;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class JavaDate {
    public static void main(String[] args) {
        JavaDate tester = new JavaDate();
        tester.entrypoint();
    }

    private void entrypoint() {
        /* This will display the date and time in the format of
         * 12/09/2017 24:12:35. See the complete program below
         */
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm");
        Date dateObj = new Date();
        p("simple date format: " + df.format(dateObj));

        //"hh" in pattern is for 12 hour time format and "aa" is for AM/PM
        SimpleDateFormat dateTimeInGMT = new SimpleDateFormat("MMM. dd, yyyy - HH:mm");
        //Setting the time zone
        System.out.println(TimeZone.getDefault());
        dateTimeInGMT.setTimeZone(TimeZone.getDefault());
        // new Date(1552759200000L)
        p("with timezone: " + dateTimeInGMT.format(new Date()));
    }

    private void p(String msg) {
        System.out.println(msg);
    }
}

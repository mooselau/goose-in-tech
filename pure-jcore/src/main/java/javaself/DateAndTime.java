package javaself;

import static java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TimeZone;


public class DateAndTime {
    public static void main(String[] args) {
        DateAndTime demo = new DateAndTime();
        demo.entrypoint();
    }

    private void entrypoint() {
        testISO();
    }

    private void testISO() {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
        // Quoted "Z" to indicate UTC, no timezone offset
        df.setTimeZone(tz);

        LocalDateTime localDateTime = LocalDateTime.parse("2020-08-15T13:37:20.757+08:00", ISO_OFFSET_DATE_TIME);
        System.out.println(localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        System.out.println(System.currentTimeMillis());

        /* DateTime and TimeMillis with Timezone */
        long targetTime = 1597469840757L;
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.ofEpochMilli(targetTime), ZoneId.of("Asia/Shanghai"));
        System.out.println(zonedDateTime.format(ISO_OFFSET_DATE_TIME));

//        localDateTime.format(df);
//        LocalDate date = LocalDate.now();
//        String nowAsISO = df.format(date);
//        System.out.println(nowAsISO);
    }

    private void testZero() {
        long subject = -11L;
        long target = 10L;
        int gap = (int) (subject / target);
        //        double gap = (double) (subject / target);
        //        long gap = Math.round((double)(subject / target));
        gap = subject > 0 ? ++gap : --gap;
        System.out.println("Gap: " + gap);
        System.out.println("Sign: " + (gap > 0));
    }

    private void previousTest() {
        long expiryMillis = 1000L * 3600 * 24 * 7;
        long updatedTime = 1589012677000L;
        long expireDateMillis = expiryMillis + updatedTime;
        long currentTime = System.currentTimeMillis() + 1000L * 3600 * 24 * 8;
        long gap = expireDateMillis - currentTime;
        long oneDayMillis = 1000L * 3600 * 24;
        int days = (int) (gap / oneDayMillis);
        System.out.println(days + " days left");
    }
}

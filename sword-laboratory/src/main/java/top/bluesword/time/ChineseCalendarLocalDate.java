package top.bluesword.time;

import java.time.Instant;

/**
 * @author 李林峰
 */
public class ChineseCalendarLocalDate {

    private static final int SECONDS_PER_MINUTE = 60;
    private static final int MINUTES_PER_HOUR = 60;
    private static final int HOURS_PER_DAY = 24;
    private static final int SECONDS_PER_HOUR = SECONDS_PER_MINUTE * MINUTES_PER_HOUR;
    private static final int SECONDS_PER_DAY = SECONDS_PER_HOUR * HOURS_PER_DAY;

    private final int year;
    private final short month;
    private final short day;

    private ChineseCalendarLocalDate(int year, int month, int dayOfMonth) {
        this.year = year;
        this.month = (short) month;
        this.day = (short) dayOfMonth;
    }

    public static ChineseCalendarLocalDate now() {
        return ofInstant(Instant.now());
    }

    private static ChineseCalendarLocalDate ofInstant(Instant instant) {
        long localSecond = instant.getEpochSecond() + 28800;
        long localEpochDay = Math.floorDiv(localSecond, SECONDS_PER_DAY);
        return ofEpochDay(localEpochDay);
    }

    private static ChineseCalendarLocalDate ofEpochDay(long localEpochDay) {
        //todo
        int year = 0;
        //todo
        int month = 0;
        //todo
        int dayOfMonth = 0;
        return new ChineseCalendarLocalDate(year, month, dayOfMonth);
    }

}

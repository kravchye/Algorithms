package amazon;

/**
 * What is the angle between the hour and minute hand in an analog clock
 */
public class ClockAngle {

    static int getAngle(int hour, int minute) {
        int hourAngle = 360 * hour / 12;
        int minuteAngle = 360 * minute / 60;
        return Math.abs(hourAngle - minuteAngle);
    }

    public static void main(String[] args) {
        System.out.println(getAngle(3, 27));
        System.out.println(getAngle(3, 30));
        System.out.println(getAngle(9, 60));
    }
}

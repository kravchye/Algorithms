package algorithm.lafore.chapter6;

public class TowersOfHanoi {
    public static void main(String[] args) {
        doTowers(3, 'A', 'B', 'C');
    }

    private static void doTowers(int number, char from, char intermediate, char destination) {
        if (number == 1) {
            System.out.println("Disk " + 1 + " from " + from + " to "+ destination);
        } else {
            doTowers(number - 1, from, destination, intermediate);
            System.out.println("Disk " + number + " from " + from + " to " + destination);
            doTowers(number - 1, intermediate, from, destination);
        }
    }
}

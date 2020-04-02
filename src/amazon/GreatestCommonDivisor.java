package amazon;

public class GreatestCommonDivisor {

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a%b);
    }

    static int gcd(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(gcd(new int[]{2,4,6,8}));
    }
}

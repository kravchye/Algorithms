package algorithm.lafore.chapter6;

public class Recursion {
    static int nonRecursiveTriangular(int n) {
        int sum = 0;
        while (n > 0) {
            sum +=n;
            n--;
        }
        return sum;
    }

    static int triangular(int n) {
        if (n == 1) return n;
        return n + triangular(n-1);
    }

    public static void main(String[] args) {
        System.out.println(nonRecursiveTriangular(4));
        System.out.println(triangular(4));
    }
}

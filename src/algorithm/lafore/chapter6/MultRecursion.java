package algorithm.lafore.chapter6;

/**
 * Programming project 6.1
 */
public class MultRecursion {

    static int mult(int num, int times) {
        if (times == 0) return num;
        return num + mult(num, times-1);
    }

    public static void main(String[] args) {
        System.out.println(mult(4,3));
    }
}

package algorithm.lafore.chapter6;

public class RaisingToAPower {
    public static void main(String[] args) {
        System.out.println(raise(2,8));
    }

    private static int  raise(int x, int y) {
        if (y == 1 ) return x;
        return raise(x * x, y / 2);
    }
}

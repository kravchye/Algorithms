package algorithm.lafore.chapter6;

public class KnapsackWeightAndValueV2 {

    private static int knapsackDP(int[] weights, int[] values, int totalNum, int totalWeight) {
        if (totalNum <= 0 || totalWeight <= 0) {
            return 0;
        }

        int[][] m = new int[totalNum + 1][totalWeight + 1];

        for (int i = 1; i <= totalNum; i++) {
            for (int j = 1; j <= totalWeight; j++) {
                if (weights[i - 1] > j) { // if 10 > 1
                    m[i][j] = m[i - 1][j]; // m[1][1] = m[0][1]
                } else {
                    m[i][j] = Math.max(
                            m[i - 1][j],
                            m[i - 1][j - weights[i - 1]] + values[i - 1]);
                }
            }
        }
        return m[totalNum][totalWeight];
    }

    public static void main(String[] args) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int  W = 50;
        System.out.println(knapsackDP(wt, val, val.length, W));
    }
}

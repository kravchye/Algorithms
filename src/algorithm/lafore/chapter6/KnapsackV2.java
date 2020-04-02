package algorithm.lafore.chapter6;

public class KnapsackV2 {

    private static int[] arr = new int[] {7,11,8,9,6, 5};
    private static int totalWeight = 20;

    public static int knapsack(int targetWeight, int index) {
        if (index == 0 || totalWeight == 0) return targetWeight;
        if (targetWeight == arr[index]) {
            System.out.println(arr[index]);
            return arr[index];
        }
        if (arr[index] > targetWeight) {
            return knapsack(targetWeight, index - 1);
        } else {
            return arr[index] + knapsack(targetWeight - arr[index], index - 1);
        }
    }

    public static void main(String[] args) {

        System.out.println(knapsack(totalWeight, arr.length - 1));
    }
}

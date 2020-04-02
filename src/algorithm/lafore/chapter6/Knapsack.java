package algorithm.lafore.chapter6;

public class Knapsack {

    private static int total = 20;
    private static int[] weights = new int[]{11, 8, 7, 6, 5};

    public static void main(String[] args) {
        knapsack(0, total);
    }

    public static boolean knapsack(int startPos, int capacity) {
        for (int i = 0; i < weights.length; i++) {
            if (capacity == weights[i]) {
                System.out.println(weights[i] + " ");
                return true;
            }
            if (weights[i] < capacity) {
                for (int j = i; j < weights.length; j++) {
                    boolean valid = knapsack(j, capacity - weights[i]);
                    if (valid) {
                        System.out.println(weights[i] + " ");
                        return valid;
                    }
                }
            }
        }

        return false;
    }


//    public static boolean knapsack(int startPoint, int capacity){
//        for(int i=startPoint; i<weights.length; i++){
//
//            if(weights[i]==capacity){
//                System.out.print(weights[i] + " ");
//                return  true;
//            }
//            else{
//
//                if(weights[i]<capacity){
//
//                    for(int j=i+1; j<weights.length; j++){
//
//                        boolean value = knapsack(j,capacity-weights[i]);
//
//                        if(value){
//                            System.out.print(weights[i]+ " ");
//                            return true;
//                        }
//                    }
//
//                }
//            }
//        }
//
//        return false;
//    }
}
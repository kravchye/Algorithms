package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OptimalFlightDistance {

    static List<List<Integer>> flightRoutes(List<List<Integer>> forwardRoutes, List<List<Integer>> backwardRoutes, int maxLength) {
        List<List<Integer>> result = new ArrayList<>();
        // sort the lists
        List<List<Integer>> sortedForward = forwardRoutes.stream().sorted(Comparator.comparingInt(value -> value.get(1))).collect(Collectors.toList());
        List<List<Integer>> sortedBackward = backwardRoutes.stream().sorted((v1, v2) -> v1.get(1).compareTo(v2.get(1))).collect(Collectors.toList());
        // loop over forward Routes
        while (true) {
            for (List<Integer> sForward : sortedForward) {
                if (result.size() > 0) break;
                // loop over backward Routes
                for (List<Integer> sBackward : sortedBackward) {
                    if (sForward.get(1) + sBackward.get(1) == maxLength) {
                        result.add(Arrays.asList(sForward.get(0), sBackward.get(0), maxLength));
                        break;
                    }
                }
            }
            if (result.size() > 0) break;
        }
        //

        return result;
    }


    public static void main(String[] args) {
        // sample input
        System.out.println(flightRoutes(
                Arrays.asList(Arrays.asList(1, 3000), Arrays.asList(2, 5000), Arrays.asList(3, 7000), Arrays.asList(4, 10000)),
                Arrays.asList(Arrays.asList(1, 2000), Arrays.asList(2, 9000), Arrays.asList(3, 5000)),
                10000));
    }

}
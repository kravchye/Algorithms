package interview.hashmap;

import java.util.*;
import java.util.stream.Collectors;

public class WarmingUp {
    private static Map<Integer, String> buildHashMap(List<List<Integer>> idToLengthLists) {
        if (idToLengthLists == null) {
            return Collections.emptyMap();
        }
        Map<Integer, String> map = new HashMap<>(idToLengthLists.size());
        for (List<Integer> idToDistance: idToLengthLists) {
            map.put(idToDistance.get(0), idToDistance.get(1).toString());
        }
        return map;
    }

    private static Map<Integer, String> buildHashMapViaStreamsTest(List<Integer> idToLengthLists) {
        return idToLengthLists.stream()
                .collect(Collectors.toMap(Integer::intValue, i -> i.toString()));
    }

    private static Map<Integer, String> buildHashMapViaStreams(List<List<Integer>> idToLengthLists) {
        return idToLengthLists.stream()
                .flatMap(x -> x.stream())
                .collect(Collectors.toMap(Integer::intValue, i -> i.toString()));
    }
    public static void main(String[] args) {
        List<Integer> flightIdToDistance = Arrays.asList(1, 650);
        List<List<Integer>> idToLengthLists = new ArrayList<>();
        idToLengthLists.add(flightIdToDistance);
        System.out.println(buildHashMap(idToLengthLists));
    }
}

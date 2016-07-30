import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 1));
        }
        return map.entrySet().stream().sorted((e1, e2) -> e2.getValue() - e1.getValue()).map(Map.Entry::getKey).limit(k).collect(Collectors.toList());
    }
}
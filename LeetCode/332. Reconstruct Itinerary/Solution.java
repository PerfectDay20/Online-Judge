import java.util.*;

public class Solution {
    private int n;
    private Map<String, PriorityQueue<String>> map;
    private List<String>  list;

    public List<String> findItinerary(String[][] tickets) {
        n = tickets.length;
        list = new LinkedList<>();
        if (n == 0 || tickets[0].length == 0) {
            return list;
        }
        map = new HashMap<>();
        for (String[] nums : tickets) {
            map.putIfAbsent(nums[0], new PriorityQueue<>());
            map.get(nums[0]).add(nums[1]);
        }
        dfs("JFK");
        return list;
    }

    private void dfs(String cur) {
        PriorityQueue<String> neighbors = map.get(cur);
        while (neighbors != null && neighbors.size() > 0) {
            String s = neighbors.remove();
            dfs(s);
        }
        list.add(0, cur);
    }


}
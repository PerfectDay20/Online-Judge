import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int integerReplacement(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        return solve(map, n);
    }

    private int solve(Map<Integer, Integer> map, int t) {
        if (map.containsKey(t)) {
            return map.get(t);
        }
        if ((t & 1) == 1) {
            map.put(t, Math.min(solve(map, t - 1), solve(map, 1 + (t - 1) / 2) + 1) + 1);
        } else {
            map.put(t, solve(map, t / 2) + 1);
        }
        return map.get(t);
    }
}
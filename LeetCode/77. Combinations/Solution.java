import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> now = new ArrayList<>();
        helper(list, now, n, k, 0, 0);
        return list;
    }

    private void helper(List<List<Integer>> list, List<Integer> now, int n, int k, int count ,int index) {
        if (count == k) {
            list.add(new ArrayList<Integer>(now));
        } else {
            for (int j = index + 1; j <= n; j++) {
                now.add(j);
                helper(list, now, n, k, count + 1, j);
                now.remove(now.size()-1);
            }
        }
    }
}
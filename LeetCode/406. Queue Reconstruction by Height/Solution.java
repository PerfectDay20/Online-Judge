import java.util.*;

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        int[][] ans = new int[n][2];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int n = o1[0] - o2[0];
                if (n != 0) {
                    return n;
                }
                return o2[1] - o1[1];
            }
        });
        for (int i = 0; i < n; i++) {
            int t = people[i][1];
            int index = list.remove(t);
            ans[index] = people[i];

        }
        return ans;
    }
}
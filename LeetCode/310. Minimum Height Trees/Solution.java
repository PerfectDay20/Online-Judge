import java.util.*;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer>[] lists = new List[n];
        int[] degree = new int[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] nums : edges) {
            degree[nums[0]]++;
            degree[nums[1]]++;
            lists[nums[0]].add(nums[1]);
            lists[nums[1]].add(nums[0]);
        }
        List<Integer> ans = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] <= 1) {
                queue.add(i);
            }
        }
        while (n > 2) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int next = queue.remove();
                n--;
                for (int adj : lists[next]) {
                    if (--degree[adj] == 1) {
                        queue.add(adj);
                    }
                }
            }
        }
        ans.addAll(queue);
        return ans;
    }
}
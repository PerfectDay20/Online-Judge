import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {//bfs
        int[] indegree = new int[numCourses];
        List<Integer>[] list = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            list[i] = new ArrayList<>();
        }
        for (int[] nums : prerequisites) {
            indegree[nums[0]]++;
            list[nums[1]].add(nums[0]);
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int[] ans = new int[numCourses];
        int next = 0;
        while (!queue.isEmpty()) {
            int t = queue.remove();
            ans[next++] = t;
            for (int index : list[t]) {
                if (--indegree[index] == 0) {
                    queue.add(index);
                }
            }
        }
        return next == numCourses ? ans : new int[0];
    }
    
}
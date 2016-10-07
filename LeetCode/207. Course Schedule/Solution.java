import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public boolean canFinish_dfs(int numCourses, int[][] prerequisites) {//dfs
        boolean[] visited = new boolean[numCourses];
        List<Integer>[] list = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            list[i] = new ArrayList<>();
        }
        for (int[] nums : prerequisites) {
            list[nums[1]].add(nums[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(visited, i, list)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(boolean[] visited, int i, List<Integer>[] list) {
        if (visited[i]) {
            return false;
        }
        visited[i] = true;
        for (int next : list[i]) {
            if (!dfs(visited, next, list)) {
                return false;
            }
        }
        visited[i] = false;
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {//bfs
        int count = 0;
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
        while (!queue.isEmpty()) {
            int t = queue.remove();
            count++;
            for (int index : list[t]) {
                if (--indegree[index] == 0) {
                    queue.add(index);
                }
            }
        }
        return count == numCourses;
    }
}
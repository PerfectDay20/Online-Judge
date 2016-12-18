import java.util.*;

public class Solution {
    public int numberOfBoomerangs(int[][] points) {//O(n^3) TLE
        int n = points.length, count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                int dis1 = getDistance(points[i], points[j]);
                for (int k = 0; k < n; k++) {
                    if (i == k || j == k) {
                        continue;
                    }
                    if (dis1 == getDistance(points[i], points[k])) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public int numberOfBoomerangs2(int[][] points) {//O(n^2) MLE
        int n = points.length, count = 0, distance;
        Map<Integer, Map<Integer,Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                distance = getDistance(points[i], points[j]);
                if (!map.containsKey(distance)) {
                    map.put(distance, new HashMap<>());
                }
                Map<Integer,Integer> temp = map.get(distance);
                temp.put(i, temp.getOrDefault(i, 0) + 1);
                temp.put(j, temp.getOrDefault(j, 0) + 1);
            }
        }

        for (Map<Integer,Integer> temp: map.values()) {
            for (int i : temp.values()) {
                count += i * (i - 1);
            }
        }

        return count;
    }

    public int numberOfBoomerangs3(int[][] points) {//O(n^2)
        int n = points.length, count = 0, distance;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                distance = getDistance(points[i], points[j]);
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }
            for (int k : map.values()) {
                count += k * (k - 1);
            }
            map.clear();
        }
        return count;
    }



    private int getDistance(int[] p1, int[] p2) {
        int dx = p1[0] - p2[0], dy = p1[1] - p2[1];
        return dx * dx + dy * dy;
    }

}
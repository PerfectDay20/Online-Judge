import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int[][] m = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        System.out.println(new Solution().kthSmallest(m, 8));
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
//        PriorityQueue<int[]> pq = new PriorityQueue<>(n, Comparator.comparing(nums -> nums[2]));  //124ms
        PriorityQueue<int[]> pq = new PriorityQueue<>(n, new Comparator<int[]>() {  //37ms
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        for (int i = 0; i < n; i++) {
            pq.add(new int[]{i, 0, matrix[i][0]});
        }
        int[] temp = null;
        while (k-- > 0) {
            temp = pq.remove();
            if (temp[1] < n - 1) {
                pq.add(new int[]{temp[0], temp[1] + 1, matrix[temp[0]][temp[1] + 1]});
            }
        }
        return temp[2];
    }
}
import java.util.*;

public class Main {//Floyd Warshall's algorithm
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] adjMat = new int[n][n];
        for (int[] nums : adjMat) {
            Arrays.fill(nums, 1000000000);
        }
        for (int i = 0; i < n; i++) {
            adjMat[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1, b = sc.nextInt() - 1, c = sc.nextInt();
            adjMat[a][b] = adjMat[b][a] = Math.min(c, adjMat[a][b]);
        }
        for(int k = 0; k < n; k ++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    adjMat[i][j] = Math.min(adjMat[i][j], adjMat[i][k] + adjMat[k][j]);
                }
            }
        }
        for (int[] nums : adjMat) {
            for (int i = 0; i < n-1; i++) {
                System.out.print(nums[i] + " ");
            }
            System.out.println(nums[n - 1]);
        }
    }
}

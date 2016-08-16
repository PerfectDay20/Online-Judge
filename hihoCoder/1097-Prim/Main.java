import java.util.*;

public class Main {//Prim's Algorithm
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] adjMat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjMat[i][j] = sc.nextInt();
            }
        }

        boolean[] token = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(n, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });
        for (int i = 1; i < n; i++) {
            pq.add(new int[]{adjMat[0][i], i});
        }
        token[0] = true;

        int sum = 0;
        while (!pq.isEmpty()) {
            int[] pop = pq.remove();
            if (!token[pop[1]]) {
                token[pop[1]] = true;
                sum += pop[0];
                for (int i = 0; i < n; i++) {
                        pq.add(new int[]{adjMat[pop[1]][i], i});
                }
            }
        }
        System.out.println(sum);

    }
}

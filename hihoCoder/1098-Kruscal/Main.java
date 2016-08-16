import java.util.*;

public class Main {//Kruskal's Algorithm
    private static int[] p;//use Union-Find Disjoint Set
    private static int[] rank;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        p = new int[n + 1];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
        rank = new int[n + 1];

        PriorityQueue<int[]> pq = new PriorityQueue<>(n, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] != o2[2] ? o1[2] - o2[2] : o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });
        for (int i = 0; i < m; i++) {
            pq.add(new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt()});
        }
        int sum = 0;
        while (!pq.isEmpty()) {
            int[] pop = pq.remove();
            if (!isSameSet(pop[0], pop[1])) {
                sum += pop[2];
                union(pop[0], pop[1]);
            }
        }
        System.out.println(sum);

    }

    private static int getSet(int i) {
        if (p[i] != i) {
            p[i] = getSet(p[i]);
        }
        return p[i];
    }

    private static boolean isSameSet(int i, int j) {
        return getSet(i) == getSet(j);
    }

    private static void union(int i, int j) {
        i = getSet(i);
        j = getSet(j);
        if (i == j) {
            return;
        }
        if (rank[i] > rank[j]) {
            p[j] = i;
        } else if (rank[i] < rank[j]) {
            p[i] = j;
        } else {
            p[i] = j;
            rank[j]++;
        }
    }
}

import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt(), m = sc.nextInt();
            List<Integer>[] adjList = new ArrayList[n + 1];//use adjacent list
            for (int j = 0; j < n + 1; j++) {
                adjList[j] = new ArrayList<>();
            }
            int[] deg = new int[n + 1];//in-degree
            for (int j = 0; j < m; j++) {//read the data to adjacent list and degree[]
                int a = sc.nextInt(), b = sc.nextInt();
                adjList[a].add(b);
                deg[b]++;
            }
            Deque<Integer> queue = new ArrayDeque<>();
            for (int j = 1; j <= n; j++) {
                if (deg[j] == 0) {
                    queue.add(j);
                }
            }
            int count = 0;
            while (!queue.isEmpty()) {//delete the nodes that in-degree is 0
                int out = queue.removeFirst();
                count++;
                for (int item : adjList[out]) {
                    if (--deg[item] == 0) {
                        queue.add(item);
                    }
                }
            }

            System.out.println(count == n ? "Correct" : "Wrong");

        }
    }
}
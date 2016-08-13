import java.util.*;

public class Main1{
    public static void main(String[] args) {//delete the node whose in-degree is 0 to the end
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
        int[] virus = new int[k];
        int[] v = new int[n + 1];
        int[] deg = new int[n + 1];
        for (int i = 0; i < k; i++) {
            int t = sc.nextInt();
            virus[i] = t;
            v[t] = 1;
        }
        List<Integer>[] adjList = new ArrayList[n + 1];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            adjList[a].add(b);
            deg[b]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (deg[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int pop = queue.removeFirst();
            count = (count + v[pop]) % 142857;
            for (int next : adjList[pop]) {
                if (--deg[next] == 0) {
                    queue.add(next);
                }
                v[next] = (v[next] + v[pop]) % 142857;
            }
        }
        System.out.println(count);

    }
}
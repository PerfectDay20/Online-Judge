import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), s = sc.nextInt(), t = sc.nextInt();
        int[] p = new int[n + 1];
        Arrays.fill(p, Integer.MAX_VALUE);

        Map<Integer, Integer>[] adjList = new Map[n + 1];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new HashMap<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), l = sc.nextInt();
            if (!adjList[a].containsKey(b) || adjList[a].get(b) > l) {
                adjList[a].put(b, l);
                adjList[b].put(a, l);
            }
        }

        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(s);
        p[s] = 0;
        while (!queue.isEmpty()) {
            int head = queue.remove();
            for (Map.Entry<Integer, Integer> entry : adjList[head].entrySet()) {
                int key = entry.getKey(), value = entry.getValue();
                if (p[head] + value < p[key]) {
                    p[key] = p[head] + value;
                    queue.add(key);
                }
            }
        }
        System.out.println(p[t]);
    }
}

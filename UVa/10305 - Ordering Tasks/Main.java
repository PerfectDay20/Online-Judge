import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt(), m = sc.nextInt();
            if (n == 0) {
                break;
            }
            int[] inDegree = new int[n + 1];
            List<Integer>[] adjList = new List[n + 1];
            for (int i = 0; i < adjList.length; i++) {
                adjList[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt(), b = sc.nextInt();
                inDegree[b]++;
                adjList[a].add(b);
            }
            Deque<Integer> queue = new ArrayDeque<>();
            for(int i = 1; i< inDegree.length; i++) {
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }
            String ans = "";
            while (!queue.isEmpty()) {
                int head = queue.remove();
                ans += " " + head;
                for (int t : adjList[head]) {
                    if (--inDegree[t] == 0) {
                        queue.add(t);
                    }
                }
            }
            System.out.println(ans.trim());

        }
    }
}
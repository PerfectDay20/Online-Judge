import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt(), m = sc.nextInt();
            int[] color = new int[n + 1];
            List<Integer>[] adjList = new List[n + 1];
            for (int j = 0; j < adjList.length; j++) {
                adjList[j] = new ArrayList<>();
            }
            for (int j = 0; j < m; j++) {
                int a = sc.nextInt(), b = sc.nextInt();
                adjList[a].add(b);
                adjList[b].add(a);
            }

            boolean flag = true;
            for (int j = 1; j <= n && flag; j++) {
                if (color[j] == 0) {
                    Deque<Integer> queue = new ArrayDeque<>();
                    queue.add(j);
                    color[j] = 1;
                    while (!queue.isEmpty() && flag) {
                        int pop = queue.remove();
                        for (int next : adjList[pop]) {
                            if (color[next] == 0) {
                                color[next] = 3 - color[pop];
                                queue.add(next);
                            } else if (color[next] == color[pop]) {
                                flag = false;
                                break;
                            }
                        }
                    }
                }
            }

            System.out.println(flag ? "Correct" : "Wrong");


        }
    }

}
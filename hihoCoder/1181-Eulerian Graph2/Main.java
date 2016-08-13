import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        List<Integer>[] adjList = new ArrayList[n + 1];
        int[] degree = new int[n + 1];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            adjList[a].add(b);
            adjList[b].add(a);
            degree[a]++;
            degree[b]++;
        }

        int start = 1;//find the start node, actually this is the end node in the graph
        for(int i = 1; i <= n; i++) {
            if ((degree[i] & 1) == 1) {
                start = i;
                break;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            int top = stack.peek();
            if (adjList[top].size() > 0) {
                int next = adjList[top].remove(0);
                adjList[next].remove(Integer.valueOf(top));
                stack.push(next);
            } else {
                stack.pop();
                ans.add(top);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.size() - 1; i++) {
            sb.append(ans.get(i)).append(" ");
        }
        System.out.println(sb.append(ans.get(ans.size() - 1)).toString());
    }
}
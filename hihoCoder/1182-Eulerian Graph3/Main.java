import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 1) {
            System.out.println("01");
            return;
        }
        List<Integer>[] adjList = new ArrayList[(1<<(n-1))];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }
        int mask = (1 << n) - 1;
        for (int i = 0; i <= mask; i++) {
            int a = i >>> 1;
            int b = i & (mask >>> 1);
            adjList[a].add(b);
        }

        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        stack.push(0);
        while (!stack.isEmpty()) {
            int top = stack.peek();
            if (adjList[top].size() > 0) {
                stack.push(adjList[top].get(0));
                adjList[top].remove(0);
            } else {
                stack.pop();
                if (stack.size() > 0) {
                    ans.add(top | (stack.peek() << 1));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = ans.size() - 1; i >= 0; i--) {
            sb.append(ans.get(i) & 1);
        }
        System.out.println(sb.toString());
    }
}
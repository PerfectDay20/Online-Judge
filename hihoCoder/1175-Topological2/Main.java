import java.util.*;

public class Main{//using map to store the virus in every node;
    private static Map<Integer,Integer> map;
    private static List<Integer>[] adjList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
        int[] virus = new int[k];
        for (int i = 0; i < k; i++) {
            virus[i] = sc.nextInt();
        }
        adjList = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            adjList[sc.nextInt()].add(sc.nextInt());
        }
        map = new HashMap<>();

        int count = 0;
        for (int v : virus) {
            count += getSize(v);
            count %= 142857;
        }
        System.out.println(count);
    }

    private static int getSize(int i) {
        if (!map.containsKey(i)) {
            int sum = 1;
            for (int next : adjList[i]) {
                sum += getSize(next);
                sum %= 142857;
            }
            map.put(i, sum);
        }
        return map.get(i);
    }
}
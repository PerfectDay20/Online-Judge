import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main{
    private static int[] count, sum;
    private static List<Integer>[] adjList;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        sc.nextLine();
        for (int k = 0; k < t; k++) {
            adjList = new List[26];
            count = new int[26];
            sum = new int[26];
            List<Integer> source = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                adjList[i] = new ArrayList<>();
            }
            while (sc.hasNextLine()) {
                String s = sc.nextLine();
                if (s.length() == 0) {
                    break;
                }
                String[] ss = s.split(" ");
                count[s.charAt(0) - 'A'] = Integer.parseInt(ss[1]);
                if (ss.length == 3) {
                    for (int i = 0; i < ss[2].length(); i++) {
                        adjList[ss[2].charAt(i) - 'A'].add(s.charAt(0) - 'A');
                    }
                } else {
                    source.add(s.charAt(0) - 'A');
                }
            }
            for (int s : source) {
                sum[s] = count[s];
                dfs(s);
            }
            int ans = 0;
            for (int i = 0; i < 26; i++) {
                ans = Math.max(ans, sum[i]);
            }
            if (k != 0) {
                System.out.println();
            }
            System.out.println(ans);

        }

    }

    private static void dfs(int i) {
        for (int next : adjList[i]) {
            if (sum[next] < sum[i] + count[next]) {
                sum[next] = sum[i] + count[next];
                dfs(next);
            }
        }
    }
}
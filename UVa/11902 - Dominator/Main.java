import java.util.Arrays;
import java.util.Scanner;

class Main{
    private static int[][] mat;//the input adjacent matrix
    private static boolean[][] dom;//the dominate matrix
    private static int n;
    private static boolean[] temp;//every time dfs returns, indicates which node is reachable

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int k = 0; k < T; k++) {
            n = sc.nextInt();
            mat = new int[n][n];
            dom = new boolean[n][n];
            temp = new boolean[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }
            dfs(0, -1);//first get all the node that reachable from node 0
            System.arraycopy(temp, 0, dom[0], 0, n);
            for (int i = 1; i < n; i++) {//then delete every node, and test which node is reachable -> not reachable
                Arrays.fill(temp, false);
                dfs(0, i);
                for (int j = 0; j < n; j++) {
                    if (dom[0][j] && !temp[j]) {
                        dom[i][j] = true;
                    }
                }
            }
            //output follow the format
            System.out.printf("Case %d:%n", k + 1);
            StringBuilder sb = new StringBuilder();
            sb.append("+");
            for (int i = 0; i < 2 * n - 1; i++) {
                sb.append("-");
            }
            sb.append("+");
            String row = sb.toString();
            System.out.println(row);
            for (int i = 0; i < n; i++) {
                System.out.print("|");
                for (int j = 0; j < n; j++) {
                    System.out.print(dom[i][j] ? "Y|" : "N|");
                }
                System.out.println();
                System.out.println(row);
            }
        }
    }

    private static void dfs(int t, int forbid) {//forbid means delete this node in the graph
        temp[t] = true;
        for (int i = 0; i < n; i++) {
            if (mat[t][i] == 1 && !temp[i] && i != forbid) {
                dfs(i, forbid);
            }
        }
    }
}

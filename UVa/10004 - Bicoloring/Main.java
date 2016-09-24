import java.util.Scanner;

class Main {
    private static int[] c;
    private static boolean[][] mat;
    private static boolean flag;
    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            n = sc.nextInt();
            if (n == 0) {
                break;
            }
            int l = sc.nextInt();
            c = new int[n];
            mat = new boolean[n][n];
            flag = true;
            for (int i = 0; i < l; i++) {
                int a = sc.nextInt(), b = sc.nextInt();
                mat[a][b] = mat[b][a] = true;
            }
            dfs(0, 1);
            System.out.println(flag ? "BICOLORABLE." : "NOT BICOLORABLE.");
        }
    }

    private static void dfs(int i, int color) {
        if (!flag) {
            return;
        }

        c[i] = color;
        for (int j = 0; j < n; j++) {
            if (mat[i][j]) {
                if (c[j] == color) {
                    flag = false;
                    return;
                } else if (c[j] == 0) {
                    dfs(j, 3 - color);
                }
            }
        }

    }
}
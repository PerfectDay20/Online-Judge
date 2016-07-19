import java.util.Scanner;
//0-1 pack
class Main{
    static int[] p;
    static int[] w;
    static int n;
    static int[][] memo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            n = sc.nextInt();
            p = new int[n];
            w = new int[n];
            for (int j = 0; j < n; j++) {
                p[j] = sc.nextInt();
                w[j] = sc.nextInt();
            }
            int g = sc.nextInt();
            int sum = 0;
            for (int j = 0; j < g; j++) {
                int mw = sc.nextInt();
//                memo = new int[n + 1][mw + 1];
//                for (int k = 0; k < memo.length; k++) {
//                    Arrays.fill(memo[k], -1);
//                }
                sum += val2(n, mw);
            }
            System.out.println(sum);
        }
    }

    //down-top
    static int val2(int i, int remW) {
        int[][] c = new int[i + 1][remW + 1];
        for (int j = 0; j < c[0].length; j++) {
            c[0][j] = 0;
        }
        for (int j = 0; j < c.length; j++) {
            c[j][0] = 0;
        }
        for (int j = 1; j <= i; j++) {
            for (int k = 1; k <= remW; k++) {
                if (k >= w[j-1]) {
                    c[j][k] = Math.max(c[j - 1][k], c[j - 1][k - w[j-1]] + p[j-1]);
                } else {
                    c[j][k] = c[j - 1][k];
                }
            }
        }
        return c[i][remW];
    }

    //top-down
    static int val(int i, int remW){
        if (i == n) {
            return 0;
        }
        if (remW < w[i]) {
            return val(i + 1, remW);
        }
        if (memo[i][remW] != -1) {
            return memo[i][remW];
        } else {
            memo[i][remW] = Math.max(val(i + 1, remW), val(i + 1, remW - w[i]) + p[i]);
        }
        return memo[i][remW];
    }
}
import java.util.Arrays;
import java.util.Scanner;
//Coin Change Problem, use top-down DP or down-top
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        topDownInit();//top-down
        downTopInit(30000);//down-top
        while (true) {
            double d = sc.nextDouble();
            if (d == 0) {
                break;
            }
            int m = (int) (Math.round(d * 100));
//            long ans = topDown(0, m);//top-down
            long ans = c[nums.length][m];//down-top
            System.out.printf("%6.2f%17d\n", d, ans);
        }
    }

    static int[] nums = {5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000};
    static long[][] memo = new long[nums.length][30010];

    static void topDownInit() {
        for (long[] aMemo : memo) {
            Arrays.fill(aMemo, -1);
        }
    }

    static long topDown(int n, int m) {
        if (n == nums.length || m < 0) {
            return 0;
        }
        if (m == 0) {
            return 1;
        }
        if (memo[n][m] != -1) {
            return memo[n][m];
        }
        memo[n][m] = topDown(n + 1, m) + topDown(n, m - nums[n]);
        return memo[n][m];
    }

    static long[][] c;
    static void downTopInit(int m) {
        c = new long[nums.length + 1][m + 1];
        for (int i = 0; i <= nums.length; i++) {
            c[i][0] = 1;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= m; j++) {
                if (j - nums[i - 1] < 0) {
                    c[i][j] = c[i - 1][j];
                } else {
                    c[i][j] = c[i - 1][j] + c[i][j - nums[i - 1]];
                }
            }
        }
    }
}
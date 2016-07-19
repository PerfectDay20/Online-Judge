import java.util.Arrays;
import java.util.Scanner;
/*
* memo[i][j][k]
* i: the item id
* j: the remainder
* k: the item amount to be chosen
* http://www.algorithmist.com/index.php/UVa_10616
 */
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        while (true) {
            n = sc.nextInt();
            int q = sc.nextInt();
            if (n == 0 && q == 0) {
                break;
            }
            System.out.printf("SET %d:\n",++count);
            long[] nums = new long[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextLong();
            }
            for (int i = 0; i < q; i++) {
                d = sc.nextInt();
                int m = sc.nextInt();
                cur = new int[n];
                for (int j = 0; j < n; j++) {
                    cur[j] = (int) (nums[j] % d + d) % d;
                }
                memo = new int[n + 1][d][m + 1];
                for (int j = 0; j < memo.length; j++) {
                    for (int k = 0; k < memo[0].length; k++) {
                        Arrays.fill(memo[j][k], -1);
                    }
                }
                System.out.printf("QUERY %d: %d\n", i + 1, topDown(0, 0, m));
            }
        }
    }

    static int[][][] memo;
    static int[] cur;
    static int n;
    static int d;

    static int topDown(int i, int j, int k) {
        if (k == 0) {
            return j == 0 ? 1 : 0;
        }
        if (i == cur.length) {
            return 0;
        }
        if (memo[i][j][k] != -1) {
            return memo[i][j][k];
        } else {
            return memo[i][j][k] = topDown(i + 1, (j + cur[i]) % d, k - 1) + topDown(i + 1, j, k);
        }
    }
}
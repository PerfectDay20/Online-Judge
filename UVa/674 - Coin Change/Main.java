import java.util.Arrays;
import java.util.Scanner;

class Main {
    static int[][] memo = new int[5][7500];
    static int[] c = {50, 25, 10, 5, 1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        while (sc.hasNextInt()) {
            int n = sc.nextInt();

            System.out.println(topDown(0, n));
        }
    }

    static int topDown(int i, int m) {
        if (m < 0) {
            return 0;
        }
        if (m == 0) {
            return 1;
        }
        if (i == c.length) {
            return 0;
        }
        if (memo[i][m] != -1) {
            return memo[i][m];
        } else {
            return memo[i][m] = topDown(i + 1, m) + topDown(i, m - c[i]);
        }
    }
}
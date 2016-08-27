import java.util.Scanner;

class Main {
    private static int All;
    private static int[] start;
    private static int[][] nums, memo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int scenario = sc.nextInt();
        for (int i = 0; i < scenario; i++) {
            int m = sc.nextInt(), n = sc.nextInt();
            start = new int[]{sc.nextInt(), sc.nextInt()};
            int t = sc.nextInt();
            All = (1 << (t + 1)) - 1;
            nums = new int[t + 1][2];
            memo = new int[t + 1][All + 1];
            for (int j = 1; j <= t; j++) {
                nums[j][0] = sc.nextInt();
                nums[j][1] = sc.nextInt();
            }
            nums[0] = start;
            for (int[] ints : memo) {
                for (int j = 0; j < ints.length; j++) {
                    ints[j] = -1;
                }
            }
            System.out.println("The shortest path has length " + tsp(0, 1));
        }
    }

    private static int tsp(int pos, int mask) {
        if (mask == All) {
            return dist(pos, 0);
        }
        if (memo[pos][mask] != -1) {
            return memo[pos][mask];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if ((mask & (1 << i)) == 0) {
                ans = Math.min(ans, dist(pos, i) + tsp(i, mask | (1 << i)));
            }
        }
        return memo[pos][mask] = ans;
    }

    private static int dist(int n1, int n2) {
        return Math.abs(nums[n1][0] - nums[n2][0]) + Math.abs(nums[n1][1] - nums[n2][1]);
    }
}
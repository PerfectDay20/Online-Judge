import java.util.Scanner;

class Main {
    private static int[] nums;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = sc.nextInt();
            }
            for (int j = n - 1; j > 0; j--) {
                nums[j] = nums[j] - nums[j - 1];
            }
            System.out.printf("Case %d: %d%n", i + 1, solve());
        }
    }

    private static int solve() {
        int l = 1, r = 10_000_000;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (isValid(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private static boolean isValid(int n) {
        for (int i : nums) {
            if (n == i) {
                n--;
            } else if (n < i) {
                return false;
            }
        }
        return true;
    }
}
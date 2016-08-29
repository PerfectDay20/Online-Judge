
import java.util.*;

class Main {
//    private static Map<long[], Long> memo;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        memo = new HashMap<>();
//
//        int cases = sc.nextInt();
//        for (int t = 0; t < cases; t++) {
//            long k = sc.nextLong(), a = sc.nextLong(), b = sc.nextLong();
//            System.out.printf("Case %d: %d%n", t + 1, f(k,a,b));
//        }
//    }
//
//    private static long f(long k, long a, long b) {
//        if (k == 0) {
//            return 1;
//        }
//        long[] nums = {k, a, b};
//        if (memo.containsKey(nums)) {
//            return memo.get(nums);
//        }
//        long ans, mask = 1 << (k - 1);
//        if (a > mask) {
//            ans = f(k - 1, a - mask, b - mask);
//        } else if (b > mask) {
//            ans = 2 * f(k - 1, a, mask) + f(k - 1, 0, b - mask);
//        } else {
//            ans = 2 * f(k - 1, a, b);
//        }
//        memo.put(nums, ans);
//        return ans;
//    }
private static Map<long[], Long> memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        memo = new HashMap<>();

        int cases = sc.nextInt();
        for (int t = 0; t < cases; t++) {
            long k = sc.nextLong(), a = sc.nextLong(), b = sc.nextLong();
            System.out.printf("Case %d: %d%n", t + 1, f(k,a,b));
        }
    }

    private static long f(long k, long a, long b) {
        return g(k, b) - g(k, a - 1);
    }

    private static long g(long k, long a) {
        if (a == 0) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        long[] nums = {k, a};
        if (memo.containsKey(nums)) {
            return memo.get(nums);
        }
        long mask = 1 << (k - 1);
        long ans;
        if (a > mask) {
            ans = 2 * (long) Math.pow(3, k - 1) + g(k - 1, a - mask);
        } else {
            ans = 2 * g(k - 1, a);
        }
        memo.put(nums, ans);
        return ans;
    }
}
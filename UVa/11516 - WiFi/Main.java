import java.util.Arrays;
import java.util.Scanner;

class Main {
    private static int[] nums;
    private static int m, n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            n = sc.nextInt(); m = sc.nextInt();
            nums = new int[m];
            for (int j = 0; j < m; j++) {
                nums[j] = 10 * sc.nextInt();//multiply 10, to do the math in int not double
            }
            Arrays.sort(nums);
            System.out.printf("%.1f%n", binary(0, nums[m - 1])/10.0);

        }
    }

    private static int binary(int lo, int hi) {
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (needAP(mid) > n) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private static int needAP(int r) {
        int count = 1, left = 0, right = 1;
        while (right < nums.length) {
            if (nums[right] - nums[left] <= 2 * r) {
                right++;
            } else {
                count++;
                left = right++;
            }
        }
        return count;
    }

}
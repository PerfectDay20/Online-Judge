import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    private static int[] nums;
    private static int m, k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            m = sc.nextInt();
            k = sc.nextInt();
            nums = new int[m];
            long max = 0, sum = 0;
            for (int j = 0; j < m; j++) {
                int temp = sc.nextInt();
                nums[j] = temp;
                max = Math.max(max, temp);
                sum += temp;
            }
            long mount = solve(max, sum);
            System.out.println(print(mount));

        }
    }

    private static long solve(long lo, long hi) {
        while (lo < hi) {
            long mid = (lo + hi) >>> 1;
            if (f(mid) > k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private static long f(long k) {
        long count = 0, left = 0;
        for (long i : nums) {
            if (left < i) {
                count++;
                left = k;
            }
            left -= i;
        }
        return count;
    }

    private static String print(long mount) {
        List<String> list = new ArrayList<>();
        long left = mount, count = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            long num = nums[i];
            if (left < num) {
                list.add("/");
                left = mount;
                count++;
            }
            left -= num;
            list.add("" + num);
        }
        count = k - count;
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i > 0; i--) {
            String s1 = list.get(i), s2 = list.get(i - 1);
            sb.append(s1).append(" ");
            if (count > 0 && !s1.equals("/") && !s2.equals("/")) {
                sb.append("/ ");
                count--;
            }
        }
        sb.append(list.get(0));
        return sb.toString();
    }

}
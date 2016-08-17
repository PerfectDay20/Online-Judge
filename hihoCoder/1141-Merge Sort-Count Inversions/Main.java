import java.util.Scanner;

public class Main {
    private static int[] nums, temp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        nums = new int[n];
        temp = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(sort(0, n - 1));

    }

    private static long sort(int l, int r) {
        if (l >= r) {
            return 0;
        }
        int m = (l + r) >>> 1;
        long sum = 0;
        sum += sort(l, m) + sort(m + 1, r);
        int i = l, j = m + 1, t = l;
        while (i <= m && j <= r) {
            if (nums[i] <= nums[j]) {
                temp[t++] = nums[i++];
            } else {
                temp[t++] = nums[j++];
                sum += m - i + 1;
            }
        }
        while (i <= m) {
            temp[t++] = nums[i++];
        }
        while (j <= r) {
            temp[t++] = nums[j++];
        }
        System.arraycopy(temp, l, nums, l, r - l + 1);
        return sum;
    }
}
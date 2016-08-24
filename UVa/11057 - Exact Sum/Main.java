import java.util.Arrays;
import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            Arrays.sort(nums);
            int m = sc.nextInt();
            int i = 0, j = 0;
//            for (int k = 0; k < n && nums[k] <= m / 2; k++) {
//                int t = Arrays.binarySearch(nums, k + 1, n, m - nums[k]);
//                if (t > 0) {
//                    i = nums[k];
//                    j = nums[t];
//                }
//            }
            int l = 0, r = n - 1;
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum == m) {
                    i = nums[l++];
                    j = nums[r--];
                } else if (sum > m) {
                    r--;
                } else {
                    l++;
                }
            }
            System.out.printf("Peter should buy books whose prices are %d and %d.%n%n", i, j);
        }
    }
}
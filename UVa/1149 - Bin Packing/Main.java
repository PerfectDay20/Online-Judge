import java.util.Arrays;
import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int t = 0; t < cases; t++) {
            if (t != 0) {
                System.out.println();
            }
            int n = sc.nextInt(), l = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            Arrays.sort(nums);
            int left = 0, right = n - 1, count = 0;
            while (left <= right) {
                if (l - nums[right] >= nums[left]) {
                    left++;
                }
                right--;
                count++;
            }
            System.out.println(count);
        }
    }
}
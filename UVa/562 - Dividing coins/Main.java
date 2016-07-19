import java.util.Arrays;
import java.util.Scanner;
//0-1 knapsack problem
//choose from n items and cost sum/2 money
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = sc.nextInt();
            }
            System.out.println(downTop(nums));
        }
    }

    static int downTop(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int k = sum / 2;
        int n = nums.length;
        int[] val1 = new int[k + 1];
        int[] val2 = new int[k + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j >= nums[i - 1]) {
                    val2[j] = Math.max(val1[j], val1[j - nums[i - 1]] + nums[i - 1]);
                } else {
                    val2[j] = val1[j];
                }
            }
            int[] temp = val1;
            val1 = val2;
            val2 = temp;
        }
        return Math.abs(sum - 2 * val1[k]);
    }
}
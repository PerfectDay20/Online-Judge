import java.util.Arrays;
import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < m; i++) {
            String[] ss = sc.nextLine().split(" ");
            int[] nums = new int[ss.length];
            for (int j = 0; j < nums.length; j++) {
                nums[j] = Integer.parseInt(ss[j]);
            }
            System.out.println(downTop(nums));

        }
    }

    static String downTop(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return "NO";
        }
        int k = sum / 2;
        int n = nums.length;
        int[] val1 = new int[k + 1];
        int[] val2 = new int[k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j < nums[i]) {
                    val2[j] = val1[j];
                } else {
                    val2[j] = Math.max(val1[j], val1[j - nums[i]] + nums[i]);
                }
            }
            int[] temp = val1;
            val1 = val2;
            val2 = temp;
        }
        if (val1[k] == k) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
//O(N2) method will OLE, use O(nlogk)
//use LIS twice and reverse
class Main{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            int[] lis1 = LIS2(nums);
            int[] lis2 = LIS2(reverse(nums));
            int max = 0;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, Math.min(lis1[i] * 2 - 1, lis2[n - i - 1] * 2 - 1));
            }
            System.out.println(max);
        }
    }

    static int[] LIS2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        List<Integer> lis = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int index = Collections.binarySearch(lis, nums[i]);
            if (index < 0) {
                index = -index - 1;
            }
            if (index == lis.size()) {
                lis.add(nums[i]);
            } else {
                lis.set(index, nums[i]);
            }
            ans[i] = index + 1;
        }
        return ans;
    }

    static int[] LIS(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    ans[i] = Math.max(ans[i], ans[j]);
                }
            }
            ans[i]++;
        }
        return ans;
    }

    static int[] reverse(int[] nums) {
        int n = nums.length / 2;
        int t = nums.length - 1;
        for (int i = 0; i < n; i++) {
            int temp = nums[i];
            nums[i] = nums[t - i];
            nums[t - i] = temp;
        }
        return nums;
    }
}
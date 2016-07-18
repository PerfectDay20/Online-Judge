import java.util.Scanner;
//use LIS and LDS
//LIS[i] and LDS[i] means the longest increase/decrease subsequence end at i
//this problem need use start at i
//so inverse the array
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[n - 1 - j] = sc.nextInt();
            }
            int[] lis = LIS(nums);
            int[] lds = LDS(nums);
            int max = 1;//in case of t == 0
            for (int j = 0; j < n; j++) {
                max = Math.max(max, lis[j] + lds[j]);
            }
            System.out.println(--max);
        }
    }

    static int[] LIS(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    ans[i] = Math.max(ans[i], ans[j]);
                }
            }
            ans[i]++;
        }
        return ans;
    }

    static int[] LDS(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]) {
                    ans[i] = Math.max(ans[i], ans[j]);
                }
            }
            ans[i]++;
        }
        return ans;
    }
}
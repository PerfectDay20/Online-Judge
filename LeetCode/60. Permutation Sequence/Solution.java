public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().getPermutation(4, 3));
    }

    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        boolean[] flag = new boolean[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        String ans = "";
        while (n > 0) {
            int t = (k - 1) / fact(n - 1);
            k -= t * fact(n - 1);
            int i;
            for(i = 0; i < nums.length; i++) {
                if (!flag[i]) {
                    if (t-- == 0) {
                        break;
                    }
                }
            }
            flag[i] = true;
            ans += nums[i];
            n--;
        }
        return ans;
    }

    private int fact(int n) {
        int ans = 1;
        while (n > 0) {
            ans *= n--;
        }
        return ans;
    }
}
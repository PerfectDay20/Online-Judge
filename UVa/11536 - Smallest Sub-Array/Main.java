import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int t = 0; t < cases; t++) {
            int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
            int[] nums = new int[n];
            nums[0] = 1;
            nums[1] = 2;
            nums[2] = 3;
            for (int i = 3; i < n; i++) {
                nums[i] = (nums[i - 3] + nums[i - 2] + nums[i - 1]) % m + 1;
            }
            int[] pos = new int[k + 1];
            int count = 0, left = -1, right = -1, length = Integer.MAX_VALUE;
            while (right < n || count == k) {
                if (count == k) {
                    length = Math.min(length, right - left);
                    if (nums[++left]<=k&&--pos[nums[left]] == 0) {
                        count--;
                    }
                } else if (++right < n && nums[right] <= k) {
                    if (pos[nums[right]]++ == 0) {
                        count++;
                    }
                }
            }
            if (length == Integer.MAX_VALUE) {
                System.out.printf("Case %d: sequence nai%n", t + 1);
            } else {
                System.out.printf("Case %d: %d%n", t + 1, length);
            }
        }
    }
}
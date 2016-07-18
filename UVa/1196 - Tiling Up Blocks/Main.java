import java.util.Arrays;
import java.util.Scanner;
//typical LIS problem
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                System.out.println("*");
                return;
            }
            int[][] nums = new int[n][2];
            for (int i = 0; i < n; i++) {
                nums[i][0] = sc.nextInt();
                nums[i][1] = sc.nextInt();
            }
            Arrays.sort(nums, (n1, n2) -> n1[0] == n2[0] ? n1[1] - n2[1] : n1[0] - n2[0]);
            int[] pos = new int[n];
            int max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[j][1] <= nums[i][1]) {
                        pos[i] = Math.max(pos[i], pos[j]);
                    }
                }
                pos[i]++;
                max = Math.max(pos[i], max);
            }
            System.out.println(max);
        }
    }
}
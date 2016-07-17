import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int temp = sc.nextInt();
        int count = 0;
        while (true) {
            List<Integer> list = new ArrayList<>();
            list.add(temp);
            while ((temp = sc.nextInt()) != -1) {
                list.add(temp);
            }
            int[] nums = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                nums[i] = list.get(nums.length - i - 1);
            }
            System.out.println("Test #" + ++count + ":");
            System.out.println("  maximum possible interceptions: " + getMax(nums));

            temp = sc.nextInt();
            if (temp != -1) {
                System.out.println();
            } else {
                break;
            }

        }
    }

    static int getMax(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        Arrays.fill(temp, 1);
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] <= nums[i]) {
                    temp[i] = Math.max(temp[j] + 1, temp[i]);
                }
            }
            max = Math.max(max, temp[i]);
        }
        return max;
    }
}
import java.util.Arrays;
import java.util.Scanner;
// can be modeled as LIS (Longest Increasing Subsequence)
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            int[][] nums = new int[3 * n][3];
            int i = 0;
            while (i < 3*n) {// every block has three position, can be pruned if two or three are same; no bother
                for (int j = 0; j < 3; j++) {
                    nums[i][j] = sc.nextInt();
                }
                Arrays.sort(nums[i]);
                i++;
                nums[i][0] = nums[i - 1][1];
                nums[i][1] = nums[i - 1][2];
                nums[i][2] = nums[i - 1][0];
                i++;
                nums[i][0] = nums[i - 2][0];
                nums[i][1] = nums[i - 2][2];
                nums[i][2] = nums[i - 2][1];
                i++;
            }

            Arrays.sort(nums,(n1,n2)->{// sort the block from small to large
                if (n1[0] != n2[0]) {
                    return n1[0] - n2[0];
                } else {
                    return n1[1] - n2[1];
                }
            });


            int sumAll = 0;
            int[] sumHere = new int[3*n];
            for (int j = 0; j < 3 * n; j++) {// LIS
                for (int k = 0; k < j; k++) {
                    if (nums[j][1] > nums[k][1] && nums[j][0] > nums[k][0]) {
                        sumHere[j] = Math.max(sumHere[j], sumHere[k]);
                    }
                }
                sumHere[j] += nums[j][2];
                sumAll = Math.max(sumAll, sumHere[j]);
            }

            System.out.println("Case " + ++count + ": maximum height = " + sumAll);

        }
    }


}
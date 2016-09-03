import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int t = 0; t < cases; t++) {
            int n = sc.nextInt();
            int[][] nums = new int[n][n];
            int[][] out = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    nums[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    out[i][j] = sc.nextInt();
                }
            }

            int[][] min1 = getMin(nums, 0, 0, n - 1, n - 1);
            int[][] min2 = getMin(out, 0, 0, n - 1, n - 1);
            System.out.println(isSame(min1, min2) ? "Yes" : "No");
        }
    }

    private static int[][] getMin(int[][] nums, int x1, int y1, int x2, int y2) {
        int n = x2 - x1 + 1;
        if (n % 2 == 1 || n == 2) {

            int[][] min = getSub(nums, x1, y1, x2, y2);
            int[][] temp = getSub(nums, x1, y1, x2, y2);
            for (int i = 0; i < 3; i++) {
                temp = rotate(temp, 0, 0, n-1, n-1);
                min = smaller(min, temp);
            }
            return min;
        } else {
            int midx = (x1 + x2) / 2, midy = (y1 + y2) / 2;
            int[][] min1 = getMin(nums, x1, y1, midx, midy);
            int[][] min2 = getMin(nums, x1, midy + 1, midx, y2);
            int[][] min3 = getMin(nums, midx + 1, y1, x2, midy);
            int[][] min4 = getMin(nums, midx + 1, midy + 1, x2, y2);
            int[][] min = transform(min1, min2, min3, min4);
            int[][] temp1 = transform(min3, min1, min4, min2);
            int[][] temp2 = transform(min4, min3, min2, min1);
            int[][] temp3 = transform(min2, min4, min1, min3);
            min = smaller(min, smaller(temp1, smaller(temp2, temp3)));
            return min;
        }
    }

    private static int[][] getSub(int[][] nums, int x1, int y1, int x2, int y2) {
        int n = x2 - x1 + 1;
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = nums[x1 + i][y1 + j];
            }
        }
        return ans;
    }

    private static boolean isSame(int[][] nums1, int[][] nums2) {
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums1[0].length; j++) {
                if (nums1[i][j] != nums2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[][] smaller(int[][] nums, int[][] out) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if (nums[i][j] < out[i][j]) {
                    return nums;
                }else if (nums[i][j] > out[i][j]) {
                    return out;
                }
            }
        }
        return nums;
    }

    private static int[][] rotate(int[][] nums, int x1, int y1, int x2, int y2) {
        int n = x2 - x1 + 1;
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = nums[x2 - j][y1 + i];
            }
        }
        return temp;
    }

    private static int[][] transform(int[][] n1, int[][] n2, int[][] n3, int[][] n4) {
        int n = n1.length;
        int[][] ans = new int[2 * n][2 * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = n1[i][j];
                ans[i][n + j] = n2[i][j];
                ans[n + i][j] = n3[i][j];
                ans[n + i][n + j] = n4[i][j];
            }
        }
        return ans;
    }
}
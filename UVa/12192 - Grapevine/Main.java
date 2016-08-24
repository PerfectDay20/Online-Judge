import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt(), m = sc.nextInt();
            if (n == 0) {
                return;
            }
            int[][] nums = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    nums[i][j] = sc.nextInt();
                }
            }
            //use the array as m < n, if not, reconstruct one
            if (m < n) {
                int[][] nums1 = new int[m][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        nums1[j][i] = nums[i][j];
                    }
                }
                int temp = m;
                m = n;
                n = temp;
                nums = nums1;
            }

            //construct temp, which is diagonal array of the nums
            int[][] temp = new int[m + n - 1][];

            for (int i = 0; i < n - 1; i++) {
                temp[i] = new int[i + 1];
                for (int j = 0; j <= i; j++) {
                    temp[i][j] = nums[j][m - i - 1 + j];
                }
            }
            for (int i = n - 1; i < m; i++) {
                temp[i] = new int[n];
                for (int j = 0; j < n; j++) {
                    temp[i][j] = nums[j][m - i - 1 + j];
                }
            }

            for (int i = m; i < m + n - 1; i++) {
                temp[i] = new int[m + n - 1 - i];
                for (int j = 0; j < m+n-1-i; j++) {
                    temp[i][j] = nums[i - m+1 + j][j];
                }
            }
            //binary search every row of temp, which is every diagonal of the original array
            int q = sc.nextInt();
            for (int z = 0; z < q; z++) {
                int l = sc.nextInt(), h = sc.nextInt(), max = 0;
                for (int i = 0; i < temp.length; i++) {
                    int start = lower(temp[i], l);
                    int end = upper(temp[i], h);
                    max = Math.max(max, end - start);
                }
                System.out.println(max);
            }
            System.out.println("-");

        }
    }

    private static int lower(int[] nums, int k) {
        int l = 0, r = nums.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (nums[m] >= k) {
                r = m;
            } else{
                l = m + 1;
            }
        }
        return l;
    }

    private static int upper(int[] nums, int k) {
        int l = 0, r = nums.length;
        while (l < r) {
            int m = (l + r) >>> 1;
            if (nums[m] > k) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
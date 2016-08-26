import java.util.Scanner;

class Main{
    private static int[] nums, temp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            nums = new int[n];
            temp = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            System.out.println("Minimum exchange operations : " + inversionIndex(0, n - 1));
        }
    }

    private static int inversionIndex(int left, int right) {
        if (left==right)
            return 0;
        int mid = (left + right) >>> 1, count = 0;
        count += inversionIndex(left, mid) + inversionIndex(mid + 1, right);
        int i = left, j = mid + 1, index = left;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[index++] = nums[i++];
            } else {
                count += mid - i + 1;
                temp[index++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[index++] = nums[i++];
        }
        while (j <= right) {
            temp[index++] = nums[j++];
        }
        System.arraycopy(temp, left, nums, left, right - left + 1);
        return count;
    }

}
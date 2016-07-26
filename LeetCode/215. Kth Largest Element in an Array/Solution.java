public class Solution {//use quick sort to find k
    public static void main(String[] args) {
        int[] nums = {31};
        System.out.println(new Solution().findKthLargest(nums, 1));
    }
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int pos = partition(nums, left, right);
            if (pos == k) {
                return nums[pos];
            } else if (pos < k) {
                left = pos + 1;
            } else {
                right = pos - 1;
            }
        }
        return nums[left];
    }

    private int partition(int[] nums, int left, int right) {
        int mid = (left + right) >>> 1;
        int pivot = getMid(nums, left, right);
        swap(nums, mid, right - 1);
        int i = left, j = right - 1;
        while (i < j) {
            while (nums[++i] < pivot) {
            }
            while (nums[--j] > pivot) {
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, i, right - 1);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int getMid(int[] nums, int left, int right) {//get pivot and sort these three items
        int mid = (left + right) >>> 1;
        if (nums[left] > nums[mid]) {
            swap(nums, left, mid);
        }
        if (nums[left] > nums[right]) {
            swap(nums, left, right);
        }
        if (nums[mid] > nums[right]) {
            swap(nums, mid, right);
        }
        return nums[mid];
    }
}
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m + n - 1; i >= n; i--) {//copy nums1 forward n
            nums1[i] = nums1[i - n];
        }
        int i = 0, n1 = n, n2 = 0;
        while (n1 <= m + n - 1 && n2 <= n - 1) {
            if (nums1[n1] > nums2[n2]) {
                nums1[i++] = nums2[n2++];
            } else {
                nums1[i++] = nums1[n1++];
            }
        }
        while (n2 <= n - 1) {//if nums2 is not finish, put left in nums1; while nums1 is already in place
            nums1[i++] = nums2[n2++];
        }
    }
}
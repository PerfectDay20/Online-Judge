import java.util.Arrays;

public class Solution {
    public int hIndex(int[] citations) {
        int size = citations.length;
        int[] nums = new int[size + 1];//nums[i] mean the number of digit that is i
        for (int i : citations) {
            if (i >= size) {
                nums[size]++;
            } else {
                nums[i]++;
            }
        }
        int i, sum = 0;
        for (i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            if (sum >= i) {
                break;
            }
        }
        return i;
    }
}
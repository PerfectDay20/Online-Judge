public class Solution {
    public int majorityElement(int[] nums) {
        int n = 0, count = 0;
        for (int num : nums) {
            if (count == 0) {
                n = num;
                count++;
            } else {
                if (n == num) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return n;
    }
}
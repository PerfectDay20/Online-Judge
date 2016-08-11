import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] nums = new int[size + 1];
        for (int i = size - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                nums[j] = triangle.get(i).get(j) + Math.min(nums[j], nums[j+1]);
            }
        }
        return nums[0];
    }
}
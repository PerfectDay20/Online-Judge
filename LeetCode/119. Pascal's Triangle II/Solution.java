import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[] nums = new int[rowIndex + 1];
        nums[0] = 1;
        for (int i = 0; i < rowIndex; i++) {
            for (int j = i + 1; j > 0; j--) {
                nums[j] += nums[j - 1];
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        return list;
    }
}
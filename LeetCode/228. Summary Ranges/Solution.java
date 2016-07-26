import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums == null || nums.length < 1) {
            return list;
        }
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            while (i + 1 < nums.length && nums[i + 1] - nums[i] == 1) {
                i++;
            }
            if (n == nums[i]) {
                list.add(n+"");
            } else {
                list.add(n + "->" + nums[i]);
            }
        }
        return list;
    }
}
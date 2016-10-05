import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = 1 << nums.length;
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            int temp = i, index = 0;
            while (temp > 0) {
                if ((temp & 1) == 1) {
                    list.add(nums[index]);
                }
                temp >>= 1;
                index++;
            }
            ans.add(list);
        }
        return ans;
    }
}
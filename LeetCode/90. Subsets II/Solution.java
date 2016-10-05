import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().subsetsWithDup(new int[]{1, 2, 2}));
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        recursive(nums, 0, ans, list);
        return ans;
    }

    private void recursive(int[] nums, int index, List<List<Integer>> ans, List<Integer> list) {
        ans.add(new ArrayList<>(list));
        for(int i = index; i < nums.length; i++) {
            if (!(i != index && nums[i] == nums[i - 1])) {
                list.add(nums[i]);
                recursive(nums, i + 1, ans, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
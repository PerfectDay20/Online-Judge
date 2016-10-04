import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum(new int[]{2,3,6,7}, 7));
    }

    private List<List<Integer>> ans;
    private List<Integer> list;
    private int[] nums;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        list = new ArrayList<>();
        ans = new ArrayList<>();
        nums = candidates;
        Arrays.sort(candidates);

        recursive(target, 0);
        return ans;
    }

    private void recursive(int left, int index) {
        if (left == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < nums.length && left >= nums[i]; i++) {
            list.add(nums[i]);
            recursive(left - nums[i], i);
            list.remove(list.size() - 1);
        }


    }
}
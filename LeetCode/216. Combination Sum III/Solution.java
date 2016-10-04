import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum3(2, 8));

    }

    private List<List<Integer>> ans;
    private List<Integer> list;
    private int[] nums;
    private int k;

    public List<List<Integer>> combinationSum3(int k, int n) {
        list = new ArrayList<>();
        ans = new ArrayList<>();
        nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        this.k = k;
        recursive(n, 0);
        return ans;
    }

    private void recursive(int left, int index) {
        if (left == 0) {
            if (list.size() == k) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = index; i < nums.length && left >= nums[i]; i++) {

            list.add(nums[i]);
            recursive(left - nums[i], i + 1);
            list.remove(list.size() - 1);


        }


    }
}
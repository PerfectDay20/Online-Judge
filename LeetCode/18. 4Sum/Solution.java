import java.util.*;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {//O(N^3)
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();

        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                int left = j + 1, right = n - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[left++], nums[right--]);
                        if (set.add(temp)) {
                            list.add(temp);
                        }
                    }
                }
            }
        }
        return list;
    }
}
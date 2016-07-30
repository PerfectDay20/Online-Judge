import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {//DP
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        int[] count = new int[nums.length];
        int[] son = new int[nums.length];
        Arrays.fill(son, -1);
        Arrays.sort(nums);
        int max = -1;
        int index = 0;


        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && count[j] + 1 > count[i]) {
                    count[i] = count[j] + 1;
                    son[i] = j;
                }
            }
            if (count[i] > max) {
                max = count[i];
                index = i;
            }
        }

        List<Integer> ans = new ArrayList<>(count[index]);
        while (index != -1) {
            ans.add(nums[index]);
            index = son[index];
        }
        return ans;
    }
}
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    //use method "Generation in lexicographic order" in https://en.wikipedia.org/wiki/Permutation
    //same as 46. Permutations
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        ans.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        while (true) {
            int i = 0;
            for (i = nums.length - 1; i > 0; i--) {
                if (nums[i] > nums[i - 1]) {
                    int j = nums.length - 1;
                    while (nums[j] <= nums[i - 1]) {
                        j--;
                    }
                    swap(nums, i - 1, j);
                    reverse(nums, i, nums.length - 1);
                    ans.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
                    break;
                }
            }
            if (i <= 0) {//in case nums.length()==0
                break;
            }
        }
        return ans;
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}
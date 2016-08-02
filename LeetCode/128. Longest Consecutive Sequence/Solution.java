import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int max = 0;
        for (int i : nums) {
            int count = 1;
            if (!set.contains(i - 1)) {//i is the first one in a streak
                while (set.contains(++i)) {
                    count++;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
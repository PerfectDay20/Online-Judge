import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public int thirdMax1(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int n : nums) {
            if (set.add(n) && set.size() > 3) {
                set.remove(set.first());
            }
        }
        return set.size() == 3 ? set.first() : set.last();
    }
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int n : nums) {
            max = Math.max(max, n);
            min = Math.min(min, n);
            set.add(n);
        }
        if (set.size() < 3) {
            return max;
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < 2; i++) {
            for (int n : nums) {
                if (ans < n && n < max) {
                    ans = n;
                }
            }
            max = ans;
            ans = Integer.MIN_VALUE;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().thirdMax(new int[]{1, 1, 0}));
    }
}
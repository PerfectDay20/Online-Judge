import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        char[] cs = s.toCharArray();
        int[] nums = new int[cs.length];
        for (int i = 0; i < cs.length; i++) {
            nums[i] = Character.getNumericValue(cs[i]);
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 3 && i < nums.length - 3; i++) {
            for (int j = i + 1; j <= i + 3 && j < nums.length - 2; j++) {
                for (int k = j + 1; k <= j + 3 && k < nums.length - 1; k++) {
                    if (nums.length - k - 1 > 3) {
                        continue;
                    }
                    int a = getNum(nums, 0, i);
                    int b = getNum(nums, i + 1, j);
                    int c = getNum(nums, j + 1, k);
                    int d = getNum(nums, k + 1, nums.length - 1);
                    if (a != -1 && b != -1 && c != -1 && d != -1) {
                        list.add(a + "." + b + "." + c + "." + d);
                    }
                }
            }
        }
        return list;
    }

    private int getNum(int[] nums, int i, int j) {
        if (nums[i] == 0 && i < j) {

            return -1;
        }
        int ans = 0;
        while (i <= j) {
            ans = ans * 10 + nums[i++];
        }
        return ans > 255 ? -1 : ans;
    }
}
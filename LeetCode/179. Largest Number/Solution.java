import java.util.Arrays;

public class Solution {
    public String largestNumber1(int[] nums) {
        Integer[] nums1 = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums1[i] = nums[i];
        }
        Arrays.sort(nums1, (i, j) -> {
            String s1 = i + "" + j, s2 = j + "" + i;
            return s2.compareTo(s1);
        });
        StringBuilder sb = new StringBuilder();
        for (Integer i : nums1) {
            sb.append(i);
        }
        String ans = sb.toString();
        if (ans.charAt(0) == '0') {
            return "0";
        } else return ans;
    }

    public String largestNumber(int[] nums) {
        String s = Arrays.stream(nums).mapToObj(String::valueOf).sorted((s1, s2) -> (s2 + s1).compareTo(s1 + s2)).reduce("",(s1, s2) -> s1 + s2);
        return s.charAt(0) == '0' ? "0" : s;
    }
}
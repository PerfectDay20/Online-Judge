public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a']++;
            nums[t.charAt(i) - 'a']--;
        }
        for (int num : nums) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}
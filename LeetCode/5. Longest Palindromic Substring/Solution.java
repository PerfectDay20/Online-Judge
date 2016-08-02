public class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        String maxString = "";
        for (int i = 0; i < s.length(); i++) {
            max = Math.max(max, helper(s, i, i));
            max = Math.max(max, helper(s, i, i + 1));
            if (max > maxString.length()) {
                maxString = s.substring(i - (max - 1) / 2, i + max / 2 + 1);
            }
        }
        return maxString;
    }

    private int helper(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i + 1;
    }
}
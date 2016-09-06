public class Solution {
    public char findTheDifference(String s, String t) {
        int[] cs = new int[26];
        for(int i = 0, n = s.length(); i< n; i++) {
            cs[s.charAt(i) - 'a']++;
        }
        for(int i = 0, n = t.length(); i < n; i ++) {
            if (cs[t.charAt(i) - 'a']-- == 0) {
                return t.charAt(i);
            }
        }
        throw new IllegalArgumentException();
    }
}
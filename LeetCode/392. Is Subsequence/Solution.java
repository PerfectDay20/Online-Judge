public class Solution {
    public boolean isSubsequence(String s, String t) {//54ms
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
    public boolean isSubsequence1(String s, String t) {//11ms
        int i = 0, j = 0;
        char[] cs1 = s.toCharArray(), cs2 = t.toCharArray();
        int n1 = cs1.length, n2 = cs2.length;
        while (i < n1 && j < n2) {
            if (cs1[i] == cs2[j]) {
                i++;
            }
            j++;
        }
        return i == n1;
    }
}
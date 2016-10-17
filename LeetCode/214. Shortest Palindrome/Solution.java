import java.util.Arrays;

public class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        for(int i = n - 1; i >= 0; i--) {
            if (isPal(0, i, cs)) {
                StringBuilder sb = new StringBuilder();
                sb.append(cs, i + 1, n - i - 1).reverse().append(s);
                return sb.toString();
            }
        }
        return "";
    }

    private boolean isPal(int i, int j, char[] cs) {
        while (i <= j) {
            if (cs[i++] != cs[j--]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().shortestPalindrome("aaa"));
    }
}
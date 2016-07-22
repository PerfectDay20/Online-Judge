public class Solution {
    public int myAtoi(String s) {
        if (s == null) {
            return 0;
        }
        int i = 0;
        while (i < s.length() && Character.isWhitespace(s.charAt(i))) {//delete leading spaces
            i++;
        }
        if (i == s.length()) {
            return 0;
        }
        boolean flag = false;//positive or negative
        if (s.charAt(i) == '+') {
            flag = true;
            i++;
        } else if (s.charAt(i) == '-') {
            i++;
        } else {//the char at i is a digit, then positive
            flag = true;
        }
        int ans = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            if (ans > Integer.MAX_VALUE / 10 || ans == Integer.MAX_VALUE / 10 && (s.charAt(i) - '0') >= Integer.MAX_VALUE % 10 + 1) {
                return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = ans * 10 + Character.getNumericValue(s.charAt(i));
            i++;
        }
        return flag ? ans : -ans;
    }
}
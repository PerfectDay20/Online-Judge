public class Solution {
    public int titleToNumber(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - 'A' + 1;
            sum = sum * 26 + digit;
        }
        return sum;
    }
}
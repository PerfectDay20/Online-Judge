public class Solution {
    public String addStrings(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        int n = Math.max(n1, n2) + 1;
        char[] cs = new char[n];
        int carry = 0;
        while (n > 0) {
            int a = n1-- >= 0 ? num1.charAt(n1) - '0' : 0;
            int b = n2-- >= 0 ? num2.charAt(n2) - '0' : 0;
            int sum = a + b + carry;
            cs[--n] = (char) (sum % 10 + '0');
            carry = sum / 10;
        }
        if (cs[0] == '0') {
            return new String(cs, 1, cs.length - 1);
        } else {
            return new String(cs);
        }
    }
}
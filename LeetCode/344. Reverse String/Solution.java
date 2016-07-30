public class Solution {
    public String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public String reverseString2(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
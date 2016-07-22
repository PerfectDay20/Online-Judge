public class Solution {
    public String addBinary(String a, String b) {
        int maxLength = Math.max(a.length(), b.length()) + 1;
        int[] n1 = new int[maxLength];
        int[] n2 = new int[maxLength];
        int[] n3 = new int[maxLength];
        for (int i = 0; i < a.length(); i++) {//process in reversal order
            n1[a.length() - i - 1] = Character.getNumericValue(a.charAt(i));
        }
        for (int i = 0; i < b.length(); i++) {
            n2[b.length() - i - 1] = Character.getNumericValue(b.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxLength; i++) {
            int digit = n1[i] + n2[i] + n3[i];
            if (digit <= 1) {
                sb.append(digit);
            } else {
                if (digit == 2) {
                    sb.append(0);
                } else {//digit == 3
                    sb.append(1);
                }
                n3[i + 1] = 1;
            }
        }
        sb.reverse();
        int index = sb.indexOf("1");
        if (index == -1) {//all digit is 0
            return "0";
        } else {//delete the leading 0s
            return sb.substring(index);
        }

    }
}
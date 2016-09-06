public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().decodeString("2[abc]3[cd]ef"));
    }
    public String decodeString(String s) {
        boolean isFinished = true;
        int i = 0;//start index of the digit
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                isFinished = false;
                break;
            }
            i++;
        }
        if (isFinished) {//no digit, then return the string
            return s;
        }
        int j = i + 1;//start index of '[', also after the last index of digit
        while (s.charAt(j) != '[') {
            j++;
        }
        int dup = Integer.parseInt(s.substring(i, j));
        int count = 1;
        int k = j + 1;//the corresponding index of ']' to the first '['
        while (k < s.length()) {
            if (s.charAt(k) == '[') {
                count++;
            } else if (s.charAt(k) == ']' && --count == 0) {
                break;
            }
            k++;
        }
        StringBuilder sb = new StringBuilder();

        sb.append(s.substring(0, i));//add first part
        String temp = decodeString(s.substring(j + 1, k));
        for (int l = 0; l < dup; l++) {
            sb.append(temp);//add string in the []
        }
        sb.append(decodeString(s.substring(k + 1)));//add the last part
        return sb.toString();
    }
}
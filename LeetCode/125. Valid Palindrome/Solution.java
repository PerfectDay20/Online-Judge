public class Solution {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(new Solution().isPalindrome(s));
    }
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            } else if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            } else {
                char c1 = Character.toLowerCase(s.charAt(i));
                char c2 = Character.toLowerCase(s.charAt(j));
                if (c1 != c2) {
                    return false;
                } else {
                    i++;
                    j--;
                }
            }
        }
        return true;
    }

}
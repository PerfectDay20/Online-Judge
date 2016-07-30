public class Solution {
    public String reverseVowels(String s) {
        char[] cs = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (!isVow(cs[i])) {
                i++;
            } else if (!isVow(cs[j])) {
                j--;
            } else {
                char temp = cs[i];
                cs[i] = cs[j];
                cs[j] = temp;
                i++;
                j--;
            }
        }
        return new String(cs);
    }

    private boolean isVow(char c) {
        c = Character.toLowerCase(c);
        return c == 'e' || c == 'a' || c == 'i' || c == 'o' || c == 'u';
    }
}
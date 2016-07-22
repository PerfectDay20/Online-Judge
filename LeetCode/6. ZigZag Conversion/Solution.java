public class Solution {
    public static void main(String[] args) {
        String s = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(new Solution().convert(s, 1));
    }
    public String convert(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }
        int i = 0;
        while (i < s.length()) {
            for (int j = 0; j < numRows && i < s.length(); j++, i++) {
                sb[j].append(s.charAt(i));
            }
            for (int j = numRows - 2; j > 0 && i < s.length(); j--, i++) {
                sb[j].append(s.charAt(i));
            }
        }

        for (i = 1; i < numRows; i++) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();

    }
}
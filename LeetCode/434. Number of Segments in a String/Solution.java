public class Solution {
    public int countSegments(String s) {
        boolean preSpace = true;
        int count = 0;
        for (char c : s.toCharArray()) {
            if (!preSpace && c == ' ') {
                preSpace = true;
            } else if (preSpace && c != ' ') {
                preSpace = false;
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        String s = ", , , ,        a, eaefa";
        System.out.println(new Solution().countSegments(s));
        System.out.println((s.split(" +").length));
    }
}
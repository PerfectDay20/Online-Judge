public class Solution {
    public boolean isIsomorphic(String s1, String s2) {
        int[] m = new int[512];//use an array store two strings information
        for (int i = 0; i < s1.length(); i++) {
            if (m[s1.charAt(i)] != m[s2.charAt(i) + 256]) return false;//if the last time they doesn't appear together
            m[s1.charAt(i)] = m[s2.charAt(i) + 256] = i + 1;//both set the last position i the pair appear
        }//set to i + 1 to prevent the first and second pair don't suit the pattern
        return true;
    }
}
public class Solution {
    public int maxProduct(String[] words) {
        int[] nums = new int[words.length];
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            nums[i] = stringToInt(words[i]);
            if (i != 0) {
                for (int j = 0; j < i; j++) {
                    if ((nums[i] & nums[j]) == 0) {//two strings don't share same char
                        max = Math.max(max, words[i].length() * words[j].length());
                    }
                }
            }
        }
        return max;
    }

    private int stringToInt(String s) {//using bitmask to store a string's all characters
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            n |= 1 << (s.charAt(i) - 'a');
        }
        return n;
    }
}
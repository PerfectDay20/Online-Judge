import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int sLength = s.length(), pLength = p.length();
        if (sLength < pLength) {
            return list;
        }
        //initialize
        int[] count = new int[128];
        int numOfNonZero = 0;
        for (char c : p.toCharArray()) {
            if (count[c]++ == 0) {
                numOfNonZero++;
            }
        }
        //deal with first part, same length as p
        char[] scs = s.toCharArray();
        char c;
        for (int i = 0; i < pLength; i++) {
            c = scs[i];
            count[c]--;
            if (count[c] == 0) {
                numOfNonZero--;
            } else if (count[c] == -1) {
                numOfNonZero++;
            }
        }

        if (numOfNonZero == 0) {
            list.add(0);
        }
        //deal with remaining
        for (int i = 0; i < sLength - pLength; i++) {
            c = scs[i];
            count[c]++;
            if (count[c] == 0) {
                numOfNonZero--;
            } else if (count[c] == 1) {
                numOfNonZero++;
            }

            c = scs[i + pLength];
            count[c]--;
            if (count[c] == 0) {
                numOfNonZero--;
            } else if (count[c] == -1) {
                numOfNonZero++;
            }
            if (numOfNonZero == 0) {
                list.add(i + 1);
            }
        }
        return list;
    }

    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int[] hash = new int[128];
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        int left = 0, right = 0, count = p.length(), sLength = s.length(), pLength = p.length();
        char[] cs = s.toCharArray();
        while (right < sLength) {
            if (hash[cs[right++]]-- >= 1) {
                count--;
            }
            if (count == 0) {
                list.add(left);
            }
            if (right - left == pLength && hash[cs[left++]]++ >= 0) {
                count++;
            }
        }
        return list;
    }
}
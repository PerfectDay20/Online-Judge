public class Solution {
    public boolean repeatedSubstringPattern(String str) {
        char[] cs = str.toCharArray();
        int n = cs.length;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i != 0) {
                continue;
            }
            int d = n / i;
            if (check(cs, i, d)) {
                return true;
            }
        }
        return false;
    }

    private boolean check(char[] cs, int i, int d) {
        for (int j = 1; j < d; j++) {
            for (int k = 0; k < i; k++) {
                if (cs[i * j + k] != cs[k]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean repeatedSubstringPattern1(String str) {
        return (str.substring(1) + str.substring(0, str.length() - 1)).indexOf(str) != -1;
    }
}
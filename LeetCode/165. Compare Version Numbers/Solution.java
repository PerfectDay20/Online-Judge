public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] ss1 = version1.split("\\.");
        String[] ss2 = version2.split("\\.");
        int max = Math.max(ss1.length, ss2.length);

        for (int i = 0; i < max; i++) {
            int a = 0, b = 0;
            if (i < ss1.length) {
                a = Integer.parseInt(ss1[i]);
            }
            if (i < ss2.length) {
                b = Integer.parseInt(ss2[i]);
            }
            if (a > b) {
                return 1;
            }
            if (a < b) {
                return -1;
            }
        }
        return 0;

    }
}
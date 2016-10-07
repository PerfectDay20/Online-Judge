public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int n = citations.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int m = (l + r) >>> 1;
            if (citations[m] > n - m) {
                r = m - 1;
            } else if (citations[m] < n - m) {
                l = m + 1;
            } else {
                return citations[m];
            }
        }
        return n - l;
    }

}
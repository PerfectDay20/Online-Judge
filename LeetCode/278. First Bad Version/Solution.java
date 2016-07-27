/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 0, right = n;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (isBadVersion(mid)) {//mid can be the first bad
                right = mid;
            } else {//mid can't be the first, mid + 1 can
                left = mid + 1;
            }
        }
        return left;
    }
}
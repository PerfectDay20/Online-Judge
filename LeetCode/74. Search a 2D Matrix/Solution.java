import java.util.Arrays;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0, r = matrix.length;
        while (l < r) {//find the location of target, if not exist, find the insert location
            int m = (l + r) >>> 1;
            if (matrix[m][0] >= target) {
                r = m;
            } else if (matrix[m][0] < target) {
                l = m + 1;
            }
        }
        if (l < matrix.length && matrix[l][0] == target) {//the first element is target
            return true;
        }
        if (l == 0) {//we have proved matrix[0][0] != target, so all the item is smaller than target
            return false;
        }
        return Arrays.binarySearch(matrix[l - 1], target) > 0;
    }
}
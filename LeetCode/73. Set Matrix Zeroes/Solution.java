public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean zrow = false, zcol = false;
        for (int i = 0; i < matrix.length; i++) {//if first column contains 0
            if (matrix[i][0] == 0) {
                zcol = true;
                break;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {//if first row contains 0
            if (matrix[0][i] == 0) {
                zrow = true;
                break;
            }
        }
        for (int i = 1; i < matrix.length; i++) {//record 0 to the first column ans row
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {//set 0 based on the record
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (zcol) {//handle first column
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        if (zrow) {//handle first row
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}
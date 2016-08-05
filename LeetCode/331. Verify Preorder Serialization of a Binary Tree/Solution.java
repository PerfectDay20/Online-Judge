public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] ss = preorder.split(",");
        int count = 0;
        for (int i = ss.length - 1; i >= 0; i--) {//from back to front, every int consume two '#' then create one '#'
            if (ss[i].equals("#")) {
                count++;
            } else if (count < 2) {
                return false;
            } else {//so one int finally decrease one '#'
                count--;
            }
        }
        return count == 1;
    }
}
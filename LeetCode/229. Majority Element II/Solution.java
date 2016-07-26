import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int a = 0, b = 0, countA = 0, countB = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == a) {
                countA++;
            } else if (nums[i] == b) {
                countB++;
            } else if (countA == 0) {
                countA++;
                a = nums[i];
            } else if (countB == 0) {
                countB++;
                b = nums[i];
            } else {//if has three distinct number, delete them all
                countA--;
                countB--;
            }
        }
        countA = 0;
        countB = 0;
        for (int i = 0; i < nums.length; i++) {//test the candidates
            if (nums[i] == a) {
                countA++;
            } else if (nums[i] == b) {
                countB++;
            }
        }
        if (countA > nums.length / 3) {
            list.add(a);
        }
        if (countB > nums.length / 3) {
            list.add(b);
        }
        return list;
    }
}
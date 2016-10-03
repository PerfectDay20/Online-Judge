import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String>[] hList = new List[4];
        List<String>[] mList = new List[6];
        for (int i = 0; i < 4; i++) {
            hList[i] = new ArrayList<>();
        }
        for (int i = 0; i < 6; i++) {
            mList[i] = new ArrayList<>();
        }
        for (int i = 0; i <= 11; i++) {
            int count = Integer.bitCount(i);
            hList[count].add("" + i);
        }
        for (int i = 0; i <= 59; i++) {
            int count = Integer.bitCount(i);
            if (i < 10) {
                mList[count].add("0" + i);
            } else {
                mList[count].add("" + i);
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i <= 3 && i <= num; i++) {
            if (num - i > 5) {
                continue;
            }
            for (String h : hList[i]) {
                for (String m : mList[num - i]) {
                    ans.add(h + ":" + m);
                }
            }
        }
        return ans;
    }
}
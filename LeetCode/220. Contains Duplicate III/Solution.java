import java.util.HashMap;
import java.util.Map;
//use bucket to store item
public class Solution {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) {
            return false;
        }
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long val = (long) nums[i] - Integer.MIN_VALUE;//change all the number to positive to prevent handle negative near 0
            long id = val / ((long)t + 1);//bucket id
            if (map.containsKey(id) || map.containsKey(id - 1) && val - map.get(id - 1) <= t || map.containsKey(id + 1) && map.get(id + 1) - val <= t) {
                return true;
            }
            if (i >= k) {//delete the item far more than k
                long last = (long) nums[i - k] - Integer.MIN_VALUE;
                long idLast = last / ((long)t + 1);
                map.remove(idLast);
            }
            map.put(id, val);
        }
        return false;
    }
}
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> list = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0) {
            return list;
        }
        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.sum - o2.sum;
            }
        });
        //PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparing(Pair::getSum));
        //using lambda is slow in leetcode
        for (int i = 0; i < nums1.length && i < k; i++) {
            queue.add(new Pair(i, 0, nums1[i] + nums2[0]));
        }
        while (list.size() < k && !queue.isEmpty()) {
            Pair p = queue.remove();
            list.add(new int[]{nums1[p.x], nums2[p.y]});
            if (p.y < nums2.length - 1) {
                queue.add(new Pair(p.x, p.y + 1, nums1[p.x] + nums2[p.y + 1]));
            }
        }
        return list;
    }

    class Pair{
        int x;
        int y;
        int sum;

        public Pair(int x, int y, int sum) {
            this.x = x;
            this.y = y;
            this.sum = sum;
        }

        public int getSum() {
            return sum;
        }
    }
}
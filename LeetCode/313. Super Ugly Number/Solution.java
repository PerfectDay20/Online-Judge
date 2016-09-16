import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().nthSuperUglyNumber1(100000, new int[]{7,19,29,37,41,47,53,59,61,79,83,89,101,103,109,127,131,137,139,157,167,179,181,199,211,229,233,239,241,251}));
    }

    public int nthSuperUglyNumber1(int n, int[] primes) {
        int[] nums = new int[n];
        nums[0] = 1;
        int k = primes.length;
        int[] index = new int[k], factor = new int[k];
        for (int i = 0; i < k; i++) {
            factor[i] = primes[i];
        }
        for (int i = 1; i < n; i++) {
            int min = factor[0];
            for (int j = 0; j < k; j++) {
                min = Math.min(factor[j], min);
            }
            nums[i] = min;
            for (int j = 0; j < k; j++) {
                if (factor[j] == min) {
                    factor[j] = nums[++index[j]] * primes[j];
                }
            }
        }
        return nums[n - 1];
    }
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n == 1) {
            return 1;
        }
        int k = primes.length;
        PriorityQueue<long[]> pq = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                long ans = o1[0] - o2[0];
                if (ans > 0) {
                    return 1;
                } else if (ans < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        for (int i = 0; i < k; i++) {
            pq.add(new long[]{primes[i], i});
        }
        while (--n > 1) {
            long[] head = pq.remove();


            for (int i = (int)head[1]; i < k; i++) {
                pq.add(new long[]{head[0] * primes[i], i});
            }
        }
        return (int)pq.remove()[0];
    }
}
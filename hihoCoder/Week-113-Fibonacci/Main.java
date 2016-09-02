import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main{
    private static Map<Integer,Integer> f;
    private static int M = 1_000_000_007;

    public static void main(String[] args) {
        f = fib();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] count = new int[30];//store the number of sequence end with corresponding index in fibonacci sequence;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                count[1] = (count[1] + count[0]) % M;
                count[0] = (count[0] + 1) % M;
            } else if (f.containsKey(nums[i])) {
                int index = f.get(nums[i]);
                count[index] = (count[index] + count[index - 1]) % M;
            }
        }
        long sum = 0;
        for (int i = 0; i < count.length; i++) {
            sum = (sum + count[i]) % M;
        }
        System.out.println(sum);
    }

    private static Map<Integer, Integer> fib() {
        int[] nums = new int[30];
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i < nums.length; i++) {
            nums[i] = nums[i - 2] + nums[i - 1];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        return map;
    }
}
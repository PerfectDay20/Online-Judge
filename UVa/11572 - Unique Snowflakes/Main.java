import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int t = 0; t < cases; t++) {
            int n = sc.nextInt();
            if (n == 0) {
                System.out.println(0);
                continue;
            }
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            Map<Integer, Integer> map = new HashMap<>();
            int left = 0, max = 0;
            map.put(nums[0], 0);
            for (int i = 1; i < n; i++) {
                if (left <= map.getOrDefault(nums[i], -1)) {
                    max = Math.max(max, i - left);
                    left = map.get(nums[i]) + 1;
                }
                map.put(nums[i], i);
            }
            max = Math.max(max, n - left);
            System.out.println(max);

        }
    }
}
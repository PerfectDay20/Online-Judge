import java.util.*;

class Main {
    private static List<String> list;
    private static int n;
    private static boolean[] choosen;
    private static int[] nums;
    private static Set<Integer> set = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31));


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 1;
        while (sc.hasNextInt()) {
            if (count != 1) {
                System.out.println();
            }
            n = sc.nextInt();
            nums = new int[n + 1];
            choosen = new boolean[n + 1];
            choosen[1] = true;
            nums[1] = 1;
            list = new ArrayList<>();
            solve(2);
            System.out.printf("Case %d:%n", count++);
            list.forEach(System.out::println);
        }
    }

    private static void solve(int t) {
        if (t == n + 1 && set.contains(1 + nums[n])) {
            addToList();
        } else {
            for (int i = 2; i <= n; i++) {
                if (!choosen[i] && set.contains(nums[t - 1] + i)) {
                    choosen[i] = true;
                    nums[t] = i;
                    solve(t + 1);
                    choosen[i] = false;
                }
            }
        }
    }

    private static void addToList() {
        if (nums.length == 1) {
            list.add("1");
        } else if (nums.length == 2) {
            list.add("1 2");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n - 1; i++) {
                sb.append(nums[i]).append(" ");
            }
            sb.append(nums[n]);
            list.add(sb.toString());
        }
    }

}
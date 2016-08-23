import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            boolean[] flag = new boolean[n];
            int old = sc.nextInt();
            for (int i = 0; i < n - 1; i++) {
                int t = sc.nextInt();
                int diff = Math.abs(t - old);
                if (diff < n) {
                    flag[diff] = true;
                }
                old = t;
            }
            System.out.println(varify(flag));
        }
    }

    private static String varify(boolean[] flag) {
        for(int i = 1; i < flag.length; i++) {
            if (!flag[i]) {
                return "Not jolly";
            }
        }
        return "Jolly";
    }
}
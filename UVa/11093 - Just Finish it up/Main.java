import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int t = 0; t < cases; t++) {
            int n = sc.nextInt();
            int[] p = new int[n], q = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                q[i] = sc.nextInt();
            }
            if (Arrays.stream(p).sum() - Arrays.stream(q).sum() < 0) {
                System.out.printf("Case %d: Not possible%n", t + 1);
            } else {
                int sum = 0,start = 0;
                for (int i = 0; i < n; i++) {
                    sum += p[i] - q[i];
                    if (sum < 0) {
                        sum = 0;
                        start = i + 1;
                    }
                }
                System.out.printf("Case %d: Possible from station %d%n", t + 1, start + 1);
            }
        }
    }


}
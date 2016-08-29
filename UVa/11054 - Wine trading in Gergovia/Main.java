import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            long count = 0;
            int now = 0;
            for (int i = 0; i < n; i++) {
                count += Math.abs(now);
                now += sc.nextInt();
            }
            System.out.println(count);
        }
    }
}
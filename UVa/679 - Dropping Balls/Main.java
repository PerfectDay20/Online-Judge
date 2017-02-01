import java.util.Scanner;

/**
 * Created by ZZ on 17/2/1.
 */
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int j = 0; j < n; j++) {
            int D = sc.nextInt(), I = sc.nextInt() - 1, ans = 1;
            for (int i = 0; i < D - 1; i++, I >>= 1) {
                ans = ((I & 1) == 1) ? ans * 2 + 1 : ans * 2;
            }
            System.out.println(ans);
        }
    }
}

import java.util.Scanner;
//LIS and LDS, not plus 1, but width
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int count = 0;
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] h = new int[n];
            int[] w = new int[n];
            for (int j = 0; j < n; j++) {
                h[j] = sc.nextInt();
            }
            for (int j = 0; j < n; j++) {
                w[j] = sc.nextInt();
            }
            int inc = LIS(h, w);
            int dec = LDS(h, w);
            if (inc >= dec) {
                System.out.printf("Case %d. Increasing (%d). Decreasing (%d).\n", ++count, inc, dec);
            } else {
                System.out.printf("Case %d. Decreasing (%d). Increasing (%d).\n", ++count, dec, inc);
            }

        }
    }

    static int LIS(int[] h, int[] w) {
        int max = 0;
        int[] ans = new int[h.length];
        for (int i = 0; i < h.length; i++) {
            for (int j = 0; j < i; j++) {
                if (h[j] < h[i]) {
                    ans[i] = Math.max(ans[i], ans[j]);
                }
            }
            ans[i] += w[i];
            max = Math.max(max, ans[i]);
        }
        return max;
    }

    static int LDS(int[] h, int[] w) {
        int max = 0;
        int[] ans = new int[h.length];
        for (int i = 0; i < h.length; i++) {
            for (int j = 0; j < i; j++) {
                if (h[j] > h[i]) {
                    ans[i] = Math.max(ans[i], ans[j]);
                }
            }
            ans[i] += w[i];
            max = Math.max(max, ans[i]);
        }
        return max;
    }
}
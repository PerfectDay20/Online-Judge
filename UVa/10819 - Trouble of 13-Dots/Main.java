import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[] p = new int[n+1];
            int[] f = new int[n+1];
            for (int i = 1; i <= n; i++) {
                p[i] = sc.nextInt();
                f[i] = sc.nextInt();
            }
            m = m > 1800 ? m + 200 : m;
            int[] temp = new int[m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = m; j >= 1; j--) {
                    if (j < p[i]) {
                        temp[j] = temp[j];
                    } else {
                        temp[j] = Math.max(temp[j], temp[j - p[i]] + f[i]);
                    }
                }
            }
            if (m > 2000 && m <= 2200) {
                if (temp[m] != temp[m - 200]) {
                    int t = 1800;
                    while (t <= m && temp[t] != temp[m]) {
                        t++;
                    }
                    if (t <= 2000) {
                        System.out.println(temp[m - 200]);
                        continue;
                    }
                }
            }
            System.out.println(temp[m]);
        }

    }
}
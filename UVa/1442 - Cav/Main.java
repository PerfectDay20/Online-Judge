import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int t = 0; t < cases; t++) {
            int n = sc.nextInt();
            int[] p = new int[n];
            int[] s = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                s[i] = sc.nextInt();
            }
            int[] left = new int[n], right = new int[n];
            int level = s[0];
            for (int i = 0; i < n; i++) {
                level = p[i] > level ? p[i] : level;
                level = s[i] < level ? s[i] : level;
                left[i] = level;
            }
            level = s[n - 1];
            for (int i = n - 1; i >= 0; i--) {
                level = p[i] > level ? p[i] : level;
                level = s[i] < level ? s[i] : level;
                right[i] = level;
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                count += Math.min(left[i], right[i]) - p[i];
            }
            System.out.println(count);
        }
    }


}

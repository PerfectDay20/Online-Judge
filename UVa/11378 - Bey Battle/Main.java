import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Main {
    private static int[][] p;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();

            p = new int[n][2];
            for (int i = 0; i < n; i++) {
                p[i][0] = sc.nextInt();
                p[i][1] = sc.nextInt();
            }
            Arrays.sort(p, Comparator.comparing(d -> d[0]));
//            int min = divide(0, n - 1);
            int min = sweep();
            System.out.println(min);

        }
    }

    private static int sweep() {
        int n = p.length, min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n && p[j][0] < p[i][0] + min; j++) {
                min = Math.min(min, dis(p[i][0], p[i][1], p[j][0], p[j][1]));
            }
        }
        return min;
    }


    private static int divide(int left, int right) {
        if (left == right) {
            return Integer.MAX_VALUE;
        }
        if (left + 1 == right) {
            return dis(p[left][0], p[left][1], p[right][0], p[right][1]);
        }
        int mid = (left + right) >>> 1;
        int d1 = divide(left, mid);
        int d2 = divide(mid + 1, right);
        int d = Math.min(d1, d2);
        for (int i = mid; i >= left && p[i][0] >= p[mid][0] - d; i--) {
            int x = p[i][0], y = p[i][1];
            for (int j = mid + 1; j <= right && p[j][0] <= x + d; j++) {
                int z = p[j][0], w = p[j][1];
                if (x <= z && z <= x + d && y - d <= w && w <= y + d) {
                    d = Math.min(d, dis(x, y, z, w));
                }
            }
        }
        return d;
    }

    private static int dis(int x1, int y1, int x2, int y2) {
        return Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1));
    }
}
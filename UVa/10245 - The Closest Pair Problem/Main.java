import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Main {
    private static double[][] p;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            p = new double[n][2];
            for (int i = 0; i < n; i++) {
                p[i][0] = sc.nextDouble();
                p[i][1] = sc.nextDouble();
            }
            Arrays.sort(p, Comparator.comparing(d -> d[0]));
            double min = divide(0, n - 1);

            if (min >= 10000) {
                System.out.println("INFINITY");
            } else {
                System.out.printf("%.4f%n", min);
            }
        }
    }

    private static double divide(int left, int right) {
        if (left == right) {
            return 20000;
        }
        if (left + 1 == right) {
            return dis(p[left][0], p[left][1], p[right][0], p[right][1]);
        }
        int mid = (left + right) >>> 1;
        double d1 = divide(left, mid);
        double d2 = divide(mid + 1, right);
        double d = Math.min(d1, d2);
        for (int i = mid; i >= left && p[i][0] >= p[mid][0] - d; i--) {
            double x = p[i][0], y = p[i][1];
            for (int j = mid + 1; j <= right && p[j][0] <= x + d; j++) {
                double z = p[j][0], w = p[j][1];
                if (x <= z && z <= x + d && y - d <= w && w <= y + d) {
                    d = Math.min(d, dis(x, y, z, w));
                }
            }
        }
        return d;
    }

    private static double dis(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
}
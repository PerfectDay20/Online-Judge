import java.util.Scanner;

public class Main {
    private static double EPS = 1e-6;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble(), y = sc.nextDouble(), r = sc.nextDouble();
        int xl = (int) Math.ceil(x - r);
        int xr = (int) Math.floor(x + r);
        int maxX = 0, maxY = 0;
        double maxDis = 0;
        for (int i = xl; i <= xr; i++) {
            double d = Math.sqrt(r * r - (i - x) * (i - x));
            int yl = (int) Math.ceil(y - d);//the small y correspond to x
            int yr = (int) Math.floor(y + d);//the large y correspond to x
            if (yl > yr) {
                continue;
            }
            double dis = (i - x) * (i - x) + (yl - y) * (yl - y);//compare the small y
            if (dis - maxDis > EPS) {
                maxX = i;
                maxY = yl;
                maxDis = dis;
            } else if (Math.abs(dis - maxDis) < EPS) {
                if (i > maxX) {
                    maxX = i;
                    maxY = yl;
                } else if (i == maxX && yl > maxY) {
                    maxY = yl;
                }
            }

            dis = (i - x) * (i - x) + (yr - y) * (yr - y);//compare the large y
            if (dis - maxDis > EPS) {
                maxX = i;
                maxY = yr;
                maxDis = dis;
            } else if (Math.abs(dis - maxDis) < EPS) {
                if (i > maxX) {
                    maxX = i;
                    maxY = yr;
                } else if (i == maxX && yr > maxY) {
                    maxY = yr;
                }
            }
        }
        System.out.println(maxX + " " + maxY);
    }
}

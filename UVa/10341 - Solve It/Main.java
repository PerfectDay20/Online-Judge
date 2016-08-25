import java.util.Scanner;

class Main{
    private static int p,q,r,s,t, u;
    private static double EPS = 1e-8;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            p = sc.nextInt();
            q = sc.nextInt();
            r = sc.nextInt();
            s = sc.nextInt();
            t = sc.nextInt();
            u = sc.nextInt();
            double left = 0, right = 1;
            if (f(left) * f(right) > 0) {
                System.out.println("No solution");
                continue;
            }
            //bisection
//            while (left + EPS < right) {
//                double mid = (left + right) / 2;
//                if (f(left) * f(mid) <= 0) {
//                    right = mid;
//                } else {
//                    left = mid;
//                }
//            }
//            System.out.printf("%.4f%n", (left + right) / 2);

            //Newton's method
            if (f(0) == 0) {
                System.out.println("0.0000");
            } else {
                double ans = 0.5;
                while (true) {
                    double temp = helper(ans);
                    if (Math.abs(temp - ans) < EPS) {
                        System.out.printf("%.4f%n", ans);
                        break;
                    }
                    ans = temp;
                }
            }


        }
    }

    private static double f(double x) {
        return p * Math.exp(-x) + q * Math.sin(x) + r * Math.cos(x) + s * Math.tan(x) + t * x * x + u;
    }
    //the derivative of f()
    private static double fd(double x) {
        return -p * Math.exp(-x) + q * Math.cos(x) - r * Math.sin(x) + s / Math.cos(x) / Math.cos(x) + 2 * t * x;
    }

    private static double helper(double x) {

        return x - f(x) / fd(x);
    }


}
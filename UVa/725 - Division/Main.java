import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isFirst = true;
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            //print new line between cases
            if (!isFirst) {
                System.out.println();
            }
            isFirst = false;

            boolean found = false;
            for (int i = 1234; i * n < 100000; i++) {
                if (check(i, i * n)) {
                    found = true;
                    System.out.printf("%d / %05d = %d%n", i * n, i, n);
                }
            }
            if (!found) {
                System.out.printf("There are no solutions for %d.%n", n);
            }
        }
    }

    private static boolean check(int a, int b) {
        int mask = (1 << 10) - 1;
        if (a < 10000) {
            mask--;
        }
        while (a > 0) {
            mask &= ~(1 << (a % 10));
            a /= 10;
        }
        while (b > 0) {
            mask &= ~(1 << (b % 10));
            b /= 10;
        }
        return mask == 0;
    }


}
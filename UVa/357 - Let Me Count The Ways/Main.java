import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        downTop();
        //downTop2();
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            long ans = change[n];
            if (ans == 1) {
                System.out.printf("There is only 1 way to produce %d cents change.\n", n);
            } else {
                System.out.printf("There are %d ways to produce %d cents change.\n", ans, n);
            }
            //System.out.println(test[test.length - 1][n]);
        }
    }

    static int[] coin = {1, 5, 10, 25, 50};
    static long[] change = new long[30001];
    static void downTop() {//use O(N) space
        long[] temp = new long[change.length];
        change[0] = 1;
        for (int i = 0; i < coin.length; i++) {
            for (int j = 1; j < change.length; j++) {
                if (j - coin[i] >= 0) {
                    change[j] = temp[j] + change[j - coin[i]];
                } else {
                    change[j] = temp[j];
                }
            }
            long[] temp1 = temp;
            temp = change;
            change = temp1;
            change[0] = 1;
        }
        change = temp;
    }

    static long[][] test = new long[coin.length + 1][30001];
    static void downTop2() {//Use O(N2) space
        for (int i = 0; i < test.length; i++) {
            test[i][0] = 1;
        }
        for (int i = 1; i < test.length; i++) {
            for (int j = 1; j < test[0].length; j++) {
                if (j - coin[i-1] >= 0) {
                    test[i][j] = test[i - 1][j] + test[i][j - coin[i-1]];
                } else {
                    test[i][j] = test[i - 1][j];
                }
            }
        }
    }
}
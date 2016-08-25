import java.util.Scanner;

class Main {
    private static char[][] cs,color;
    private static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            n = sc.nextInt();
            sc.nextLine();
            cs = new char[n][n];
            color = new char[n][n];
            for (int j = 0; j < n; j++) {
                String s = sc.nextLine();
                for (int k = 0; k < n; k++) {
                    cs[j][k] = s.charAt(k);
                }
            }
            int count = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (flood(j, k)) {
                        count++;
                    }
                }
            }
            System.out.printf("Case %d: %d%n", i + 1, count);
        }
    }

    private static boolean flood(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n || cs[x][y] == '.' || color[x][y] == '!') {
            return false;
        }
        boolean flag = cs[x][y] == 'x';
        color[x][y] = '!';
        return flag | flood(x + 1, y) | flood(x, y + 1) | flood(x - 1, y) | flood(x, y - 1);
    }
}
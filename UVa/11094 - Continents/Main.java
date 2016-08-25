import java.util.Scanner;

class Main{
    private static int[][] cs;
    private static int[][] color;
    private static int land,m,n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            m = sc.nextInt(); n = sc.nextInt();
            sc.nextLine();
            cs = new int[m][n];
            color = new int[m][n];
            for (int i = 0; i < m; i++) {
                String s = sc.nextLine();
                for (int j = 0; j < n; j++) {
                    cs[i][j]= s.charAt(j);
                }
            }
            int x = sc.nextInt(), y = sc.nextInt();
            land = cs[x][y];

            //flood initial continent to 1
            flood(x, y, 1);
            int max = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (cs[i][j] == land && color[i][j] == 0) {
                        max = Math.max(max, flood(i, j, 1));
                    }
                }
            }
            System.out.println(max);

        }
    }

    private static int flood(int x, int y, int k) {
//        x = x == -1 ? m - 1 : x;
        y = y == -1 ? n - 1 : y;
//        x = x == m ? 0 : x;
        y = y == n ? 0 : y;

        if (x < 0 || x >= m || cs[x][y] != land || color[x][y] != 0) {
            return 0;
        }
        color[x][y] = k;
        int sum = 1;
        sum += flood(x + 1, y, k) + flood(x, y + 1, k) + flood(x - 1, y, k) + flood(x, y - 1, k);
        return sum;
    }
}
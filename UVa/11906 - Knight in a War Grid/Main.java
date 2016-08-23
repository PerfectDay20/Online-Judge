import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main{
    private static int[][] nums;
    private static boolean[][] reachable;
    private static int r, c;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            r = sc.nextInt(); c = sc.nextInt();
            int m = sc.nextInt(), n = sc.nextInt(), w = sc.nextInt();
            nums = new int[r][c];
            reachable = new boolean[r][c];

            for (int j = 0; j < w; j++) {
                nums[sc.nextInt()][sc.nextInt()] = 1;
            }

            //the step length
            int[] x, y;
            if (m == n) {
                x = new int[]{m, m, -m, -m};
                y = new int[]{n, -n, n, -n};
            } else if (m * n == 0) {
                m = m + n;
                n = 0;
                x = new int[]{m, -m, 0, 0};
                y = new int[]{0, 0, m, -m};
            } else {
                x = new int[]{m, m, -m, -m, n, -n, n, -n};
                y = new int[]{n, -n, n, -n, m, m, -m, -m};
            }

            //BFS mark reach
            Deque<int[]> queue = new ArrayDeque<>();
            reachable[0][0] = true;
            queue.add(new int[]{0, 0});
            while (!queue.isEmpty()) {
                int[] head = queue.remove();
                for (int j = 0; j < x.length; j++) {
                    int a = head[0] + x[j], b = head[1] + y[j];
                    if (isValid(a, b) && nums[a][b] != 1 && !reachable[a][b]) {
                        reachable[a][b] = true;
                        queue.add(new int[]{a, b});
                    }
                }
            }

            //count odd and even
            int odd = 0, even = 0;
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    if (reachable[j][k]) {
                        int count = 0;
                        for (int l = 0; l < x.length; l++) {
                            int a = j + x[l], b = k + y[l];
                            if (isValid(a, b) && reachable[a][b]) {
                                count++;
                            }
                        }
                        if ((count & 1) == 1) {
                            odd++;
                        } else {
                            even++;
                        }
                    }

                }
            }
            System.out.printf("Case %d: %d %d%n", i + 1, even, odd);
        }
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }
}
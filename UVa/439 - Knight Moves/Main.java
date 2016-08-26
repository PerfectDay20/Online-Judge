import java.util.*;

class Main {
    private static int[] h = {-2, -2, -1, -1, 1, 1, 2, 2};
    private static int[] v = {1, -1, 2, -2, 2, -2, 1, -1};
    private static boolean[][] flag;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            flag = new boolean[8][8];
            String s = sc.nextLine();
            String[] ss = s.split(" ");
            int x = s.charAt(0) - 'a', y = s.charAt(1) - '1', z = s.charAt(3) - 'a', w = s.charAt(4) - '1';
            Deque<int[]> queue = new ArrayDeque<>();
            flag[x][y] = true;
            queue.add(new int[]{x, y});
            int count = 0;
            boolean notFind = true;
            while (notFind) {
                count++;
                int size = queue.size();
                for (int k = 0; k < size; k++) {
                    int[] head = queue.remove();
                    if (head[0] == z && head[1] == w) {
                        notFind = false;
                        break;
                    }
                    for (int i = 0; i < 8; i++) {
                        int m = head[0] + h[i], n = head[1] + v[i];
                        if (isValid(m, n)) {
                            flag[m][n] = true;
                            queue.add(new int[]{m, n});
                        }
                    }
                }
            }
            System.out.printf("To get from %s to %s takes %d knight moves.%n", ss[0], ss[1], count - 1);
        }
    }

    private static boolean isValid(int x, int y) {
        return !(x < 0 || x >= 8 || y < 0 || y >= 8 || flag[x][y]);
    }


}
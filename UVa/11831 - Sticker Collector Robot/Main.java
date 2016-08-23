import java.util.Scanner;

class Main{
    private static char[][] nums;
    private static int n,m,s,count;
    private static int[] loc;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            n = sc.nextInt(); m = sc.nextInt(); s = sc.nextInt();

            sc.nextLine();
            if (n == 0) {
                return;
            }

            //find the start point
            loc = new int[3];


            nums = new char[n][m];
            for (int i = 0; i < n; i++) {
                String s = sc.nextLine();
                for (int j = 0; j < m; j++) {
                    nums[i][j] = s.charAt(j);
                    if ("NLSO".contains("" + nums[i][j])) {
                        loc[0] = i;
                        loc[1] = j;
                        loc[2] = "NLSO".indexOf("" + nums[i][j]);
                    }
                }
            }
            String order = sc.nextLine();


            //start moving
            count = 0;
            for (int i = 0; i < s; i++) {
                char c = order.charAt(i);
                if (c == 'D') {
                    loc[2] = (loc[2] + 1) % 4;
                } else if (c == 'E') {
                    loc[2] = (loc[2] + 3) % 4;
                } else {//move forward
                    switch (loc[2]) {
                        case 0:
                            move(loc[0] - 1, loc[1]);
                            break;
                        case 1:
                            move(loc[0], loc[1] + 1);
                            break;
                        case 2:
                            move(loc[0] + 1, loc[1]);
                            break;
                        case 3:
                            move(loc[0], loc[1] - 1);
                            break;
                        default:
                    }
                }
            }
            System.out.println(count);

        }
    }

    private static void move(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m || nums[x][y] == ('#')) {
            return;
        }
        if (nums[x][y] == '*') {
            count++;
            nums[x][y] = '.';
        }
        loc[0] = x;
        loc[1] = y;
    }

}
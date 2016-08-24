import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        for (int i = 0; i < s; i++) {
            int d = sc.nextInt(), n = sc.nextInt();
            int[][] nums = new int[1025][1025];
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt(), y = sc.nextInt(), t = sc.nextInt();
                for (int k = x - d; k <= x + d; k++) {
                    for (int l = y - d; l <= y + d; l++) {
                        if (k >= 0 && k < 1025 && l >= 0 && l < 1025) {
                            nums[k][l] += t;
                        }
                    }
                }
            }
            int mx = 0, my = 0, mt = 0;
            for (int j = 0; j < nums.length; j++) {
                for (int k = 0; k < nums[0].length; k++) {
                    if (nums[j][k] > mt) {
                        mt = nums[j][k];
                        mx = j;
                        my = k;
                    }
                }
            }
            System.out.printf("%d %d %d%n", mx, my, mt);
        }
    }

}
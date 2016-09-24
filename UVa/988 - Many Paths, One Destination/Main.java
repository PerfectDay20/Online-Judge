import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isFirstCase = true;
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            sc.nextLine();
            int[] path = new int[n];
            path[0] = 1;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                String[] ss = sc.nextLine().split(" ");
                int[] temp = new int[ss.length];
                for (int j = 0; j < ss.length; j++) {
                    temp[j] = Integer.parseInt(ss[j]);
                }
                if (temp[0] == 0) {
                    ans += path[i];
                } else {
                    for (int j = 1; j < ss.length; j++) {
                        path[temp[j]] += path[i];
                    }
                }
            }

            if (!isFirstCase) {
                System.out.println();
            }
            System.out.println(ans);
            isFirstCase = false;
        }
    }
}
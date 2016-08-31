import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int m = sc.nextInt(), n = sc.nextInt();
            if (m == 0) {
                return;
            }
            sc.nextLine();
            String s = sc.nextLine();
            boolean[] notRemain = new boolean[m];

            for (int i = 0, j = 1;j < m && n > 0; ) {
                if (notRemain[i]) {
                    i++;
                } else if (i == j) {
                    j++;
                } else if (s.charAt(i) < s.charAt(j)) {
                    notRemain[i] = true;
                    n--;
                    while (i > 0 && notRemain[i]) {
                        i--;
                    }
                } else {
                    i++;
                }

            }
            for (int i = m - 1; i >= 0 && n > 0; i--) {
                if (!notRemain[i]) {
                    notRemain[i] = true;
                    n--;
                }
            }


            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                if (!notRemain[i]) {
                    sb.append(s.charAt(i));
                }
            }
            System.out.println(sb.toString());
        }
    }
}
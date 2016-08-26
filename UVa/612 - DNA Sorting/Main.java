import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Main{
    private static char[] cs, temp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int n = sc.nextInt(), m = sc.nextInt();
            sc.nextLine();
            String[] ss = new String[m];
            for (int j = 0; j < m; j++) {
                ss[j] = sc.nextLine();
            }
            Arrays.sort(ss, Comparator.comparing(Main::inversionIndex));
            for (String s : ss) {
                System.out.println(s);
            }
            if (i != M - 1) {
                System.out.println();
            }
        }
    }

    private static int inversionIndex(String s) {
        cs = s.toCharArray();
        temp = new char[s.length()];
        return helper(0, s.length() - 1);
    }

    private static int helper(int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = (left + right) >>> 1;
        int count = 0;
        count += helper(left, mid) + helper(mid + 1, right);
        int i = left, j = mid + 1, index = left;
        while (i <= mid && j <= right) {
            if (cs[i] <= cs[j]) {
                temp[index++] = cs[i++];
            } else {
                count += mid - i + 1;
                temp[index++] = cs[j++];
            }
        }
        while (i <= mid) {
            temp[index++] = cs[i++];
        }
        while (j <= right) {
            temp[index++] = cs[j++];
        }
        System.arraycopy(temp, left, cs, left, right - left + 1);
        return count;
    }
}
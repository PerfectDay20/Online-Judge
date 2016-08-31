import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int z = 0; z < n; z++) {
            String s = sc.nextLine(), t = sc.nextLine();
            int s1 = 0, s0 = 0, t1 = 0, t0 = 0, n1 = 0, n0 = 0, sq = 0;

            int size = s.length();
            for (int i = 0; i < size; i++) {
                char c = s.charAt(i);
                if (c == '1') {
                    s1++;
                } else if (c == '0') {
                    s0++;
                } else {
                    sq++;
                }
                if (t.charAt(i) == '1') {
                    t1++;
                } else {
                    t0++;
                }
            }
            n1 = t1 - s1;
            n0 = t0 - s0;
            if (n1 < 0) {
                System.out.printf("Case %d: -1%n", z + 1);
                continue;
            }
            int count = 0;
            char[] cs = s.toCharArray();

            for (int i = 0; i < size && n0 < 0; i++) {
                if (cs[i] == '0' && t.charAt(i) == '1') {
                    cs[i] = '1';
                    n0++;
                    n1--;
                    count++;
                }
            }
            for (int i = 0; i < size; i++) {
                if (cs[i] == '?') {
                    if (t.charAt(i) == '0') {
                        if (n0 > 0) {
                            n0--;
                            cs[i] = '0';
                        } else {
                            n1--;
                            cs[i] = '1';
                        }
                    } else {
                        if (n1 > 0) {
                            n1--;
                            cs[i] = '1';
                        } else {
                            n0--;
                            cs[i] = '0';
                        }
                    }
                }
            }
            count += sq;
            count *= 2;
            for (int i = 0; i < size; i++) {
                if (cs[i] != t.charAt(i)) {
                    count++;
                }
            }

            System.out.printf("Case %d: %d%n", z + 1, count / 2);
        }
    }
}
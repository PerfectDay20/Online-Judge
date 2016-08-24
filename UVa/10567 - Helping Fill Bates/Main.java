import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int q = Integer.parseInt(sc.nextLine());
        List<Integer>[] list = process(s);
        for (int i = 0; i < q; i++) {
            int start = -1, end = -1, now = 0;
            String query = sc.nextLine();
            for (int j = 0; j < query.length(); j++, now++) {
                char c = query.charAt(j);
                int index = getIndex(c);
                now = Collections.binarySearch(list[index], now);//find next index of char c
                if (now < 0) {//the next item in list is the index
                    now = -now - 1;
                    if (now == list[index].size()) {//no next item
                        break;
                    }
                }
                now = list[index].get(now);//'now' is the index of the s
                if (start == -1) {//mark start index
                    start = now;
                }
                if (j == query.length() - 1) {//mark end index
                    end = now;
                }

            }
            if (end == -1) {
                System.out.println("Not matched");
            } else {
                System.out.printf("Matched %d %d%n", start, end);
            }
        }
    }

    private static List<Integer>[] process(String s) {
        List<Integer>[] list = new List[52];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0, n = s.length(); i < n; i++) {
            list[getIndex(s.charAt(i))].add(i);
        }
        return list;
    }

    private static int getIndex(char c) {
        if ('a' <= c && c <= 'z') {
            return c - 'a';
        } else {
            return 26 + c - 'A';
        }
    }
}
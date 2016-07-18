import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//same with UVa 00481
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(sc.readLine());
        sc.readLine();
        for (int i = 0; i < t; i++) {
            List<Integer> list = new ArrayList<>();

            String s = sc.readLine();
            while (s != null && s.length() > 0) {
                list.add(Integer.parseInt(s));
                s = sc.readLine();
            }

            List<Integer> LIS = new ArrayList<>();
            int[] id = new int[list.size() + 1];
            int[] pre = new int[list.size() + 1];
            Arrays.fill(pre, -1);
            int maxID = -1;

            for (int j = 0; j < list.size(); j++) {
                int index = Collections.binarySearch(LIS, list.get(j));
                if (index < 0) {
                    index = -index - 1;
                }
                if (index == LIS.size()) {
                    LIS.add(list.get(j));
                    maxID = j;
                } else {
                    LIS.set(index, list.get(j));
                }
                id[index] = j;
                if (index == 0) {
                    pre[j] = -1;
                } else {
                    pre[j] = id[index - 1];
                }
            }
            System.out.println("Max hits: " + LIS.size());
            reconstruct(list, pre, maxID);
            if (i != t - 1) {
                System.out.println();
            }
        }
    }

    static void reconstruct(List<Integer> list, int[] pre, int maxID) {
        Deque<Integer> stack = new LinkedList<>();
        while (maxID != -1) {
            stack.push(list.get(maxID));
            maxID = pre[maxID];
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
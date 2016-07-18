import java.io.IOException;
import java.util.*;

//O(N2) method will OLE, use O(nlogk)
//sort doll width from small to large, height large to small, then use LIS
class Main{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] doll = new int[n][2];
            for (int j = 0; j < n; j++) {
                doll[j][0] = sc.nextInt();
                doll[j][1] = sc.nextInt();
            }
            Arrays.sort(doll, (d1, d2) -> d1[0] == d2[0] ? d1[1] - d2[1] : d2[0] - d1[0]);
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int index = findUpper(list, doll[j][1]);
                if (index < 0) {
                    index = -index - 1;
                }
                if (index == list.size()) {
                    list.add(doll[j][1]);
                } else {
                    if (list.get(index) == doll[j][1]) {
                        index++;
                    }
                    if (index == list.size()) {
                        list.add(doll[j][1]);
                    } else {
                        list.set(index, doll[j][1]);
                    }
                }
            }
            System.out.println(list.size());
        }
    }

    static int findUpper(List<Integer> list, int k) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (list.get(mid) <= k) {
                left = mid + 1;
            } else if (list.get(mid) > k) {
                right = mid;
            }
        }
        return left;
    }
}
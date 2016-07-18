import java.io.IOException;
import java.util.*;
// the normal O(N2) method will get a TLE, so use this O(nlogk) method, use a List to record the smallest ending value of all length i
class Main{
    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            list.add(sc.nextInt());
        }
        int size = list.size();
        int[] LISid = new int[size + 1];// the list item id, used to create LISpre
        int[] LISpre = new int[size + 1];// the pre item id, used to create final output LIS
        int maxId = 0, max = 0;// record the last item
        List<Integer> LIS = new ArrayList<>();// record the smallest ending
        for (int i = 0; i < size; i++) {
            int index = Collections.binarySearch(LIS, list.get(i));
            if (index < 0) {// get insert position
                index = -index - 1;
            }

            if (index == LIS.size()) {//insert into LIS
                LIS.add(list.get(i));
            } else {
                LIS.set(index, list.get(i));
            }

            LISid[index] = i;// record id

            if (index == 0) {// record pre item
                LISpre[i] = -1;
            } else {
                LISpre[i] = LISid[index - 1];
            }

            if (index >= max) {// record last item
                max = index;
                maxId = i;
            }
        }
        System.out.println(LIS.size());
        System.out.println("-");
        reconstruct(list, LISpre, maxId);
    }

    static void reconstruct(List<Integer> list, int[] LISpre, int maxId) {// print the LIS
        Deque<Integer> stack = new LinkedList<>();
        while (maxId != -1) {
            stack.push(list.get(maxId));
            maxId = LISpre[maxId];
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
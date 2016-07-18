import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//typical LIS problem
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Elephant> list = new ArrayList<>();
        int i = 0;
        String s = br.readLine();
        while (s != null && s.length() > 0) {
            String[] ss = s.split(" ");
            list.add(new Elephant(++i, Integer.parseInt(ss[0]), Integer.parseInt(ss[1])));
            s = br.readLine();
        }
        list.sort(Comparator.comparingInt(Elephant::getWeight));
        int[] temp = new int[list.size()];
        int[] pos = new int[list.size()];
        Arrays.fill(pos, -1);
        int maxID = -1, max = 0;
        for (int j = 0; j < list.size(); j++) {
            for (int k = 0; k < j; k++) {
                Elephant e1 = list.get(k);
                Elephant e2 = list.get(j);
                if (e1.weight < e2.weight && e1.IQ > e2.IQ) {
                    if (temp[k] > temp[j]) {
                        pos[j] = k;
                        temp[j] = temp[k];
                    }
                }
            }
            temp[j]++;
            if (temp[j] > max) {
                max = temp[j];
                maxID = j;
            }
        }
        System.out.println(max);
        reconstruct(pos, list, maxID);
    }

    static void reconstruct(int[] pos, List<Elephant> list, int maxID) {
        Deque<Integer> stack = new LinkedList<>();
        while (maxID != -1) {
            stack.push(list.get(maxID).order);
            maxID = pos[maxID];
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
class Elephant{
    int order;
    int weight;
    int IQ;

    public Elephant(int order, int weight, int IQ) {
        this.order = order;
        this.weight = weight;
        this.IQ = IQ;
    }

    public int getWeight() {
        return weight;
    }
}
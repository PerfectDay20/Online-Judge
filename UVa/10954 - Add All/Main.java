import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                return;
            }
            int count = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>(n);
            for (int i = 0; i < n; i++) {
                pq.add(sc.nextInt());
            }
            for (int i = 0; i < n - 1; i++) {
                int a = pq.remove(), b = pq.remove();
                count += a + b;
                pq.add(a + b);
            }
            System.out.println(count);
        }
    }
}
import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            if (i != 0) {
                System.out.println();
            }
            int n = sc.nextInt();
            int[] a = new int[n], b = new int[n], c = new int[n], d = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = sc.nextInt();
                b[j] = sc.nextInt();
                c[j] = sc.nextInt();
                d[j] = sc.nextInt();
            }
            Map<Integer, Integer> map1 = new HashMap<>();
            Map<Integer, Integer> map2 = new HashMap<>();
            for (int k = 0; k < n; k++) {
                for (int l = 0; l < n; l++) {
                    map1.put(a[k] + b[l], map1.getOrDefault(a[k] + b[l], 0) + 1);
                }
            }
            for (int k = 0; k < n; k++) {
                for (int l = 0; l < n; l++) {
                    map2.put(c[k] + d[l], map2.getOrDefault(c[k] + d[l], 0) + 1);
                }
            }

            long count = 0;
            for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
                int key = entry.getKey(), value = entry.getValue();
                count += value * map2.getOrDefault(-key, 0);
            }
            System.out.println(count);
        }
    }




}
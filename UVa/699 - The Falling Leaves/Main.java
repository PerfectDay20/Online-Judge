import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<>();
        int caseNum = 1;
        while (sc.hasNextInt()) {


            check(sc, 0, map);
            if (map.size() == 0) {
                continue;
            }

            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int t : map.keySet()) {
                min = Math.min(min, t);
                max = Math.max(max, t);
            }
            StringBuilder sb = new StringBuilder();
            for (int i = min; i <= max; i++) {
                sb.append(map.get(i));
                if (i != max) {
                    sb.append(" ");
                }
            }

            System.out.printf("Case %d:%n%s%n%n", caseNum++, sb);

            map.clear();
        }
    }

    private static void check(Scanner sc, int pos, Map<Integer, Integer> map) {
        int val = sc.nextInt();
        if (val == -1) {
            return;
        }
        map.put(pos, map.getOrDefault(pos, 0) + val);
        check(sc, pos - 1, map);
        check(sc, pos + 1, map);
    }


}

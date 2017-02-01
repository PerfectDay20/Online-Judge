import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by ZZ on 17/2/1.
 */
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pattern pattern = Pattern.compile("\\(.*\\)");
        List<String> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();

        while (sc.hasNext(pattern)) {
            String next = sc.next(pattern);
            if (next.equals("()")) {
                boolean isComplete = true;
                list.sort(Comparator.comparing(String::length).thenComparing(String::compareTo));

                if (!list.get(0).equals("")) {
                    isComplete = false;
                }
                for (int i = 1, length = list.size(); i < length && isComplete; i++) {
                    String s = list.get(i);
                    if (s.equals(list.get(i - 1)) || !map.containsKey(s.substring(0, s.length() - 1))) {
                        isComplete = false;
                    }
                }

                if (isComplete) {
                    StringBuilder sb = new StringBuilder();
                    for (String s : list) {
                        if (sb.length() != 0) {
                            sb.append(" ");
                        }
                        sb.append(map.get(s));
                    }
                    System.out.println(sb);
                } else {
                    System.out.println("not complete");
                }
                map.clear();
                list.clear();
            } else {
                int index = next.indexOf(",");
                String val = next.substring(1, index), dir = next.substring(index + 1, next.length() - 1);
                map.put(dir, val);
                list.add(dir);
            }
        }
    }

}

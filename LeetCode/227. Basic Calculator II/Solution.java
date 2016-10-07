import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().calculate1("5+2 2/2"));

    }

    public int calculate1(String s) {
        int num = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        char sign = '+';
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (Character.isDigit(cs[i])) {
                num = num * 10 + Character.getNumericValue(cs[i]);
            }
            if (!Character.isDigit(cs[i]) && cs[i] != ' ' || i == cs.length - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else {
                    stack.push(stack.pop() / num);
                }
                num = 0;
                sign = cs[i];
            }
        }
        int sum = 0;
        for (int n : stack) {
            sum += n;
        }
        return sum;
    }
    public int calculate(String s) {
        char[] cs = s.replace(" ", "").toCharArray();
        int first = 0;
        List<String> list = new LinkedList<>();
        for (int i = 0; i < cs.length; i++) {
            if (!Character.isDigit(cs[i])) {
                list.add(new String(cs, first, i - first));
                list.add("" + cs[i]);
                first = i + 1;
            }
        }
        list.add(new String(cs, first, cs.length - first));
        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            String temp = iterator.next();
            if (temp.equals("*")) {
                process(iterator, "*");
            }
            if (temp.equals("/")) {
                process(iterator, "/");
            }
        }
        iterator = list.listIterator();
        while (iterator.hasNext()) {
            String temp = iterator.next();
            if (temp.equals("+")) {
                process(iterator, "+");
            }
            if (temp.equals("-")) {
                process(iterator, "-");
            }
        }
        return Integer.parseInt(list.get(0));
    }

    private void process(ListIterator<String> iterator, String s) {
        iterator.previous();
        int a = Integer.parseInt(iterator.previous());
        iterator.remove();
        iterator.next();
        iterator.remove();
        int b = Integer.parseInt(iterator.next());
        switch (s) {
            case "*":
                iterator.set("" + a * b);
                break;
            case "/":
                iterator.set("" + a / b);
                break;
            case "+":
                iterator.set("" + (a + b));
                break;
            default:
                iterator.set("" + (a - b));
                break;
        }
    }
}
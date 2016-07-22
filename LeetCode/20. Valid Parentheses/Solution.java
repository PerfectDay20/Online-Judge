import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        if (s == null) {
            return true;
        }
        char[] c = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < c.length; i++) {
            switch (c[i]) {
                case '(':
                case '[':
                case '{':
                    stack.push(c[i]);
                    break;
                case ')':
                    if (stack.empty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.empty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.empty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                default:

            }
        }
        return stack.empty();
    }
}
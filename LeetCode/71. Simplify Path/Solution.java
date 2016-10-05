import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public String simplifyPath(String path) {
        int i = 0, j = path.length() - 1;
        while (i < j && path.charAt(i) == '/') {
            i++;
        }
        while (i < j && path.charAt(j) == '/') {
            j--;
        }
        path = path.substring(i, j + 1);
        String[] ss = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String s : ss) {
            if (s.length() == 0||s.equals(".")) {
                continue;
            } else if (s.equals("..")) {
                if (stack.size() > 0) {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append("/").append(stack.removeLast());
        }
        return sb.length() > 0 ? sb.toString() : "/";
    }
}
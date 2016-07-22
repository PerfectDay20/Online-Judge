import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();
        if (n < 1) {
            return ans;
        }
        ans.add("()");
        for (int i = 2; i <= n ; i++) {
            int size = ans.size();
            for (int j = 0; j < size; j++) {
                StringBuilder s = new StringBuilder(ans.remove(0));
                int index = s.lastIndexOf("(");//add "()" after the last "(", to the end
                for (int k = index + 1; k <= s.length(); k++) {
                    StringBuilder temp = new StringBuilder(s);
                    temp.insert(k, "()");
                    ans.add(temp.toString());
                }
            }
        }
        return ans;
    }


    public List<String> generateParenthesis2(int n) {
        List<String> list = new ArrayList<String>();
        backtrace(list, "", 0, 0, n);
        return list;
    }

    public void backtrace(List<String> list, String str, int open, int close, int max){

        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max)
            backtrace(list, str+"(", open+1, close, max);
        if(close < open)
            backtrace(list, str+")", open, close+1, max);
    }
}
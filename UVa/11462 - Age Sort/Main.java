import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                return;
            }
            int[] bucket = new int[100];
            String[] ss = br.readLine().split(" ");

            for (int i = 0; i < n; i++) {
                bucket[Integer.parseInt(ss[i])]++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 100; i++) {
                while (bucket[i]-- > 0) {
                    sb.append(i).append(" ");
                }
            }
            System.out.println(sb.deleteCharAt(sb.length() - 1).toString());

        }
    }
}
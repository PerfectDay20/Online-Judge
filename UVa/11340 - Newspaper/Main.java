import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(bf.readLine());
            Map<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < k; j++) {
                String[] ss = bf.readLine().split(" ");
                map.put(ss[0].charAt(0), Integer.parseInt(ss[1]));
            }
            int m = Integer.parseInt(bf.readLine());
            int sum = 0;
            for (int j = 0; j < m; j++) {
                String s = bf.readLine();
                for (int l = 0, size = s.length(); l < size; l++) {
                    sum += map.getOrDefault(s.charAt(l), 0);
                }
            }
            System.out.printf("%.2f$%n", sum / 100.0);
        }
    }

}
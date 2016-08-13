import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] degree = new int[n + 1];
        for (int i = 0; i < 2 * m; i++) {
            degree[sc.nextInt()]++;
        }
        int odd = 0;//odd degree nodes must less than 2
        for (int i : degree) {
            if ((i & 1) == 1) {
                odd++;
            }
        }
        System.out.println(odd <= 2 ? "Full" : "Part");
    }
}
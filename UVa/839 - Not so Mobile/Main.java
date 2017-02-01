import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseNum = sc.nextInt();
        for (int i = 0; i < caseNum; i++) {
            if (i != 0) {
                System.out.println();
            }
            System.out.println(check(sc) < 0 ? "NO" : "YES");
        }
    }

    private static int check(Scanner sc) {
        int wl = sc.nextInt(), dl = sc.nextInt(), wr = sc.nextInt(), dr = sc.nextInt();
        if (wl == 0) {
            wl = check(sc);
        }
        if (wr == 0) {
            wr = check(sc);
        }

        if (wl < 0 || wr < 0 || wl * dl != wr * dr) {
            return -1;
        }
        return wl + wr;
    }


}

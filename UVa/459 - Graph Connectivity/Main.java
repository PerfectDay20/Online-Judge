import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main {
    private static boolean[][] mat;
    private static boolean[] visited;
    private static int n;

    public static void main(String[] args) {//use union find or graph traversal
//        Scanner sc = new Scanner(System.in);
//        int t = Integer.parseInt(sc.nextLine());
//        sc.nextLine();
//        for (int k = 0; k < t; k++) {
//            n = sc.nextLine().charAt(0) - 'A' + 1;
//            mat = new boolean[n][n];
//            visited = new boolean[n];
//            String s = sc.nextLine();
//            while (s.length() > 0) {
//                int a = s.charAt(0) - 'A', b = s.charAt(1) - 'A';
//                mat[a][b] = mat[b][a] = true;
//                if (sc.hasNextLine()) {
//                    s = sc.nextLine();
//                } else {
//                    s = "";
//                }
//            }
//            int count = 0;
//            for (int i = 0; i < n; i++) {
//                if (!visited[i]) {
//                    count++;
//                    dfs(i);
//                }
//            }
//            if (k != 0) {
//                System.out.println();
//            }
//            System.out.println(count);
//        }
        unionFind();
    }

    private static void dfs(int i) {
        visited[i] = true;
        for (int j = 0; j < n; j++) {
            if (mat[i][j] && !visited[j]) {
                dfs(j);
            }
        }
    }

    //use union find
    private static int[] p, rank;

    private static void unionFind() {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        sc.nextLine();
        for (int k = 0; k < t; k++) {
            int n = sc.nextLine().charAt(0) - 'A' + 1;
            p = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = i;
            }
            String s = sc.nextLine();
            while (s.length() > 0) {
                int a = s.charAt(0) - 'A', b = s.charAt(1) - 'A';
                union(a, b);
                if (sc.hasNextLine()) {
                    s = sc.nextLine();
                } else {
                    s = "";
                }
            }
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.add(getSet(i));
            }

            if (k != 0) {
                System.out.println();
            }
            System.out.println(set.size());
        }
    }

    private static int getSet(int i) {
        if (p[i] != i) {
            p[i] = getSet(p[i]);
        }
        return p[i];
    }


    private static void union(int i, int j) {
        int pi = getSet(i), pj = getSet(j);
        if (pi == pj) {
            return;
        }
        if (rank[pi] > rank[pj]) {
            p[pj] = pi;
        } else {
            p[pi] = pj;
            if (rank[pi] == rank[pj]) {
                rank[pj]++;
            }
        }
    }


}
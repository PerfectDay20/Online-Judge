public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area = (C - A) * (D - B) + (G - E) * (H - F);
        int left = Math.max(B, F);
        int right = Math.min(D, H);
        int up = Math.min(C, G);
        int down = Math.max(A, E);
        if (left < right && up > down) {
            area -= (right - left) * (up - down);
        }
        return area;
    }
}
public class Solution {
    public String getHint(String secret, String guess) {
        int a = 0, b = 0;
        int[] n1 = new int[10];
        int[] n2 = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                a++;
            } else {
                n1[Character.getNumericValue(secret.charAt(i))]++;
                n2[Character.getNumericValue(guess.charAt(i))]++;
            }
        }
        for (int i = 0; i < 10; i++) {
            b += Math.min(n1[i], n2[i]);
        }
        return a + "A" + b + "B";
    }
}
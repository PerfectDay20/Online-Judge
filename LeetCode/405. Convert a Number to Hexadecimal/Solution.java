public class Solution {
    private String s = "0123456789abcdef";
    private String ns = "fedcba9876543210";

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        } else if (num == Integer.MIN_VALUE) {
            return "80000000";
        } else if (num > 0) {
            return getPosHex(num, s).toString();
        } else {
            num = ~num;
            StringBuilder sb = getPosHex(num, ns);
            while (sb.length() < 8) {
                sb.insert(0, "f");
            }
            return sb.toString();
        }
    }


    public StringBuilder getPosHex(int num, String s) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int mod = num % 16;
            sb.insert(0, s.charAt(mod));
            num /= 16;
        }
        return sb;
    }
}
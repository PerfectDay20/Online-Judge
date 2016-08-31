import java.util.Arrays;
import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            String[] names = new String[n];
            sc.nextLine();
            for (int i = 0; i < n; i++) {
                names[i] = sc.nextLine();
            }
            Arrays.sort(names);
            String left = names[n / 2 - 1], right = names[n / 2];
            int i = 0;
            for (i = 0; i < left.length() && i < right.length(); i++) {
                if (left.charAt(i) != right.charAt(i)) {
                    break;
                }
            }
            if (i >= left.length() - 1) {//the last char in left is different or right contains left, return left
                System.out.println(left);
            } else if (i == right.length() - 1) {//the last char in right is different
                if (left.charAt(i) + 1 == right.charAt(i)) {//the difference in char is 1, process the next one
                    i++;
                    while (i < left.length() && left.charAt(i) == 'Z') {//is 'Z', can't add 1, so next char
                        i++;
                    }
                    if (i >= left.length() - 1) {//till the end of left
                        System.out.println(left);
                    } else {//not to the end
                        System.out.println(left.substring(0, i) + (char) (left.charAt(i) + 1));
                    }
                } else {//the difference is not 1, just add 1 to the char of i
                    System.out.println(left.substring(0, i) + (char) (left.charAt(i) + 1));
                }
            } else {//difference in middle
                System.out.println(left.substring(0, i) + (char) (left.charAt(i) + 1));
            }
        }
    }
}
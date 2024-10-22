package string;

import java.util.Scanner;

public class Password {
    public static String solution1(int len, String inputString) {
        String result = "";
        inputString = inputString.replace('#', '1');
        inputString = inputString.replace('*', '0');

        for (int i = 0; i < len; i++) {
            String sliceString = inputString.substring(i * 7, (i + 1) * 7);
            result += String.valueOf((char) Integer.parseInt(sliceString, 2));
        }

        return result;
    }

    public void main() {
        Scanner in=new Scanner(System.in);
        int len = in.nextInt();
        String inputString = in.next();
        System.out.print(solution1(len, inputString));
     }
}

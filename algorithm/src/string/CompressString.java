package string;

import java.util.Scanner;

public class CompressString {
    public static String solution1(String inputString) {
        String result = "";
        inputString += " ";
        int count = 1;

        for (int i = 0; i < inputString.length() -1; i++) {
            if (inputString.charAt(i) != inputString.charAt(i + 1)) {
                result += inputString.charAt(i);
                if (count != 1) {
                    result += count;
                    count = 1;
                }
            } else {
                count++;
            }
        }

        return result;
    }

    public void main() {
        Scanner in=new Scanner(System.in);
        String inputString = (in.next());
        System.out.print(solution1(inputString));
     }
}

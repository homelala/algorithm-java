package string;

import java.util.Scanner;

public class Palindrome {
    public static String solution1(String inputString){
        String reverseString = new StringBuilder(inputString).reverse().toString();
        if (reverseString.equalsIgnoreCase(inputString)){
            return "YES";
        }
        return "NO";
    }

    public static String solution2(String inputString){
        inputString = inputString.toLowerCase();

        for (int i = 0; i < inputString.length() / 2; i++) {
            if (inputString.charAt(i) != inputString.charAt(inputString.length() - i - 1)){
                return "NO";
            }
        }
        return "YES";
    }

    public void main() {
        Scanner in=new Scanner(System.in);
        String inputString = (in.next());
        System.out.println(solution2(inputString));
    }
}

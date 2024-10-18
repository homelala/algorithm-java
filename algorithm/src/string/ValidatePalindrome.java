package string;

import java.util.Scanner;

public class ValidatePalindrome {
    public static String solution1(String inputString){
        inputString = inputString.toLowerCase().replaceAll("[^a-z]", "");
        String reverseString = new StringBuilder(inputString).reverse().toString();
        if(inputString.equals(reverseString)){
            return "YES";
        }
        return "NO";
    }

    public void main() {
        Scanner in=new Scanner(System.in);
        String inputString = (in.nextLine());
        System.out.println(solution1(inputString));
    }
}

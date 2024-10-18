package string;

import java.util.Scanner;

public class ExtractNumber {
    public static int solution1(String inputString){
        StringBuilder result = new StringBuilder();
        for (char c : inputString.toCharArray()){
            if (Character.isDigit(c)){
                result.append(c);
            }
        }
        return Integer.parseInt(result.toString());
    }

    public static int solution2(String inputString){
        int result = 0;
        for (char c : inputString.toCharArray()){
            if (c >= 48 && c <= 57){
                result = result * 10 + (c - 48);
            }
        }
        return result;
    }

    public void main() {
        Scanner in=new Scanner(System.in);
        String inputString = (in.nextLine());
        System.out.println(solution1(inputString));
    }
}

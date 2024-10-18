package string;

import java.util.Scanner;

public class RemoveDuplicateWord {
    public static String solution1(String inputString){
        char[] s = inputString.toCharArray();
        StringBuilder result = new StringBuilder();
        for(char word : s){
            if (result.toString().contains(String.valueOf(word))){
                continue;
            }
            result.append(word);
        }
        return result.toString();
    }

    public static String solution2(String inputString){
        String result = "";
        for (int i =0;i<inputString.length();i++){
            if (inputString.indexOf(inputString.charAt(i)) == i){
                result += inputString.charAt(i);
            }
        }
        return result;
    }

    public void main() {
        Scanner in=new Scanner(System.in);
        String inputString = in.next();
        System.out.println(solution2(inputString));
    }
}

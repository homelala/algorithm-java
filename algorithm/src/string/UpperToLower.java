package string;

import java.util.Scanner;

public class UpperToLower {
    public void main() {
        Scanner in=new Scanner(System.in);
        String input1 = in.next();
        System.out.println(solution(input1));
    }

    public String solution(String str){
        StringBuilder result = new StringBuilder();

        for (int i =0 ; i < str.length(); i++){
            char convert_char =  Character.isLowerCase(str.charAt(i)) ? Character.toUpperCase(str.charAt(i)) : Character.toLowerCase(str.charAt(i));
            result.append(convert_char);
        }

        return result.toString();
    }
}

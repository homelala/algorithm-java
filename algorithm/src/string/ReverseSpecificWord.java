package string;

import java.util.Scanner;

public class ReverseSpecificWord {
    public static String solution1(String inputString){
        char[] s = inputString.toCharArray();
        int lt = 0, rt = s.length - 1;
        while(rt > lt){
            if (!Character.isAlphabetic(s[lt])){
                lt++;
            } else if (!Character.isAlphabetic(s[rt])){
                rt--;
            } else {
                char temp = s[lt];
                s[lt] = s[rt];
                s[rt] = temp;
                lt++;
                rt--;
            }
        }
        return String.valueOf(s);
    }

    public void main() {
        Scanner in=new Scanner(System.in);
        String inputString = in.next();
        System.out.println(solution1(inputString));
    }
}

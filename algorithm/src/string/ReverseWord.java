package string;

import java.util.ArrayList;
import java.util.Scanner;

public class ReverseWord {
    public static ArrayList<String> solution2(ArrayList<String> inputWord){
        ArrayList<String> result = new ArrayList<String>();

        for (String word : inputWord){
            char[] s = word.toCharArray();
            for (int i = 0; i < s.length/2; i++) {
                char temp = s[i];
                s[i] = s[s.length - i - 1];
                s[s.length - i - 1] = temp;
            }
            result.add(String.valueOf(s));
        }

        return result;
    }

    public static ArrayList<String> solution1(ArrayList<String> inputWord){
        ArrayList<String> result = new ArrayList<String>();

        for (String word : inputWord){
            String reverseWord = new StringBuilder(word).reverse().toString();
            result.add(reverseWord);
        }

        return result;
    }

    public void main() {
        Scanner in=new Scanner(System.in);
        int inputCount = in.nextInt();
        ArrayList<String> inputArray = new ArrayList<String>();
        for (int i = 0; i < inputCount; i++) {
            String inputWord = in.next();
            inputArray.add(inputWord);
        }

        for (String word : solution2(inputArray)){
            System.out.println(word);
        }
    }
}

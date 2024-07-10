package string;

import java.util.Scanner;

public class SentenceInWord {
    public void main() {
        Scanner in=new Scanner(System.in);
        String input1 = in.nextLine();
        System.out.println(solution(input1));
    }

    public String solution(String str){
        String[] words = str.split(" ");
        String result = "";
        for (String word : words){
            if (result.length() < word.length()){
                result = word;
            }
        }
        return result;
    }
}


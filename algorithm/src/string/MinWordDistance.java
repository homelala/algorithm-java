package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MinWordDistance {
     public static ArrayList<Integer> solution1(String inputString, Character basisWord){
         ArrayList<Integer> result = new ArrayList<>();
        for (int i =0; i < inputString.length(); i++){
            if (basisWord.equals(inputString.charAt(i))) {
                result.add(0);
            }else{
                int leftIndex = inputString.lastIndexOf(basisWord, i) == -1 ? inputString.length()+1 : Math.abs(i - inputString.lastIndexOf(basisWord, i));
                int rightIndex = inputString.indexOf(basisWord, i) == -1 ? inputString.length()+1 : Math.abs(i - inputString.indexOf(basisWord, i));
                result.add(Math.min(leftIndex, rightIndex));
            }
        }
        return result;
    }

    public static int[] solution2(String inputString, Character c) {
        int[] result = new int[inputString.length()];
        int distance = 1000;

        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) != c) {
                distance++;
                result[i] = distance;

            }else{
                distance = 0;
                result[i] = distance;
            }
        }
        distance = 1000;
        for (int i = inputString.length()-1; i >= 0; i--) {
            if (inputString.charAt(i) != c) {
                distance++;
                result[i] = Math.min(distance, result[i]);
            }else{
                distance = 0;
            }
        }
        return result;
    }

    public void main() {
        Scanner in=new Scanner(System.in);
        String inputString = (in.next());
        Character basisWord = in.next().charAt(0);
        for (int i : solution2(inputString, basisWord)) {
            System.out.print(i + " ");
        }
     }

}

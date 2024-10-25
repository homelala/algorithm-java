package array;

import java.util.Scanner;

public class CalculateScore {
     public static int solution1(int len, int[] inputArray) {
         int result = 0;
         int continuousScore = 0;
         for (int i : inputArray) {
             if (i == 1) {
                 continuousScore++;
                 result += continuousScore;
             }else{
                 continuousScore = 0;
             }
         }

         return result;
    }

    public void main() {
        Scanner in=new Scanner(System.in);
        int len = in.nextInt();
        int[] inputArray = new int[len];
        for (int i = 0; i < len; i++) {
            inputArray[i] = in.nextInt();
        }
        System.out.print(solution1(len, inputArray));

    }
}

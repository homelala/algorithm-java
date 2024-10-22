package array;

import java.util.ArrayList;
import java.util.Scanner;

public class VisibleStudent {
    public static int solution1(int len, int[] inputArray) {
        int result = 0;
        int maxNum = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            if (inputArray[i] > maxNum) {
                result++;
                maxNum = inputArray[i];
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

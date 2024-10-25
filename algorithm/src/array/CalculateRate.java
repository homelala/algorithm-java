package array;

import java.util.Scanner;

public class CalculateRate {
    public static int[] solution1(int len, int[] inputArray) {
        int[] result = new int[len];

        for (int i = 0; i < len; i++) {
            int rate = 1;
            for (int j = 0; j < len; j++) {
                if (inputArray[i] < inputArray[j]) {
                    rate++;
                }
            }
            result[i] = rate;
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
        for (int i : solution1(len, inputArray)) {
            System.out.print(i + " ");
        }
    }
}

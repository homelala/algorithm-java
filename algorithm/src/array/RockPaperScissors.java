package array;

import java.util.Scanner;

public class RockPaperScissors {
    public static String[] solution1(int len, int[] inputArrayA, int[] inputArrayB) {
        String[] result = new String[len];

        for (int i = 0; i < len; i++) {
            if (inputArrayA[i] == inputArrayB[i]) {
                result[i] = "D";
            } else if ((inputArrayA[i] == 1 && inputArrayB[i] == 3) | (inputArrayA[i] == 2 && inputArrayB[i] == 1) | (inputArrayA[i] == 3 && inputArrayB[i] == 2)) {
                result[i] = "A";
            } else {
                result[i] = "B";
            }
        }

        return result;
    }

    public void main() {
        Scanner in=new Scanner(System.in);
        int len = in.nextInt();
        int[] inputArrayA = new int[len];
        for (int i = 0; i < len; i++) {
            inputArrayA[i] = in.nextInt();
        }

        int[] inputArrayB = new int[len];
        for (int i = 0; i < len; i++) {
            inputArrayB[i] = in.nextInt();
        }

        for (String i : solution1(len, inputArrayA, inputArrayB)) {
            System.out.println(i);
        }
    }
}

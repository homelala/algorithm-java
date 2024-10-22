package array;

import java.util.ArrayList;
import java.util.Scanner;

public class PrintMaxNum {
    public static ArrayList<Integer> solution1(int len, int[] inputArray) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(inputArray[0]);

        for (int i = 1; i < len; i++) {
            if (inputArray[i] > inputArray[i-1]) {
                result.add(inputArray[i]);
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
        for (int i : solution1(len, inputArray)) {
            System.out.print(i + " ");
        }
    }
}

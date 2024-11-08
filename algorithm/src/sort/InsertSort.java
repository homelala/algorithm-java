package sort;

import java.util.Scanner;

public class InsertSort {
    public static int[] solution1(int n, int[] inputArray) {
        for (int i = 1; i < n; i++) {
            int minIndex = i;

            for (int k = 0; k < minIndex; k++) {
                if (inputArray[k] > inputArray[i]) {
                    int temp = inputArray[k];
                    inputArray[k] = inputArray[i];
                    inputArray[i] = temp;
               }
            }
        }

        return inputArray;
    }



    public void main() {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int[] inputArray = new int[n];
        for (int i = 0; i < n; i++) {
            inputArray[i] = in.nextInt();
        }

        for (int i : solution1(n, inputArray)) {
            System.out.print(i + " ");
        }
    }
}

package sort;

import java.util.Scanner;

// key 값 전에 위치한 value 중 가장 작은 값을 찾아 바꾸는 것
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

    public static int[] solution2(int n, int[] inputArray) {
        for (int i = 1; i < n; i++) {
            int temp = inputArray[i], k;

            for (k = i - 1; k >= 0; k--) {
                if (inputArray[k] > temp) {
                    inputArray[k + 1] = inputArray[k];
                }else{
                    break;
                }
            }
            inputArray[k] = temp;
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

package sort;

import java.util.Scanner;
/*
key 값 전에 위치한 value 중 가장 작은 값을 찾아 바꾸는 것
9
9 2 1 4 5 8 6 7 3
 */
public class InsertSort1 {
    public static int[] solution1(int n, int[] inputArray) {
        for (int i = 1; i < n; i++) {
            int min = inputArray[i], j;
            for (j = i - 1; j >= 0; j--) {
                if (inputArray[j] > min) {
                    inputArray[j + 1] = inputArray[j];
                }else{
                    break;
                }
            }
            inputArray[j + 1] = min;
        }
        return inputArray;
    }


    public static void main(String[] args) {
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

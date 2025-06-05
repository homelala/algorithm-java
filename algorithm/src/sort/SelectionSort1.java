package sort;
import java.util.Scanner;
/*
가장 작은 값을 찾아 첫번째 위치에 두는 로직 반복
9
9 2 1 4 5 8 6 7 3
 */
public class SelectionSort1 {
    public static int[] solution1(int n, int[] inputArray) {
        for (int i = n - 1; i >= 0; i--) {
            int maxIdx = i;
            for (int j = 0; j < i - 1; j++) {
                if (inputArray[j] > inputArray[maxIdx]) {
                    maxIdx = j;
                }
            }
            swap(i, maxIdx, inputArray);
        }

        return inputArray;
    }

    private static void swap(int a, int b, int[] inputArray) {
        int temp = inputArray[a];
        inputArray[a] = inputArray[b];
        inputArray[b] = temp;
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

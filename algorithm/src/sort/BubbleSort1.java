package sort;
import java.util.Scanner;

/*
인접 값들을 비교하면서 정렬
9
2 9 8 4 5 1 6 7 3
 */
public class BubbleSort1 {
    public static int[] solution1(int n, int[] inputArray) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (inputArray[j] > inputArray[j + 1]) {
                    swap(j, j + 1, inputArray);
                }
            }
        }

        return inputArray;
    }

    private static void swap(int a, int b, int[] inputArray) {
        int temp = inputArray[a];
        inputArray[a] = inputArray[b];
        inputArray[b] = temp;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
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

package sort;
import java.util.Scanner;

//인접 값들을 비교하면서 정렬
// 5 9 3 1 4 2 8 7
public class BubbleSort6 {
    public static int[] solution1(int n, int[] inputArray) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i -1; j++) {
                if (inputArray[j] > inputArray[j + 1]) {
                    swap(j, j + 1, inputArray);
                }
            }
        }

        return inputArray;
    }

    public static void swap(int i, int j, int[] inputArray) {
        int temp = inputArray[i];
        inputArray[i] = inputArray[j];
        inputArray[j] = temp;
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

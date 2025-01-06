package sort;
import java.util.Scanner;

//중요
//인접 값들을 비교하면서 정렬
public class BubbleSort4 {
    public static int[] solution1(int n, int[] inputArray) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (inputArray[j] > inputArray[j + 1]) {
                    swap(inputArray, j, j + 1);
                }
            }
        }
        return inputArray;
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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

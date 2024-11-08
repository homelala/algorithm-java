package sort;
import java.util.Scanner;

// 가장 작은 값을 찾아 첫번째 위치에 두는 로직 반복
public class SelectionSort {
    public static int[] solution1(int n, int[] inputArray) {
        for (int i = 0; i < n-1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (inputArray[minIndex] > inputArray[j]) {
                    minIndex = j;
                }
            }
            int tmp = inputArray[i];
            inputArray[i] = inputArray[minIndex];
            inputArray[minIndex] = tmp;
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

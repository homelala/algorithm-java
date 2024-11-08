package sort;
import java.util.Scanner;

// 가장 작은 값을 찾아 첫번째 위치에 두는 로직 반복
public class SelectionSort2 {
    public static int[] solution1(int n, int[] inputArray) {
        for (int i = 0; i < n; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (inputArray[minIdx] > inputArray[j]) {
                    minIdx = j;
                }
            }
            int temp = inputArray[i];
            inputArray[i] = inputArray[minIdx];
            inputArray[minIdx] = temp;
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

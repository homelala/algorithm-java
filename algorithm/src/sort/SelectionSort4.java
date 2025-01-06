package sort;
import java.util.Scanner;

// 중요
// 가장 작은 값을 찾아 첫번째 위치에 두는 로직 반복
public class SelectionSort4 {
    public static int[] solution1(int n, int[] inputArray) {
        for (int i = n - 1; i >= 0; i--) {
            int maxIdx = i;
            for (int j = 0; j < i; j++) {
                if (inputArray[maxIdx] < inputArray[j]) {
                    maxIdx = j;
                }
            }
            int temp = inputArray[i];
            inputArray[i] = inputArray[maxIdx];
            inputArray[maxIdx] = temp;
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

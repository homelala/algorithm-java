package sort;
import java.util.Scanner;

// 중요
// 가장 작은 값을 찾아 첫번째 위치에 두는 로직 반복
/*
 8
 5 9 3 1 4 2 8 7
 */
public class SelectionSort6 {
    public static int[] solution1(int n, int[] inputArray) {
        for (int i = 0; i < n; i++) {
            int min = inputArray[i], idx = i; // 가장 작은 값 설정
            for (int j = i; j < n; j++) {
                if (min > inputArray[j]) { // 더 작은 값이 있다면 기준 값 변경
                    min = inputArray[j];
                    idx = j;
                }
            }
            swap(i, idx, inputArray);

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

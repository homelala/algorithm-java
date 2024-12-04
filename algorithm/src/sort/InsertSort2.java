package sort;

import java.util.Scanner;

// key 값 전에 위치한 value 중 가장 작은 값을 찾아 바꾸는 것
// 스위칭을 하는 것이 아니라 말그대로 밀어내는 것이 중요
public class InsertSort2 {
    public static int[] solution1(int n, int[] inputArray) {
        for (int i = 1; i < n; i++) {
            int temp = inputArray[i], j;
            for (j = i - 1; j >= 0; j--) {
                if (temp < inputArray[j]) {
                    inputArray[j + 1] = inputArray[j];
                } else {
                    break;
                }
            }
            inputArray[j + 1] = temp;
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

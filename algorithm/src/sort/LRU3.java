package sort;

import java.util.Scanner;

public class LRU3 {
    public static int[] solution1(int s, int n, int[] inputArray) {
        int[] result = new int[s];

        for (int i = 0; i < inputArray.length; i++) {
            int j = -1;
            boolean flag = false;
            for (j = 0; j < result.length; j++) {
                if (result[j] == inputArray[i]) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                for (int k = j; k > 0; k--) {
                    result[k] = result[k - 1];
                }
            } else {
                for (int k = s - 1; k > 0; k--) {
                    result[k] = result[k - 1];
                }
            }
            result[0] = inputArray[i];
        }
        return result;
    }



    public void main() {
        Scanner in=new Scanner(System.in);
        int s = in.nextInt();
        int n = in.nextInt();
        int[] inputArray = new int[n];
        for (int i = 0; i < n; i++) {
            inputArray[i] = in.nextInt();
        }

        for (int i : solution1(s, n, inputArray)) {
            System.out.print(i + " ");
        }
    }
}

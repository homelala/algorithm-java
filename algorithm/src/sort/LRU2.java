package sort;

import java.util.Scanner;

// 다시 풀어보기2
public class LRU2 {
    public static int[] solution1(int s, int n, int[] inputArray) {
        int[] result = new int[s];
        for (int i = 0; i < n; i++) {
            int pos = -1;
            for (int j = 0; j < s; j++) {
                if (result[j] == inputArray[i]) {
                    pos = j;
                    break;
                }
            }
            if (pos == -1) {
                for (int k = s - 1; k > 0; k--) {
                    result[k] = result[k - 1];
                }
            }else{
                for (int k = pos; k > 0; k--) {
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

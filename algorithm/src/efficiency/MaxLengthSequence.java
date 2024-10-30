package efficiency;

import java.util.Scanner;

public class MaxLengthSequence {
    public static int solution1(int len, int k, int[] inputArray) {
        int result = 0, lt = 0, changeCnt = 0;

        for (int rt = 0; rt < len; rt++) {
            if (inputArray[rt] == 0) {
                changeCnt++;
                while (changeCnt > k) {
                    if (inputArray[lt] == 0) {
                        changeCnt--;
                    }
                    lt++;
                }
            }
            result = Math.max(result, rt - lt + 1);
        }

        return result;
    }

    public void main() {
        Scanner in=new Scanner(System.in);
        int len = in.nextInt();
        int k = in.nextInt();
        int[] inputArray = new int[len];
        for (int i = 0; i < len; i++) {
            inputArray[i] = in.nextInt();
        }

        System.out.print(solution1(len, k, inputArray));
    }
}

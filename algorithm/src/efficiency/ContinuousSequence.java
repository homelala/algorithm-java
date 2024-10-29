package efficiency;

import java.util.Scanner;

public class ContinuousSequence {
    public static int solution1(int len, int sumResult, int[] inputArray) {
        int result = 0, sum = 0, rt = 0, lt=0;

        while (rt < len) {
            sum += inputArray[rt];
            if (sum == sumResult) {
                result++;
            }
            while (sum >= sumResult) {
                sum -= inputArray[lt];
                lt++;
                if (sum == sumResult) {
                    result++;
                    break;
                }
            }
            rt++;
        }

        return result;
    }

    public void main() {
        Scanner in=new Scanner(System.in);
        int len = in.nextInt();
        int sumResult = in.nextInt();

        int[] inputArray = new int[len];
        for (int i = 0; i < len; i++) {
            inputArray[i] = in.nextInt();
        }

        System.out.print(solution1(len, sumResult, inputArray));
    }
}

package array;

import java.util.Scanner;

public class GridSum {
    public static int solution1(int len, int[][] inputArray) {
        int result = 0;
        int widthSumValue = 0, heightSumValue = 0, crossSumValue = 0, reverseCrossValue=0;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                widthSumValue += inputArray[i][j];
                heightSumValue += inputArray[j][i];
            }
            int maxValue = Math.max(widthSumValue, heightSumValue);
            if (result < maxValue) {
                result = maxValue;
            }
            widthSumValue = 0;
            heightSumValue = 0;
        }

        for (int i = 0; i < len; i++) {
            crossSumValue += inputArray[i][i];
            reverseCrossValue += inputArray[i][len -i - 1];
        }

        int maxValue = Math.max(crossSumValue, reverseCrossValue);
        if (result < maxValue) {
                result = maxValue;
        }
        return result;
    }

    public void main() {
        Scanner in=new Scanner(System.in);
        int len = in.nextInt();
        int[][] inputArray = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                inputArray[i][j] = in.nextInt();
            }
        }
        System.out.println(solution1(len, inputArray));
    }
}

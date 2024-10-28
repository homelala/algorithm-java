package array;

import java.util.Arrays;
import java.util.Scanner;

public class ClassCaptain {
    public static int solution1(int len, int[][] inputArray) {
        int result = 1;
        int maxCount = 0;
        for (int x = 0; x < len; x++) { //학생 번호
            int equalClassCount = 0;
            for (int i = 0; i < len; i++) { //비교 학생 번호
                for (int j = 0; j < 5; j++) {//학년
                    if (i == x) {
                        continue;
                    }
                    if (inputArray[x][j] == inputArray[i][j]) {
                        System.out.println(inputArray[x][j] + " " + inputArray[i][j]);
                        equalClassCount++;
                        break;
                    }
                }
            }
            if (maxCount < equalClassCount) {
                result = x + 1;
                maxCount = equalClassCount;
            }
        }
        return result;
    }

    public void main() {
        Scanner in=new Scanner(System.in);
        int len = in.nextInt();
        int[][] inputArray = new int[len][5];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 5; j++) {
                inputArray[i][j] = in.nextInt();
            }
        }
        System.out.println(solution1(len, inputArray));
    }
}

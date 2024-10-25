package array;

import java.util.Scanner;

public class Peaks {
    public static int solution1(int len, int[][] inputArray) {
        int result = 0;
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= len; j++) {
                if (inputArray[i][j] > inputArray[i - 1][j] && inputArray[i][j] > inputArray[i][j - 1] && inputArray[i][j] > inputArray[i + 1][j] && inputArray[i][j] > inputArray[i][j + 1]) {
                    result++;
                }
            }
        }
        return result;
    }

    public static int solution2(int len, int[][] inputArray) {
        int result = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                boolean isPeaks = true;
                for (int x = 0; x < 4; x++) {
                    int nx = i - dx[x];
                    int ny = j - dy[x];
                    if (nx >= 0 && ny >= 0 && nx < len && ny < len && inputArray[i][j] < inputArray[nx][ny]) {
                        isPeaks = false;
                        break;
                    }
                }
                if (isPeaks) {
                    result++;
                }
            }
        }
        return result;
    }

    public void main() {
        Scanner in=new Scanner(System.in);
        int len = in.nextInt();
        int[][] inputArray = new int[len+2][len+2];
        // solution 1 적용
//        for (int i = 1; i <= len; i++) {
//            for (int j = 1; j <= len; j++) {
//                inputArray[i][j] = in.nextInt();
//            }
//        }
//        System.out.println(solution1(len, inputArray));

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                inputArray[i][j] = in.nextInt();
            }
        }
        System.out.println(solution2(len, inputArray));
    }
}

package DFSBFS;

import java.util.Scanner;

public class Maze {
    static int result;
    static int[][] array = new int[7][7];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void solution1(int x, int y) {
        if (x == 6 && y==6) {
            result++;
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < 7 && ny < 7) {
                    if (array[nx][ny] == 0) {
                        array[nx][ny] = 2;
                        solution1(nx, ny);
                        array[nx][ny] = 0;
                    }
                }
            }
        }
    }


    public void main() {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                array[i][j] = in.nextInt();
            }
        }
        array[0][0] = 2;
        solution1(0, 0);
        System.out.println(result);
    }
}

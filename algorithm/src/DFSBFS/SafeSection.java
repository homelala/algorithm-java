package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

// 백준 2468 안전영역
public class SafeSection {
    static int n, answer = 1;
    static int[][] array;
    static int[][] check;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void solution1(int deep, int x, int y) {
        for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n && check[nx][ny] == 0 && array[nx][ny] > deep) {
                    check[nx][ny] = 1;
                    solution1(deep, nx, ny);
            }
        }

    }


    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        array = new int[n][n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                max = Math.max(max, num);
                array[i][j] = num;
            }
        }

        for (int i = 1; i <= max; i++) {
            check = new int[n][n];
            int result = 0;
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    if (array[x][y] > i && check[x][y] == 0) {
                        check[x][y] = 1;
                        solution1(i, x, y);
                        result++;
                    }
                }
            }
            answer = Math.max(answer, result);
        }
        System.out.println(answer);
    }
}

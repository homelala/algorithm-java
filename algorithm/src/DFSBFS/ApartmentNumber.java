package DFSBFS;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


// 백준 2667 아파트 단지 번호 붙이기
public class ApartmentNumber {
    static int n;
    static int[][] array;
    static ArrayList<Integer> result = new ArrayList<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static int solution1(int x, int y, int sum) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n && array[nx][ny] == 1) {
                array[nx][ny] = 0;
                sum = solution1(nx, ny, sum + 1);
            }
        }
        return sum;
    }


    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        array = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine(); // 한 줄 읽기
            for (int j = 0; j < n; j++) {
                array[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] == 1) {
                    array[i][j] = 0;
                    result.add(solution1(i, j, 1));
                }
            }
        }
        Collections.sort(result);
        bw.write(result.size() + "");
        bw.newLine();
        for (int i : result) {
            bw.write(i + "");
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

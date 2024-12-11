package DFSBFS;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//백준 1987 알파벳
public class Alphabet {

    static int n, m;
    static Character[][] arr;
    static int answer = 1;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void solution1(int x, int y, String str) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && !str.contains(String.valueOf(arr[nx][ny]))) {
                solution1(nx, ny, str + arr[nx][ny]);
                answer = Math.max(answer, (str + arr[nx][ny]).length());
            }
        }
    }


    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new Character[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j);
            }
        }


        solution1(0, 0, String.valueOf(arr[0][0]));
        bw.write(answer+"");
        bw.flush();
        bw.close();

    }
}

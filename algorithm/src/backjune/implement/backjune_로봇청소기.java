package backjune.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjune_로봇청소기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = 0;
        st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        boolean[][] clean = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while (true) {

            if (!clean[r][c]) {
                answer++;
                clean[r][c] = true;
            }

            boolean moved = false;

            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4;
                int nr = r + dx[d];
                int nc = c + dy[d];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m && board[nr][nc] == 0 && !clean[nr][nc]) {
                    r = nr;
                    c = nc;
                    moved = true;
                    break;
                }
            }

            if (!moved) {
                int back = (d + 2) % 4;
                int nr = r + dx[back];
                int nc = c + dy[back];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m && board[nr][nc] != 1) {
                    r = nr;
                    c = nc;
                } else {
                    break;
                }
            }
        }


        System.out.println(answer);
    }
}

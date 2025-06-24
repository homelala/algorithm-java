package backjune.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjune_피리부는사나이 {
    static char[][] board;
    static boolean[][] visited;
    static boolean[][] finished;
    static int n, m;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        visited = new boolean[n][m];
        finished = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i, j);
            }
        }
        System.out.println(cnt);
    }

    private static void dfs(int x, int y) {
        int dx = x, dy = y;
        if (board[x][y] == 'L') {
            dy = y - 1;
        } else if (board[x][y] == 'D') {
            dx = x + 1;
        } else if (board[x][y] == 'U') {
            dx = x - 1;
        } else {
            dy = y + 1;
        }

        if (!visited[dx][dy]) {
            visited[dx][dy] = true;
            dfs(dx, dy);
        } else {
            if (!finished[dx][dy]) {
                cnt++;
            }
        }
        finished[dx][dy] = true;
    }
}

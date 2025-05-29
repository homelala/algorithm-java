package backjune.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class backjune_적녹색약 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        char[][] board = new char[n][n];
        boolean[][] visited = new boolean[n][n];
        int answer1 = 0;
        int answer2 = 0;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(visited[i][j]) continue;

                answer1++;
                visited[i][j] = true;
                getArea(n, board, visited, i, j, board[i][j]);
            }
        }

        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(visited[i][j]) continue;

                answer2++;
                visited[i][j] = true;
                getRedGreenArea(n, board, visited, i, j, board[i][j]);
            }
        }

        System.out.println(answer1 + " " + answer2);
    }

    private static void getArea(int n, char[][] board, boolean[][] visited, int x, int y, char color) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                if (color == board[nx][ny]) {
                    visited[nx][ny] = true;
                    getArea(n, board, visited, nx, ny, board[nx][ny]);
                }
            }
        }
    }

    private static void getRedGreenArea(int n, char[][] board, boolean[][] visited, int x, int y, char color) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                if (color == 'B' && board[nx][ny] == 'B') {
                    visited[nx][ny] = true;
                    getRedGreenArea(n, board, visited, nx, ny, board[nx][ny]);
                } else if (color != 'B' && board[nx][ny] != 'B') {
                    visited[nx][ny] = true;
                    getRedGreenArea(n, board, visited, nx, ny, board[nx][ny]);
                }
            }
        }
    }
}

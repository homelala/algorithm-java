package backjune.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjune_구슬탈출2 {
    public static class Point{
        int redX;
        int redY;
        int blueX;
        int blueY;
        int count;

        public Point(int redX, int redY, int blueX, int blueY, int count) {
            this.redX = redX;
            this.redY = redY;
            this.blueX = blueX;
            this.blueY = blueY;
            this.count = count;
        }
    }

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        boolean[][][][] visited = new boolean[n][m][n][m];

        int redX = 0, redY = 0, blueX = 0, blueY = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                if (s.charAt(j) == 'R') {
                    redX = i;
                    redY = j;
                    board[i][j] = '.';

                } else if (s.charAt(j) == 'B') {
                    blueX = i;
                    blueY = j;
                    board[i][j] = '.';
                }else{
                    board[i][j] = s.charAt(j);
                }
            }
        }
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(redX, redY, blueX, blueY, 0));

        while (!q.isEmpty()) {
            Point curP = q.poll();

            if (curP.count >= 10) {
                System.out.println(-1);
                return;
            }
            visited[curP.redX][curP.redY][curP.blueX][curP.blueY] = true;

            for (int j = 0; j < 4; j++) {
                int[] nextRed = move(curP.redX, curP.redY, j);
                int[] nextBlue = move(curP.blueX, curP.blueY, j);

                if (board[nextBlue[0]][nextBlue[1]] == 'O') {
                    continue;
                }

                if (board[nextRed[0]][nextRed[1]] == 'O') {
                    System.out.println(curP.count+1);
                    return;
                }

                if (nextRed[0] == nextBlue[0] && nextRed[1] == nextBlue[1]) {
                    int redDist = Math.abs(nextRed[0] - curP.redX) + Math.abs(nextRed[1] - curP.redY);
                    int blueDist = Math.abs(nextBlue[0] - curP.blueX) + Math.abs(nextBlue[1] - curP.blueY);

                    if (redDist > blueDist) {
                        nextRed[0] -= dx[j];
                        nextRed[1] -= dy[j];
                    } else {
                        nextBlue[0] -= dx[j];
                        nextBlue[1] -= dy[j];
                    }
                }

                if (!visited[nextRed[0]][nextRed[1]][nextBlue[0]][nextBlue[1]]) {
                    visited[nextRed[0]][nextRed[1]][nextBlue[0]][nextBlue[1]] = true;
                    q.add(new Point(nextRed[0], nextRed[1], nextBlue[0], nextBlue[1], curP.count + 1));
                }
            }
        }

        System.out.println(-1);
    }

    public static int[] move(int x, int y, int dir) {
        int nx = x, ny = y;
        while (true) {
            int tx = nx + dx[dir];
            int ty = ny + dy[dir];
            if (board[tx][ty] == '#' || board[nx][ny] == 'O') break;
            nx = tx;
            ny = ty;
        }
        return new int[]{nx, ny};
    }
}

package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SangBumBuilding {
    static class Point {
        int h, x, y, sec;

        public Point(int h, int x, int y, int sec) {
            this.h = h;
            this.x = x;
            this.y = y;
            this.sec = sec;
        }
    }

    static int l, r, c;
    static char[][][] array;
    static boolean[][][] visited;
    static int[] dx = {0, 1, 0, -1, 0, 0};
    static int[] dy = {1, 0, -1, 0, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};

    public static int bfs(Point start) {
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        visited[start.h][start.x][start.y] = true;

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 6; i++) {
                int nh = p.h + dh[i];
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nh >= 0 && nx >= 0 && ny >= 0 && nh < l && nx < r && ny < c &&
                    !visited[nh][nx][ny] && array[nh][nx][ny] != '#') {

                    if (array[nh][nx][ny] == 'E') {
                        return p.sec + 1;
                    }

                    visited[nh][nx][ny] = true;
                    q.add(new Point(nh, nx, ny, p.sec + 1));
                }
            }
        }
        return 0;
    }

    public static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (l == 0 && r == 0 && c == 0) break;

            array = new char[l][r][c];
            visited = new boolean[l][r][c];

            Point start = null;

            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    String line = br.readLine();
                    for (int k = 0; k < c; k++) {
                        array[i][j][k] = line.charAt(k);
                        if (array[i][j][k] == 'S') {
                            start = new Point(i, j, k, 0);
                        }
                    }
                }
                br.readLine();
            }

            int result = bfs(start);
            if (result == 0) {
                System.out.println("Trapped!");
            } else {
                System.out.println("Escaped in " + result + " minute(s).");
            }
        }
    }
}

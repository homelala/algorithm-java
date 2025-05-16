package backjune.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjune_4963 {
    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int result = 0;
    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Integer> result = new ArrayList<>();
        while (true) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int total = 0;
            if(w == 0 && h == 0) break;
            int[][] arr = new int[h][w];
            boolean[][] visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (arr[i][j] == 1 && !visited[i][j]) {
                        total++;
                        visited[i][j] = true;
                        bfs(i, j, arr, visited);
                    }
                }
            }

            result.add(total);
        }

        result.forEach(System.out::println);
    }

    private void bfs(int h, int w, int[][] arr, boolean[][] visited) {
        int[] dx = {0, 1, 0, -1, 1, -1, 1, -1};
        int[] dy = {1, 0, -1, 0, 1, -1, -1, 1};
        Queue<Point> q = new LinkedList<>();

        q.add(new Point(h, w));

        while (!q.isEmpty()) {
            Point curP = q.poll();
            int x = curP.x;
            int y = curP.y;

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < arr.length && ny < arr[0].length && !visited[nx][ny] && arr[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny));
                }
            }
        }
    }


}

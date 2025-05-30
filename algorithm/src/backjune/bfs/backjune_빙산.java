package backjune.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjune_빙산 {
    private static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            int cntArea = countArea(arr, n, m);
            if (cntArea >= 2 || cntArea == 0) {
                if(cntArea ==0) answer = 0;
                break;
            }

            int[][] countSea = countSea(arr, n, m);
            answer++;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] -= countSea[i][j];
                }
            }
        }

        System.out.println(answer);
    }

    private static int countArea(int[][] arr, int n, int m) {
        boolean[][] visited = new boolean[n][m];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] > 0 && !visited[i][j]) {
                    cnt++;
                    bfs(arr, i, j, n,m,visited);
                }
            }
        }
        return cnt;
    }

    private static void bfs(int[][] arr, int i, int j, int n, int m, boolean[][] visited) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(i, j));

        while (!q.isEmpty()) {
            Point curP = q.poll();

            for (int x = 0; x < 4; x++) {
                int nx = curP.x + dx[x];
                int ny = curP.y + dy[x];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny]) {
                    if (arr[nx][ny] > 0) {
                        visited[nx][ny] = true;
                        q.add(new Point(nx, ny));
                    }
                }
            }
        }

    }

    private static int[][] countSea(int[][] arr, int n, int m) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] countSea = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != 0) {
                    for (int x = 0; x < 4; x++) {
                        int nx = i + dx[x];
                        int ny = j + dy[x];

                        if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                            if (arr[nx][ny] <= 0) {
                                countSea[i][j]++;
                            }
                        }
                    }
                }
            }
        }
        return countSea;
    }
}

package backjune.bfs;

import org.w3c.dom.Attr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjune_벽부수고이동하기 {
    private static class Point{
        int x;
        int y;
        boolean destroy;
        public Point(int x, int y, boolean destroy) {
            this.x = x;
            this.y = y;
            this.destroy = destroy;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        if (n == 1 && m == 1) {
            System.out.println(1);
            return;
        }

        int answer = -1;
        char[][] arr = new char[n][m];
        boolean[][][] visited = new boolean[n][m][2];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, false));
        visited[0][0][0] = true;

        answer = Math.max(answer, bfs(q, n, m, visited, arr));
        System.out.println(answer);
    }

    private static int bfs(Queue<Point> q, int n, int m, boolean[][][] visited, char[][] arr) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int dis = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            dis++;
            for (int x = 0; x < size; x++) {
                Point curP = q.poll();

                for (int y = 0; y < 4; y++) {
                    int nx = curP.x + dx[y];
                    int ny = curP.y + dy[y];

                    if (nx == n - 1 && ny == m - 1) {
                        return dis;
                    }

                    if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                        if (arr[nx][ny] == '0') {
                            // 벽을 안 부수고 온 경우
                            if (!curP.destroy && !visited[nx][ny][0]) {
                                visited[nx][ny][0] = true;
                                q.add(new Point(nx, ny, false));
                            }
                            // 부수고 온 경우
                            if (curP.destroy && !visited[nx][ny][1]) {
                                visited[nx][ny][1] = true;
                                q.add(new Point(nx, ny, true));
                            }
                        }else{ // 벽을 마주친 경우
                            if (!curP.destroy) {//벽을 부순 적이 없던 경우
                                q.add(new Point(nx, ny, true));
                                visited[nx][ny][1] = true;
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

}

package backjune.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjune_인구이동 {
    static LinkedList<Point> list;
    static class Point{
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
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        while (true) {
            boolean isMove = false;
            boolean[][] visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(visited[i][j]) continue;
                    visited[i][j] = true;
                    int sum = bfs(i, j, visited, l, r, n, arr);
                    if (list.size() > 1) {
                        isMove = true;
                        changeSum(sum, arr);
                    }
                }
            }

            if(!isMove) break;
            answer++;
        }

        System.out.println(answer);

    }

    private static void changeSum(int sum, int[][] arr) {
        int avg = sum / list.size();
        for (Point p : list) {
            arr[p.x][p.y] = avg;
        }
    }

    private static int bfs(int i, int j, boolean[][] visited, int l, int r, int n, int[][] arr) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<Point> q = new LinkedList<>();
        list = new LinkedList<>();
        list.add(new Point(i, j));
        q.add(new Point(i, j));
        int sum = arr[i][j];
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                Point curP = q.poll();

                for (int t = 0; t < 4; t++) {
                    int nx = curP.x + dx[t];
                    int ny = curP.y + dy[t];

                    if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                        int diff = Math.abs(arr[nx][ny] - arr[curP.x][curP.y]);
                        if (diff >= l && diff <= r){
                            q.add(new Point(nx, ny));
                            list.add(new Point(nx, ny));
                            sum += arr[nx][ny];
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }
        return sum;
    }
}

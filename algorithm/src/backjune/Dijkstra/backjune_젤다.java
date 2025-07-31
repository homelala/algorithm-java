package backjune.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class backjune_젤다 {
    public static class Point implements Comparable<Point>{
        int x;
        int y;
        int cost;

        public Point(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int number = 1;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;

            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] cost = new int[n][n];

            for (int i = 0; i < n; i++) {
                Arrays.fill(cost[i], 100_000_000);
            }
            cost[0][0] = arr[0][0];

            PriorityQueue<Point> pq = new PriorityQueue<>();
            pq.add(new Point(0, 0, arr[0][0]));

            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};

            while (!pq.isEmpty()) {
                Point curP = pq.poll();

                if(cost[curP.x][curP.y] < curP.cost) continue;

                for (int i = 0; i < 4; i++) {
                    int nx = curP.x + dx[i];
                    int ny = curP.y + dy[i];

                    if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                        if (cost[nx][ny] > curP.cost + arr[nx][ny]) {
                            pq.add(new Point(nx, ny, curP.cost + arr[nx][ny]));
                            cost[nx][ny] = curP.cost + arr[nx][ny];
                        }
                    }
                }
            }

            System.out.println("Problem " + number + ": " + cost[n - 1][n - 1]);
            number++;
        }
    }
}

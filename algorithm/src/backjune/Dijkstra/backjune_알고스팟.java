package backjune.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class backjune_알고스팟 {
    private static class Point implements Comparable<Point> {
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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        int[][] cost = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(cost[i], 100_000_000);
        }
        cost[0][0] = 0;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(0, 0, 0));
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        while (!pq.isEmpty()) {
            Point curP = pq.poll();

            if(curP.cost > cost[curP.x][curP.y]) continue;

            for (int i = 0; i < 4; i++) {
                int nx = curP.x + dx[i];
                int ny = curP.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    int newCost = cost[curP.x][curP.y] + arr[nx][ny];
                    if (cost[nx][ny] > newCost) {
                        cost[nx][ny] = newCost;
                        pq.add(new Point(nx, ny, newCost));
                    }
                }
            }
        }

        System.out.println(cost[n - 1][m - 1]);
    }
}

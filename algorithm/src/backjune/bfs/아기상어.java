package backjune.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어 {
    private static class Point implements Comparable<Point> {
        int x, y, dist;

        public Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Point o) {
            if (this.dist == o.dist) {
                if (this.x == o.x) return this.y - o.y;
                return this.x - o.x;
            }
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int answer = 0;
        int sharkSize = 2;
        int[][] board = new int[n][n];
        int startX = 0, startY = 0;
        for(int i=0; i<n; ++i) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; ++j) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if(board[i][j] == 9) { // 아기 상어
                    startX = i;
                    startY = j; // 현재 아기상어 위치 저장
                    board[i][j] = 0; // 아기상어의 위치는 지나갈 수 있는 곳이므로 0으로 바꿔준다.
                }
            }
        }
        int cnt = 0;

        while (true) {
            Point nextFish = bfs(n, board, startX, startY, sharkSize);
            if(nextFish == null) break;

            answer += nextFish.dist;
            cnt++;

            if (cnt == sharkSize) {
                cnt = 0;
                sharkSize++;
            }

            startX = nextFish.x;
            startY = nextFish.y;
        }

        System.out.println(answer);
    }

    private static Point bfs(int n, int[][] board, int startX, int startY, int sharkSize) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(startX, startY, 0));
        boolean[][] visited = new boolean[n][n];
        visited[startX][startY] = true;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        while (!pq.isEmpty()) {
            Point curP = pq.poll();
            if (board[curP.x][curP.y] > 0 && board[curP.x][curP.y] < sharkSize) {
                board[curP.x][curP.y] = 0;
                return new Point(curP.x, curP.y, curP.dist);
            }

            for (int j = 0; j < 4; j++) {
                int nx = curP.x + dx[j];
                int ny = curP.y + dy[j];


                if(ny < 0 || nx <0 || ny >= n || nx >= n) continue;
                if(board[nx][ny] > sharkSize) continue;
                if(visited[nx][ny]) continue;

                visited[nx][ny] = true;
                pq.add(new Point(nx, ny, curP.dist + 1));
            }
        }

        return null;
    }

}

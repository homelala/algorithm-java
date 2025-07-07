package backjune.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjune_나이트의이동 {
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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            boolean[][] board = new boolean[i][i];
            int answer = 0;
            st = new StringTokenizer(br.readLine(), " ");
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            Queue<Point> q = new LinkedList<>();
            q.add(new Point(startX, startY));
            board[startX][startY] = true;

            int[] dx = {-2, -1, 1, 2, 2, 1, -2, -1};
            int[] dy = {1, 2, 2, 1, -1, -2, -1, -2};

            while (!q.isEmpty()) {
                int size = q.size();
                for (int s = 0; s < size; s++) {
                    Point curP = q.poll();

                    if (curP.x == endX && curP.y == endY) System.out.println(answer);;

                    for (int j = 0; j < 8; j++) {
                        int nx = curP.x + dx[j];
                        int ny = curP.y + dy[j];

                        if (nx >= 0 && ny >= 0 && nx < i && ny < i && !board[nx][ny]) {
                            q.add(new Point(nx, ny));
                            board[nx][ny] = true;
                        }
                    }
                }
                answer++;
            }
        }
    }
}

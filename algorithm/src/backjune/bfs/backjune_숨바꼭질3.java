package backjune.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class backjune_숨바꼭질3 {
    public static class Point{
        int point;
        int time;

        public Point(int point, int time) {
            this.point = point;
            this.time = time;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int answer = Integer.MAX_VALUE;
        Queue<Point> q = new LinkedList<>();
        int[] visited = new int[100001];
        Arrays.fill(visited, Integer.MAX_VALUE);
        q.add(new Point(n, 0));
        visited[n] = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Point curP = q.poll();
                int curPoint = curP.point;
                int curTime = curP.time;
                if (curPoint == k) {
                    answer = Math.min(answer, curTime);
                }

                if (curPoint - 1 >= 0 && curTime + 1 < visited[curPoint - 1]) {
                    q.add(new Point(curPoint - 1, curTime + 1));
                    visited[curPoint - 1] = curTime + 1;
                }
                if (curPoint + 1 <= 100000 && curTime + 1 < visited[curPoint + 1]) {
                    q.add(new Point(curPoint + 1, curTime + 1));
                    visited[curPoint + 1] = curTime + 1;
                }
                if (curPoint * 2 <= 100000 && curTime < visited[curPoint * 2]) {
                    q.add(new Point(curPoint * 2, curTime));
                    visited[curPoint * 2] = curTime;
                }
            }
        }
        System.out.println(answer);
    }
}

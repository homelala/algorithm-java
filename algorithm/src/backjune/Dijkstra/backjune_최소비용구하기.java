package backjune.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class backjune_최소비용구하기 {
    public static class Point implements Comparable<Point>{
        int end;
        int cost;

        public Point(int end, int cost) {
            this.end = end;
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

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        List<Point>[] list = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[start].add(new Point(end, cost));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Point> q = new PriorityQueue<>();
        q.add(new Point(start, 0));

        while (!q.isEmpty()) {
            Point curP = q.poll();

            if(visited[curP.end]) continue;
            visited[curP.end] = true;

            for (Point next : list[curP.end]) {
                if (distance[next.end] > distance[curP.end] + next.cost) {
                    distance[next.end] = distance[curP.end] + next.cost;
                    q.add(new Point(next.end, distance[next.end]));
                }
            }
        }

        System.out.println(distance[end]);
    }
}

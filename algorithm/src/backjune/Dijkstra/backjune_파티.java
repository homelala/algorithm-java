package backjune.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class backjune_파티 {
    private static class Point implements Comparable<Point>{
        int end;
        int cost;

        public Point(int end, int cost) {
            this.cost = cost;
            this.end = end;
        }

        @Override
        public int compareTo(Point o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int answer = 0;

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

        int[] comeDistance = getCost(m, x, list);

        for (int i = 1; i <= n; i++) {
//            if(i==x) continue;
            int[] goDistance = getCost(n, i, list);

            answer = Math.max(comeDistance[i] + goDistance[x], answer);
        }

        System.out.println(answer);
    }

    private static int[] getCost(int n, int x, List<Point>[] list) {
        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[x] = 0;

        PriorityQueue<Point> q = new PriorityQueue<>();
        q.add(new Point(x, 0));

        while (!q.isEmpty()) {
            Point curP = q.poll();
            if(visited[curP.end]) continue;
            visited[curP.end] = true;

            for (Point p : list[curP.end]) {
                if (distance[curP.end] + p.cost < distance[p.end]) {
                    distance[p.end] = distance[curP.end] + p.cost;
                    q.add(new Point(p.end, distance[p.end]));
                }
            }
        }

        return distance;
    }
}

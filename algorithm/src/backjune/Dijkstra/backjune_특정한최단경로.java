package backjune.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class backjune_특정한최단경로 {
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
        int answer = 0;

        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        List<Point>[] list = new List[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[start].add(new Point(end, cost));
            list[end].add(new Point(start, cost));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] firstDisA = search(n, list, 1);
        int costV1 = firstDisA[v1]; // 1 -> v1
        int costV2 = firstDisA[v2]; // 1 -> v2

        int[] startV1 = search(n, list, v1);
        int[] startV2 = search(n, list, v2);

        costV1 += startV1[v2]; // 1 -> v1 -> v2
        costV2 += startV2[v1]; // 1 -> v2 -> v1

        costV1 += startV2[n]; // 1 -> v1 -> v2 -> last
        costV2 += startV1[n]; // 1 -> v2 -> v1 -> last

        answer = (costV1 >= 200000000 && costV2 >= 200000000) ? -1 : Math.min(costV1, costV2);
        System.out.println(answer);
    }

    private static int[] search(int n, List<Point>[] list, int start) {
        PriorityQueue<Point> q = new PriorityQueue<>();
        q.add(new Point(start, 0));

        int[] distance = new int[n + 1];
        Arrays.fill(distance, 200000000);
        distance[start] = 0;

        boolean[] visited = new boolean[n + 1];
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

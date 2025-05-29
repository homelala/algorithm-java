package backjune.Dijkstra;

import java.io.*;
import java.util.*;

public class backjune_최단경로 {
    private static class Point implements Comparable<Point>{
        int end;
        int cost;

        public Point(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point o1) {
            return this.cost - o1.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        List<Point>[] lists = new List[v + 1];

        for (int i = 1; i <= v; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            lists[start].add(new Point(end, weight));
        }

        boolean[] visited = new boolean[v + 1];
        int[] distance = new int[v + 1];
        Arrays.fill(distance, 100_000_000);

        distance[k] = 0;

        PriorityQueue<Point> q = new PriorityQueue<>();
        q.add(new Point(k, 0));

        while (!q.isEmpty()) {
            Point curP = q.poll();
            if(visited[curP.end]) continue;
            visited[curP.end] = true;

            for (Point p : lists[curP.end]) {
                if (distance[p.end] > distance[curP.end] + p.cost) {
                    distance[p.end] = distance[curP.end] + p.cost;
                    q.add(new Point(p.end, distance[p.end]));
                }
            }
        }

        for (int i = 1; i <= v; i++) {
            if (distance[i] == 100_000_000) {
                bw.write("INF");
            }else{
                bw.write(distance[i] + "");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();

    }
}

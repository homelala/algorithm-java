package backjune.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class backjune_트리의지름 {
    static int[] distance;

    private static class Point{
        int start;
        int end;
        int cost;

        public Point(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        List<Point>[] tree = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            while (true) {
                int end = Integer.parseInt(st.nextToken());
                if (end == -1) {
                    break;
                }

                int cost = Integer.parseInt(st.nextToken());
                tree[start].add(new Point(start, end, cost));
            }
        }

        dfs(n, 1, tree);
        int max = getMax(distance);
        dfs(n, max, tree);
        int answer = getMax(distance);
        System.out.println(distance[answer]);
    }

    private static int getMax(int[] distance) {
        int maxIdx = 1;
        for (int i = 1; i < distance.length; i++) {
            if(distance[maxIdx] < distance[i]) maxIdx = i;
        }
        return maxIdx;
    }

    private static void dfs(int n, int i, List<Point>[] tree) {
        Queue<Point> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        distance = new int[n + 1];
        q.add(new Point(i, 0, 0));
        distance[i] = 0;
        visited[i] = true;

        while (!q.isEmpty()) {
            Point curP = q.poll();
            int start = curP.start;
            int size = tree[start].size();

            for (int j = 0; j < size; j++) {
                int end = tree[start].get(j).end;
                int cost = tree[start].get(j).cost;

                if (!visited[end]) {
                    q.add(new Point(end, 0, curP.cost + cost));
                    distance[end] = curP.cost + cost;
                    visited[end] = true;
                }
            }
        }
    }
}

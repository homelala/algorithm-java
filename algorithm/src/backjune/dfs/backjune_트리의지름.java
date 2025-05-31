package backjune.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class backjune_트리의지름 {
    public static class Point{
        int end;
        int cost;

        public Point(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
    static int answer = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        List<Point>[] lists = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            lists[start].add(new Point(end, cost));
            lists[end].add(new Point(start, cost));
        }

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            visited[i] = true;
            dfs(i, lists, 0, visited);
        }

        System.out.println(answer);
    }

    private static void dfs(int start, List<Point>[] lists, int cost, boolean[] visited) {
        for (Point p : lists[start]) {
            if (visited[p.end]) continue;
            answer = Math.max(answer, cost + p.cost);
            visited[p.end] = true;
            dfs(p.end, lists, cost + p.cost, visited);
            visited[p.end] = false;
        }
    }
}

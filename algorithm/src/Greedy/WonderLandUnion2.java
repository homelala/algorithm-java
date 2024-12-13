package Greedy;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.*;

import static java.lang.System.in;

public class WonderLandUnion2 {
    public static class Point implements Comparable<Point>{
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

    public static int find(int n) {
        if (parent[n] == n) {
            return n;
        }else{
            return parent[n] = find(parent[n]);
        }
    }

    public static boolean union(int x, int y) {
        int fx = find(x);
        int fy = find(y);

        if (fx !=fy) {
            parent[fx] = parent[fy];
        }

        return fx != fy;
    }

    public static void solution1() {
        for (Point p : points) {
            if (union(p.x, p.y)) {
                answer += p.cost;
            }
        }
    }

    static int n, m;
    static int[] parent;
    static ArrayList<Point> points = new ArrayList<>();
    static int answer = 0;

    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            points.add(new Point(a, b, c));
        }
        Collections.sort(points);

        solution1();
        System.out.println(answer);
    }
}

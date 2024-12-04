package Greedy;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 맞혔지만 다시 풀어보기
public class WonderLandUnion {
    public static class Point implements Comparable<Point>{
        int start;
        int end;
        int cost;

        public Point(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(@NotNull WonderLandUnion.Point o) {
            return this.cost - o.cost;
        }
    }

    static int n, m;
    static ArrayList<Point> points = new ArrayList<>();
    static int[] parent;

    public static int find(int a) {
        if (parent[a] == a) {
            return parent[a];
        }else{
            return parent[a] = find(parent[a]);
        }
    }

    public static boolean union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            parent[fb] = fa;
        }

        return fa != fb;
    }

    public static int solution1() {
        int result = 0;
        for (Point point : points) {
            if (union(point.start, point.end)) {
                result += point.cost;
            }
        }
        return result;
    }

    public void main() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            points.add(new Point(a, b, c));
        }
        Collections.sort(points);
        System.out.println(solution1());
    }
}

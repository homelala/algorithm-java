package Greedy;

import org.jetbrains.annotations.NotNull;

import java.util.*;

//다시 풀어보기
public class WonderLandPriorityQueue {
    public static class Point implements Comparable<Point>{
        int start;
        int cost;

        public Point(int start, int cost) {
            this.start = start;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point o) {
            return this.cost - o.cost;
        }
    }

    static int n, m;
    static ArrayList<ArrayList<Point>> points = new ArrayList<>();
    static int[] ch;


    public static int solution1() {
        int result = 0;
        PriorityQueue<Point> q = new PriorityQueue<>();
        q.offer(new Point(1, 0));
        while (!q.isEmpty()) {
            Point tmp = q.poll();
            int tv = tmp.start;
            if (ch[tv] == 0) {
                ch[tv] = 1;
                result += tmp.cost;
                for (Point p : points.get(tv)) {
                    if (ch[p.start] == 0) {
                        q.offer(new Point(p.start, p.cost));
                    }
                }
            }
        }
        return result;
    }

    public void main() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        ch = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            points.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            points.get(a).add(new Point(b, c));
            points.get(b).add(new Point(a, c));
        }

        System.out.println(solution1());
    }
}

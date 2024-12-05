package DFSBFS;

import java.util.ArrayList;
import java.util.Scanner;

// 다시 풀어보기2
public class Pizza2 {
    static int n, m, len, answer = Integer.MAX_VALUE;
    static ArrayList<Point> hs, ps;
    static int[] combi;
    public static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void solution1(int l, int s) {
        if (l == m) {
            int sum = 0;
            for (Point h: hs) {
                int dis = Integer.MAX_VALUE;
                for (int i : combi) {
                    dis = Math.min(dis, Math.abs(h.x - ps.get(i).x) + Math.abs(h.y - ps.get(i).y));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
        }else{
            for (int i = s; i < ps.size(); i++) {
                combi[l] = i;
                solution1(l + 1, s + 1);
            }
        }
    }

    public static void main() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        ps = new ArrayList<>();
        hs = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int a = in.nextInt();
                if (a == 1) {
                    hs.add(new Point(i, j));
                } else if (a == 2) {
                    ps.add(new Point(i, j));
                }
            }
        }
        combi = new int[m];
        solution1(0, 0);
        System.out.println(answer);
    }
}

package DFSBFS;

import java.util.ArrayList;
import java.util.Scanner;

// 다시 풀어보기
public class Pizza {
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
            for (Point h : hs) {
                int dis = Integer.MAX_VALUE;
                for (int i : combi) {
                    dis = Math.min(dis, Math.abs(h.x - ps.get(i).x) + Math.abs(h.y - ps.get(i).y));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
        }else{
            for (int i = s; i < len; i++) {
                combi[l] = i;
                solution1(l + 1, i + 1);
            }
        }
    }

    public static void main() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        hs = new ArrayList<>();
        ps = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int temp = in.nextInt();
                if (temp == 1) {
                    hs.add(new Point(i, j));
                } else if (temp == 2) {
                    ps.add(new Point(i, j));
                }
            }
        }
        len = ps.size();
        combi = new int[m];
        solution1(0, 0);
        System.out.println(answer);
    }
}

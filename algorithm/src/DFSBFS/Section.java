package DFSBFS;

import java.io.*;
import java.util.*;

//백준 2583 영역 구하기
public class Section {
    static class Point {
        int a;
        int b;
        int c;
        int d;

        public Point(int a, int b, int c, int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
    }

    static int n, m, k;
    static ArrayList<Point> points = new ArrayList<>();
    static int[][] arr;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<Integer> sections = new ArrayList<>();

    public static int solution1(int x, int y, int sum) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (arr[nx][ny] == 0) {
                    arr[nx][ny] = 1;
                    sum = solution1(nx, ny, sum+1);
                }
            }
        }
        return sum;
    }


    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            points.add(new Point(x1, y1, x2, y2));
        }

        for (Point p : points) {
            for (int i = p.b; i < p.d; i++) {
                for (int j = p.a; j < p.c; j++) {
                    arr[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    sections.add(solution1(i, j, 1));
                }
            }
        }
        Collections.sort(sections);

        StringBuilder sb = new StringBuilder();
        sb.append(sections.size() + "\n");

        for (int i : sections) {
            sb.append(i + " ");
        }
        bw.write(sb + "");
        bw.flush();
        bw.close();

    }
}

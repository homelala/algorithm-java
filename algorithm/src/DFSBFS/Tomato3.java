package DFSBFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tomato3 {
    static class Node{
        int x;
        int y;
        int h;

        public Node(int h, int x, int y) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }

    static int answer = 0;
    static int n, m, h;
    static int[][][] array;
    static int[][][] date;
    static int[] dx = {0, 1, 0, -1, 0, 0};
    static int[] dy = {1, 0, -1, 0, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};

    public static void solution1(Queue<Node> queue) {
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            for (int i = 0; i < 6; i++) {
                int nx = curNode.x + dx[i];
                int ny = curNode.y + dy[i];
                int nh = curNode.h + dh[i];

                if (nx >= 0 && ny >= 0 && nh >= 0 && nx < m && ny < n && nh < h && array[nh][nx][ny] != -1) {
                    if (array[nh][nx][ny] == 0) {
                        array[nh][nx][ny] = 1;
                        date[nh][nx][ny] = Math.min(date[nh][nx][ny], date[curNode.h][curNode.x][curNode.y] + 1);
                        queue.offer(new Node(nh, nx, ny));
                    }
                }
            }
        }
    }


    public void main() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        h = in.nextInt();
        array = new int[h][m][n];

        for (int z = 0; z < h; z++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    array[z][i][j] = in.nextInt();
                }
            }
        }

        Queue<Node> q = new LinkedList<>();
        date = new int[h][m][n];

         for (int z = 0; z < h; z++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    date[z][i][j] = Integer.MAX_VALUE;
                }
            }
         }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < m; j++) {
                for (int z = 0; z < n; z++) {
                    if (array[i][j][z] == 1) {
                        date[i][j][z] = 0;
                        q.offer(new Node(i, j, z));
                    }
                }
            }
        }

        solution1(q);

        for (int z = 0; z < h; z++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (date[z][i][j] == Integer.MAX_VALUE && array[z][i][j] == 0) {
                        System.out.println(-1);
                        return;
                    } else if (date[z][i][j] != Integer.MAX_VALUE) {
                        answer = Math.max(answer, date[z][i][j]);
                    }
                }
            }
        }

        System.out.println(answer);
    }
}

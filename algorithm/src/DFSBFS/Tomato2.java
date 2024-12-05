package DFSBFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tomato2 {
    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int answer = 0;
    static int n, m;
    static int[][] array;
    static int[][] date;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void solution1(Queue<Node> queue) {
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curNode.x + dx[i];
                int ny = curNode.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    if (array[nx][ny] == 0) {
                        array[nx][ny] = 1;
                        date[nx][ny] = Math.min(date[nx][ny], date[curNode.x][curNode.y] + 1);
                        queue.offer(new Node(nx, ny));
                    }
                }
            }
        }
    }


    public void main() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        array = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = in.nextInt();
            }
        }
        Queue<Node> q = new LinkedList<>();
        date = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                date[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] == 1) {
                    date[i][j] = 0;
                    q.offer(new Node(i, j));
                }
            }
        }
        solution1(q);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (date[i][j] == Integer.MAX_VALUE && array[i][j] == 0) {
                    System.out.println(-1);
                    return;
                } else if (date[i][j] != Integer.MAX_VALUE) {
                    answer = Math.max(answer, date[i][j]);
                }
            }
        }
        System.out.println(answer);
    }
}

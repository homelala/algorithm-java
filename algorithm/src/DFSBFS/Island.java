package DFSBFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Island {
    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static int result = 0;
    static int[][] array;
    static int[] dx = {0, 1, 0, -1, 1, -1, 1, -1};
    static int[] dy = {1, 0, -1, 0, 1, -1, -1, 1};

    public static void solution1(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nx = currentNode.x + dx[i];
                int ny = currentNode.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n && array[nx][ny] != 0) {
                    queue.offer(new Node(nx, ny));
                    array[nx][ny] = 0;
                }
            }
        }
        result++;
    }


    public void main() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        array = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] == 1) {
                    solution1(i, j);
                }
            }
        }
        System.out.println(result);
    }
}

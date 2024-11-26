package DFSBFS;

import java.util.*;

public class MazeMinDistance {
    static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] array = new int[7][7];
    static int[][] dis = new int[7][7];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void solution1(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0));

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = currentNode.x + dx[i];
                int ny = currentNode.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < 7 && ny < 7 && array[nx][ny] == 0) {
                    queue.offer(new Node(nx, ny));
                    array[nx][ny] = 2;
                    dis[nx][ny] = dis[currentNode.x][currentNode.y] + 1;
                }
            }
        }
    }


    public void main() {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                array[i][j] = in.nextInt();
            }
        }
        array[0][0] = 2;
        solution1(0, 0);
        if (dis[6][6] == 0) {
            System.out.println(-1);
        }else{
            System.out.println(dis[6][6]);
        }
    }
}

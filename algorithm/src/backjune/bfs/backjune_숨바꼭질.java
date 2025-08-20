package backjune.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjune_숨바꼭질 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] board = new int[100001];
        boolean[] visited = new boolean[100001];

        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        int answer = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                visited[cur] = true;
                board[cur] = answer;
                if (cur == k) {
                    System.out.println(answer);
                    return;
                } else {
                    if (cur - 1 >= 0 && !visited[cur - 1]) {
                        q.add(cur - 1);
                    }
                    if (cur + 1 <= 100000 && !visited[cur + 1]) {
                        q.add(cur + 1);
                    }
                    if (cur * 2 <= 100000 && !visited[cur * 2]) {
                        q.add(cur * 2);
                    }
                }
            }
            answer++;
        }

        System.out.println(answer);
    }
}

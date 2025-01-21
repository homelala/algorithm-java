package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HideAndFind {
    static int n, k;
    static int[] array;
    static boolean[] visited;
    static int[] dx = {0, 1, 0, -1};

    public static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        int result = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (cur == k) {
                    return result;
                }
                for (int j = 0; j < 4; j++) {
                    int nx = cur + dx[j];

                    if (nx >= 0 && nx < 100001 && !visited[nx]) {
                        visited[nx] = true;
                        q.add(nx);
                    }
                }

                int nx = cur * 2;

                if (nx >= 0 && nx < 100001 && !visited[nx]) {
                    visited[nx] = true;
                    q.add(nx);
                }
            }
            result++;
        }
        return result;
    }

    public static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        array = new int[100001];
        visited = new boolean[100001];

        int result = bfs(n);

        System.out.println(result);
    }
}

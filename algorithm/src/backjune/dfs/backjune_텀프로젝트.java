package backjune.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjune_텀프로젝트 {
    static int[] arr;
    static boolean[] visited;
    static boolean[] finished;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            arr = new int[k + 1];
            visited = new boolean[k + 1];
            finished = new boolean[k + 1];
            cnt = 0;
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 1; j <= k; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int x = 1; x <= k; x++) {
                dfs(x);
            }

            System.out.println(k - cnt);
        }
    }

    private static void dfs(int start) {
        int next = arr[start];
        if (!visited[next]) {
            visited[next] = true;
            dfs(next);
        }else{
            if (!finished[next]) {
                cnt++;
                while (start != next) {
                    cnt++;
                    next = arr[next];
                }
            }
        }

        finished[start] = true;
    }
}

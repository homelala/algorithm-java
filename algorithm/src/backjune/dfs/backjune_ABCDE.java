package backjune.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class backjune_ABCDE {
    static List<Integer>[] arr;
    static boolean[] visited;
    static int n;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new List[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[start].add(end);
            arr[end].add(start);
        }


        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            visited[i] = true;

            dfs(i, 1);
        }

        if (flag) {
            System.out.println(1);
        } else{
            System.out.println(0);
        }
    }

    private static void dfs(int i, int count) {
        if(flag) return;

        if (count == 5) {
            flag = true;
            return;
        }

        for (int f : arr[i]) {
            if(!visited[f]){
                visited[f] = true;
                dfs(f, count + 1);
            }
        }

        visited[i] = false;
    }
}

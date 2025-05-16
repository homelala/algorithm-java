package backjune.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class backjune_1707 {
    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            List<Integer>[] list = new List[v+1];
            int[] color = new int[v + 1];

            for (int x = 0; x < v+1; x++) {
                list[x] = new ArrayList<>();
            }

            for (int x = 0; x < e; x++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list[a].add(b);
                list[b].add(a);
            }

            boolean flag = true;
            for (int x = 1; x < v+1; x++) {
                if(color[x] != 0) continue;

                color[x] = 1;
                flag = bfs(x, list, color);

                if(!flag) break;

            }

            if(flag) result.add("YES");
            else result.add("NO");
        }


        result.forEach(System.out::println);
    }

    private static boolean bfs(int x, List<Integer>[] list, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : list[cur]) {
                if (color[next] == color[cur]) {
                    return false;
                }

                if(color[next] !=0) continue;
                color[next] = color[cur] * -1;
                q.add(next);
            }
        }

        return true;
    }

}


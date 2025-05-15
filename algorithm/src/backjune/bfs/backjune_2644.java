package backjune.bfs;

import java.io.*;
import java.util.*;

public class backjune_2644 {
    boolean flag = false;
    int result = -1;
    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[total + 1];

        HashMap<Integer, ArrayList<Integer>> family = new HashMap<>();
        for (int i = 1; i <= total; i++) {
            family.put(i, new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ArrayList<Integer> listX = family.getOrDefault(x, new ArrayList<>());
            listX.add(y);
            ArrayList<Integer> listY = family.getOrDefault(y, new ArrayList<>());
            listY.add(x);
            family.put(x, listX);
            family.put(y, listY);
        }
        visited[a] = true;
        dfs(a, b, family, 0, visited);

        System.out.println(result);
    }

    private void dfs(int a, int b, HashMap<Integer, ArrayList<Integer>> family, int sum, boolean[] visited) {
        if(flag){
            return;
        }

        if (a == b) {
            flag = true;
            result = sum;
        }else{
            for (int child : family.get(a)) {
                if(visited[child]) continue;

                visited[child] = true;
                dfs(child, b, family, sum + 1, visited);
            }
        }
    }
}

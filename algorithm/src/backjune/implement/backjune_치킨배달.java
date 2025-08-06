package backjune.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class backjune_치킨배달 {
    static ArrayList<int[]> home;
    static ArrayList<int[]> chicken;
    static ArrayList<int[]> selected;
    static boolean[] visited;
    static int m, result=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        home = new ArrayList<>();
        chicken = new ArrayList<>();
        selected = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 2){
                    chicken.add(new int[]{i, j});
                } else if (temp == 1) {
                    home.add(new int[]{i, j});
                }
            }
        }

        visited = new boolean[chicken.size()];
        getDistance(0, 0);

        System.out.println(result);
    }

    private static void getDistance(int depth, int start) {
        if (depth == m) {
            int sum = 0;
            for (int[] h : home) {
                int min = Integer.MAX_VALUE;

                for (int[] s : selected) {
                    int d = Math.abs(h[0] - s[0]) + Math.abs(h[1] - s[1]);
                    min = Math.min(d, min);
                }
                sum += min;
            }
            result = Math.min(result, sum);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                selected.add(chicken.get(i));
                getDistance(depth+1, i+1);
                selected.remove(selected.size() - 1);
                visited[i] = false;
            }
        }

    }


}

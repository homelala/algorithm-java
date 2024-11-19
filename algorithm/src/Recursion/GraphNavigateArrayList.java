package Recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class GraphNavigateArrayList {
    static int n, m, answer = 0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;

    public static int dfs(int v) {
        if (v == m) {
            answer++;
        }else{
            for (int nv : graph.get(v)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    dfs(nv);
                    ch[nv] = 0;
                }
            }
        }

        return answer;
    }


    public void main() {
        Scanner in=new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            graph.get(a).add(b);
        }
        ch[1] = 1;
        System.out.println(dfs(1));

    }
}

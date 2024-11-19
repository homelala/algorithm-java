package Recursion;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GraphNavigate {
    static int n, m, answer = 0;
    static int[][] graph = new int[n + 1][n + 1];
    static int[] ch;

    public static int dfs(int v) {
        if (v == m) {
            answer++;
        }else{
            for (int i = 1; i <= n; i++) {
                if (graph[v][i] == 1 && ch[i] == 0) {
                    ch[i] = 1;
                    dfs(i);
                    ch[i] = 0;
                }
            }
        }

        return answer;
    }


    public void main() {
        Scanner in=new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            graph[a][b] = 1;
        }
        ch[1] = 1;
        System.out.println(dfs(1));

    }
}

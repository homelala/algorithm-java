package Greedy;

import 6. .util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 다시 풀어보기
public class Friend {
    static int[] parent;

    public static int find(int a) {
        if (parent[a] == a) {
            return a;
        }else{
            return parent[a] = find(parent[a]);
        }
    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if(fa !=fb) parent[fa] = fb;
    }

    public void main() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            union(a, b);
        }

        int a = in.nextInt();
        int b = in.nextInt();
        if (find(a) == find(b)) {
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}

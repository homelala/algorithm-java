package DFSBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ConnectCount {
    static int n, m;
    static ArrayList<Integer>[] array;
    static int[] visit;
    static int result = 0;
    public static void solution1(int start) {
        for (int i : array[start]) {
            if (visit[i] == 0) {
                visit[i] = 1;
                solution1(i);
            }
        }
    }


    public void main() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();

        array = new ArrayList[n + 1];
        visit = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            array[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            array[a].add(b);
            array[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            if (visit[i] == 0) {
                visit[i] = 1;
                solution1(i);
                result++;
            }
        }

        System.out.println(result);
    }
}

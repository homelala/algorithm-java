package DFSBFS;

import java.util.Scanner;

//다시 풀어보기
public class GuessSequence {
    static int[] b, p, ch;
    static int n, m;
    static boolean flag = false;
    static int[][] dy;

    public static int getCombination(int n, int m) {
        if (dy[n][m] > 0) {
            return dy[n][m];
        }
        if (n == m || m == 0) {
            return 1;
        }else{
            return dy[n][m] = getCombination(n-1, m-1) + getCombination(n-1, m);
        }
    }

    public static void solution1(int l, int sum) {
        if (flag) {
            return;
        }
        if (l == n) {
            if (sum == m) {
                flag = true;
                for (int x : p) {
                    System.out.print(x + " ");
                }
                System.out.println();
            }
        }else{
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    p[l] = i;
                    solution1(l + 1, sum + (p[l] * b[l]));
                    ch[i] = 0;
                }
            }
        }
    }



    public void main() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        b = new int[n];
        p = new int[n];
        ch = new int[n + 1];
        dy = new int[n + 2][n + 2];
        for (int i = 0; i < n; i++) {
            b[i] = getCombination(n-1, i);
        }
        solution1(0, 0);
    }
}

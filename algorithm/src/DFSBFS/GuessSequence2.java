package DFSBFS;

import java.util.Scanner;

//다시 풀어보기 2
public class GuessSequence2 {
    static int[] b, p, ch;
    static int n, m;
    static boolean flag = false;
    static int[][] dy;

    public static int combi(int s, int l) {
        if (dy[s][l] > 0) {
            return dy[s][l];
        }
        if (l == 0 || s == l) {
            return 1;
        } else {
            return dy[s][l] = combi(s - 1, l - 1) + combi(s - 1, l);
        }
    }

    public static void solution1(int l, int sum) {
        if (flag) {
            return;
        }

        if (l == n) {
            if (sum == m) {
                flag = true;
                for (int num : p) {
                    System.out.print(num+" ");
                }
            }
        }else{
            for (int i = 1; i <=n; i++) {
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
            b[i] = combi(n-1, i);
        }
        solution1(0, 0);
    }
}

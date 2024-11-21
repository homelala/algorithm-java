package DFSBFS;

import java.util.Scanner;

public class CommonCombination {
    static int n, m, result = 0;
    static int[] pm;
    public static void solution1(int l, int k) {
        if (l == m) {
            for (int i : pm) {
                if (i != 0) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
            return;
        }else {
            for (int i = 1; i <= n; i++) {
                pm[l] = i;
                solution1(l + 1, i);
                pm[l] = 0;
            }
        }
    }


    public void main() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        pm = new int[m];
        solution1(0, 0);

    }
}

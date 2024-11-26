package DFSBFS;

import java.util.Scanner;

public class GetCombination {
    static int n, m;
    static int[] result;
    public static void solution1(int l, int s) {
        if (l == m) {
            for (int x : result) {
                System.out.print(x + " ");
            }
            System.out.println();
        }else{
            for (int i = s; i <= n; i++) {
                result[l] = i;
                solution1(l + 1, i+1);
            }
        }
    }


    public void main() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        result = new int[m];
        solution1(0, 1);
    }
}

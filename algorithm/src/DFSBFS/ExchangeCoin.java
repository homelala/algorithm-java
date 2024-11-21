package DFSBFS;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class ExchangeCoin {
    static int n, m = 0;
    static int result = Integer.MAX_VALUE;
    static Integer[] kind;
    public static void solution1(int l, int sum) {
        if (sum > m) {
            return;
        }
        if (result <= l) {
            return;
        }
        if (sum == m) {
            result = Math.min(result, l);
        }else {
            for (int i = 0; i < n; i++) {
                solution1(l + 1, sum + kind[i]);
            }
        }
    }


    public void main() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        kind = new Integer[n];
        for (int i = 0; i < n; i++) {
            kind[i] = in.nextInt();
        }
        Arrays.sort(kind, Collections.reverseOrder());
        m = in.nextInt();
        solution1(0, 0);
        System.out.println(result);
    }
}

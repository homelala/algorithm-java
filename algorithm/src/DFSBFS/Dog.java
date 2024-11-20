package DFSBFS;

import java.util.Arrays;
import java.util.Scanner;

public class Dog {
    static int n, m, result = 0;
    static int[] array;

    public static void solution1(int l, int sum) {
        if (sum > n) {
            return;
        }
        if (l == m) {
            result = Math.max(result, sum);
        }else{
            solution1(l + 1, sum + array[l]);
            solution1(l + 1, sum);
        }
    }


    public void main() {
        Scanner in=new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        array = new int[m];
        for (int i = 0; i < m; i++) {
            array[i] = in.nextInt();
        }
        solution1(0, 0);
        System.out.println(result);

    }
}

package DFSBFS;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Permutation {
    static int n, m = 0;
    static int[] array;
    static int[] pm;
    static int[] ch;
    public static void solution1(int l) {
        if (l == m) {
            for (int i: pm) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }else{
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    pm[l] = array[i];
                    ch[i] = 1;
                    solution1(l + 1);
                    ch[i] = 0;
                }
            }
        }
    }


    public void main() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        pm = new int[m];
        ch = new int[n];
        solution1(0);
    }
}

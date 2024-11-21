package DFSBFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MaxScore {
    static int n, m, result = 0;
    static int[] score, time;
    public static void solution1(int l, int sumScore, int sumTime) {

        if (sumTime > m) {
            return;
        }
        if (l == n) {
            result = Math.max(result, sumScore);
            return;
        }else {
            solution1(l + 1, sumScore + score[l], sumTime + time[l]);
            solution1(l + 1, sumScore, sumTime);
        }
    }


    public void main() {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        score = new int[n];
        time = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = in.nextInt();
            time[i] = in.nextInt();
        }
        solution1(0, 0, 0);
        System.out.println(result);

    }
}

package DP;

import java.util.Scanner;

public class Stairs {
    static int[] dp;

    public static void solution1(int n) {
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
    }


    public void main() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        dp = new int[n + 1];
        solution1(n);
        System.out.println(dp[n]);
    }
}

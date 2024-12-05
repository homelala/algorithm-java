package DP;

import java.util.Scanner;

public class StoneBridge {
    static int[] dp;

    public static void solution1(int n) {
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n+1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
    }


    public void main() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        dp = new int[n + 2];
        solution1(n);
        System.out.println(dp[n+1]);
    }
}

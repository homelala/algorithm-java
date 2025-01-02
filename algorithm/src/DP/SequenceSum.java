package DP;

import java.util.Scanner;

// 1192 연속합
public class SequenceSum {
    static int[] dp;
    static int[] arr;
    public static int solution1(int n) {
        dp[0] = arr[0];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }


    public void main() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        arr = new int[n];
        dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(solution1(n));
    }
}

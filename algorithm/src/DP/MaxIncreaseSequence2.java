package DP;

import java.util.Scanner;

public class MaxIncreaseSequence2 {
    static int[] dp;
    static int[] arr;
    public static int solution1(int n) {
        int answer = 0;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }


    public void main() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        arr = new int[n];
        dp = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(solution1(n));
    }
}

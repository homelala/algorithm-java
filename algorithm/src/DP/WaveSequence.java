package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

//백준 9461 파도반 수열
public class WaveSequence {
    static long[] dp;

    public static long solution1(int n) {
        if (n >= 1) {
            dp[1] = 1;
        }
        if (n >= 2) {
            dp[2] = 1;
        }
        if (n >= 3) {
            dp[3] = 1;
        }
        if (n >= 4) {
            dp[4] = 2;
        }
        if (n >= 5) {
            dp[5] = 2;
        }

        for (int i = 6; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 5];
        }

        return dp[n];
    }


    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] inputArray = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            inputArray[i] = Integer.parseInt(st.nextToken());
        }

        dp = new long[Arrays.stream(inputArray).max().getAsInt() + 1];
        for (int i : inputArray) {
            System.out.println(solution1(i));
        }
    }
}

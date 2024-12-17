package DP;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

//백준 2759 계단 오르기
//다시 풀어보기
public class StairUp {
    static int[] dp;

    public static void solution1(int n, int[] arr) {
        dp[1] = arr[1];

        if (n >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + arr[i - 1], dp[i - 1]) + arr[i];
        }
    }


    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[n + 1];
        solution1(n, arr);
        System.out.println(dp[n]);
    }
}

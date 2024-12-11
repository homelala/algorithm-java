package DP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//1003 백준 피보나치
public class Fibonacci {
    static int[][] dp;
    static int[] arr;

    public static void solution(int maxNum) {
        if (maxNum > 0) {
            dp[1][0] = 0;
            dp[1][1] = 1;
        }

        for (int i = 2; i <= maxNum; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }
    }

    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int maxNum = Arrays.stream(arr).max().getAsInt();

        dp = new int[maxNum + 1][2];
        dp[0][0] = 1;
        dp[0][1] = 0;

        solution(maxNum);


        for (int i : arr) {
            bw.write(dp[i][0] + " " + dp[i][1]);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}

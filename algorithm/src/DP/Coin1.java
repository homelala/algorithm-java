package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 2293 동전1
// 다시 풀어보기
public class Coin1 {
    static int[] dp;
    static int[] inputArray;
    public static long solution1(int n, int m) {
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = inputArray[i]; j <= m; j++) {
                dp[j] = dp[j] + dp[j - inputArray[i]];
            }
        }

        return dp[m];
    }


    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        inputArray = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            inputArray[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[m + 1];
        System.out.println(solution1(n, m));

    }
}

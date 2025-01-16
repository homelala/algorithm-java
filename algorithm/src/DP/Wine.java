package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백준 2156 포도주 시식
public class Wine {
    static int[] dp;
    static int[] inputArray;
    public static int solution1(int n) {
        int result = inputArray[0];
        dp[0] = inputArray[0];

        if (n >= 2) {
            dp[1] = inputArray[0] + inputArray[1];
            result = dp[1];
        }

        if (n >= 3) {
            dp[2] = Math.max(inputArray[0], inputArray[1]) + inputArray[2];
            result = Math.max(dp[1], dp[2]);
        }

        for (int i = 3; i < n; i++) {
            int beforeMax1 = Integer.MIN_VALUE;
            int beforeMax2 = Integer.MIN_VALUE;

            for (int j = i - 2; j >= 0; j--) {
                beforeMax1 = Math.max(dp[j], beforeMax1);
            }
            for (int j = i - 3; j >= 0; j--) {
                beforeMax2 = Math.max(dp[j], beforeMax2);
            }

            dp[i] = Math.max(inputArray[i] + beforeMax1, inputArray[i] + inputArray[i - 1] + beforeMax2);
            result = Math.max(result, dp[i]);
        }

        return result;
    }

    public static int solution2(int n) {
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = inputArray[i];
            } else if (i == 2) {
                dp[i] = inputArray[i] + inputArray[i-1];
            }else{
                dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + inputArray[i], dp[i - 3] + inputArray[i] + inputArray[i - 1]));
            }
        }
        return dp[n];
    }



    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        inputArray = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            inputArray[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n + 1];
        System.out.println(solution2(n));
    }
}

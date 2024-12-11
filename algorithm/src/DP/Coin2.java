package DP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Coin2 {
    static int[] dp;
    static int[] coins;

    public static int solution1(int n, int m) {
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = coins[i]; j <= m; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }

        return dp[m];
    }


    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        coins = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        dp = new int[m + 1];

        bw.write(solution1(n, m)+"");
        bw.flush();
        bw.close();
    }
}

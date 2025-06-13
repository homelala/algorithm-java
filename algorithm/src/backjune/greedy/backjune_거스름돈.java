package backjune.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjune_거스름돈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] dp = new int[100001];
        dp[0] = Integer.MAX_VALUE;
        dp[1] = Integer.MAX_VALUE;
        dp[2] = 1;
        dp[3] = Integer.MAX_VALUE;
        dp[4] = 2;
        dp[5] = 1;
        for (int i = 6; i <= n; i++) {
            dp[i] = Math.min(dp[i - 2], dp[i - 5]) + 1;
        }

        if (dp[n] == Integer.MAX_VALUE) {
            System.out.println(-1);
        }else{
            System.out.println(dp[n]);
        }
    }
}

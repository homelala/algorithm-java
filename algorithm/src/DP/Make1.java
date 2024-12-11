package DP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//1463 백준 1로 만들기
public class Make1 {
    static int[] dp;

    public static void solution(int n) {
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
    }

    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());

        dp = new int[n + 1];
        solution(n);

        bw.write(dp[n]+"");
        bw.flush();
        bw.close();
    }
}

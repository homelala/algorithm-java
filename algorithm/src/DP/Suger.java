package DP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//2839 설탕 문제
public class Suger {
    static int[] dp;

    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());

        dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE-1);
        dp[0] = 0;

        int[] sugers = {3, 5};
        for (int i = 0; i < 2; i++) {
            for (int j = sugers[i]; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - sugers[i]] + 1);
            }
        }
        if (dp[n] >= Integer.MAX_VALUE - 1) {
            bw.write(-1+"");
        }else{
            bw.write(dp[n]+"");
        }
        bw.flush();
        bw.close();
    }
}

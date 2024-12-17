package DP;

import java.io.*;
import java.util.StringTokenizer;

public class MaxScore2 {
    static int[] dp;

    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dp = new int[m + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int score = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            for (int j = m; j >= time; j--) {
                dp[j] = Math.max(dp[j], dp[j - time] + score);
            }
        }

        bw.write(dp[m]+"");
        bw.flush();
        bw.close();
    }
}

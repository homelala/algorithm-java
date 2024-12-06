package DP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//다시 풀어보기
public class MaxScore {
    static int[] dp;

    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dp = new int[m + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for (int j = m; j >= b; j--) {
                dp[j] = Math.max(dp[j], dp[j - b] + a);
            }

        }
        bw.write(dp[m]+"");
        bw.flush();
        bw.close();
    }
}

package DP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//1003 백준 피보나치
public class Fibonacci2 {
    static long[] dp;
    static int n;

    public static long solution(int num) {
        if (num == 0) {
            return 0;
        } else if (num == 1) {
            return 1;
        } else if (num == 2) {
            return 1;
        }

        if (dp[num] > 0) {
            return dp[num];
        }else{
            return dp[num] = solution(num - 1) + solution(num - 2);
        }
    }

    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        dp = new long[n + 1];
        bw.write(solution(n)+ " ");

        bw.flush();
        bw.close();
        br.close();

    }
}

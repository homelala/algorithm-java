package Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

import static java.lang.System.in;

// 백준 숫자 더하기
public class SumNumber {
    public static long solution1(long n) {
        long answer = 1;
        long mid = 1;
        while (true) {
            long sum = (mid * (mid - 1 ))/ 2;
            if (n - sum > mid - 1) {
                answer = mid;
                mid++;
            } else {
                break;
            }
        }
        return answer;
    }


    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());

        bw.write(solution1(n) + "");
        bw.flush();
        bw.close();
        br.close();
    }
}

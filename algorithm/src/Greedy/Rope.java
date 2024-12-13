package Greedy;

import java.io.*;
import java.util.*;

import static java.lang.System.in;

// 백준 로프
public class Rope {

    static Integer[] arr;
    public static int solution1(int n) {
        int cnt = 1, result = arr[0];

        for (int i = 1; i < n; i++) {
            cnt++;
            int minWight = arr[i];

            if (minWight*cnt >  result) {
                result = minWight * cnt;
            }
        }

        return result;
    }


    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, Collections.reverseOrder());

        System.out.println(solution1(n));
    }
}

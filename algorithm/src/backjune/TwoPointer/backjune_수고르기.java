package backjune.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backjune_수고르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        int start = 0, end = 0;
        long answer = arr[n - 1] - arr[0];
        while (start < n && end < n) {
            long diff = arr[end] - arr[start];
            if (diff >= m) {
                start++;
                answer = Math.min(answer, diff);
            } else {
                end++;
            }
        }

        System.out.println(answer);
    }
}

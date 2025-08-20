package backjune.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backjune_랜선자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long[] arr = new long[k];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Long.parseLong(st.nextToken());
        }

        long min = 1;
        long max = Arrays.stream(arr).max().orElse(Long.MIN_VALUE);
        long result = Long.MIN_VALUE;

        while (min <= max) {
            long mid = (min + max) / 2;

            long num = cutting(mid, arr);

            if (num >= n) {
                result = Math.max(result, num);
                min = mid + 1;
            }else{
                max = mid - 1;
            }
        }

        System.out.println(result);

    }

    private static long cutting(long mid, long[] arr) {
        long total = 0;

        for (long l : arr) {
            total += (l / mid);
        }

        return total;
    }
}

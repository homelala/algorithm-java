package backjune.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjune_2467_twoPointer {
    public static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        long min = Long.MAX_VALUE;
        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        int l = 0, r = n - 1;
        long a = 0, b = 0;

        while (l < r) {
            long sum = arr[l] + arr[r];
            if(Math.abs(sum) < min) {
                a = arr[l];
                b = arr[r];
                min = Math.abs(sum);
            }
            if (sum >= 0) {
                r--;
            } else {
                l++;
            }
        }

        System.out.println(a + " " + b);
    }
}

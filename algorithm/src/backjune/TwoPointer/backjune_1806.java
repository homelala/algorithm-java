package backjune.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjune_1806 {
    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        long s = Long.parseLong(st.nextToken());
        int result = Integer.MAX_VALUE;
        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0, length = 0;
        long sum = 0;

        while (left <= n && right <= n) {
            if (sum >= s) {
                result = Math.min(result, length);
                sum -= arr[left];
                length--;
                left++;
            } else {
                sum += arr[right];
                length++;
                right++;
            }
        }

        if(result == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(result);

    }
}

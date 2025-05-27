package backjune.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class backjune_2018 {
    public static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        int result = 0;
        int left = 0, right = 0;
        int sum = 0;

        while (left <= n && right <= n) {
            if (sum == n) {
                result++;
                sum -= arr[left];
                left++;
            } else if (sum < n) {
                sum += arr[right];
                right++;
            } else {
                sum -= arr[left];
                left++;
            }
        }

        System.out.println(result);
    }
}

package backjune.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backjune_세용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine(), " ");
        long[] pick = new long[3];
        long max = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                long sum = arr[left] + arr[right] + arr[i];
                long absSum = Math.abs(sum);

                if (absSum < max) {
                    pick[0] = arr[left];
                    pick[1] = arr[i];
                    pick[2] = arr[right];
                    max = absSum;
                }

                if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        Arrays.sort(pick);
        for (long i : pick) {
            System.out.print(i + " ");
        }
    }
}

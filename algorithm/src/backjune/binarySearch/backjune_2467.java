package backjune.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjune_2467 {
    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        long min = Long.MAX_VALUE;
        long[] arr = new long[n];
        int ml = 0, mr = 0;
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                long sum = arr[i] + arr[mid];

                if (Math.abs(sum) < min) {
                    min = Math.abs(sum);
                    ml = i;
                    mr = mid;
                }

                if (sum < 0) {
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }

        System.out.println(arr[ml] + " " + arr[mr]);

    }
}

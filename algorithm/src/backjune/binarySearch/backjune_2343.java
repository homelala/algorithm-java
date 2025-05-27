package backjune.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backjune_2343 {
    public static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int result = Integer.MAX_VALUE;
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        int max = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max += arr[i];
        }

        int min = Arrays.stream(arr).max().getAsInt();

        while (min <= max) {
            int mid = (min + max) / 2;

            if (divide(arr, n, m, mid) <= m) {
                max = mid - 1;
                result = Math.min(result, mid);
            }else{
                min = mid + 1;
            }
        }

        System.out.println(result);
    }

    private static int divide(int[] arr, int n, int m, int mid) {
        int count = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum + arr[i] > mid) {
                count++;
                sum = arr[i];
            }else{
                sum += arr[i];
            }
        }
        return count;
    }
}

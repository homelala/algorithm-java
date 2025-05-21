package backjune.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backjune_2512 {
    public static int check(int[] arr, int mid, int m) {
        int sum = 0;
        for (int i : arr) {
            if (i < mid) {
                sum += i;
            }else if(i >= mid){
                sum += mid;
            }
        }

        if (sum > m) {
            return -2;
        }
        return sum;
    }
    public static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        int min = 0;
        int max = arr[n - 1];
        int sum = Integer.MIN_VALUE;
        int result = 0;

        while (min <= max) {
            int mid = (min + max) / 2;

            int total = check(arr, mid, m);
            if (total == -2){ // 예산보다 크게 나온 경우 end를 줄인다
                max = mid - 1;
            }else{
                if (sum < total) {
                    sum = total;
                    result = mid;
                }
                min = mid + 1;
            }
        }
        System.out.println(result);

    }
}

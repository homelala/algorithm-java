package backjune.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class backjune_가장긴증가하는부분수열1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] result = new int[n];
        result[0] = arr[0];
        int idx = 1;
        for (int i = 1; i < n; i++) {
            if (result[idx - 1] < arr[i]) {
                result[idx] = arr[i];
                idx++;
            } else if (result[idx - 1] > arr[i]) {
                int searchIdx = search(result, arr[i], idx);
                result[searchIdx] = arr[i];
            }
        }
        System.out.println(idx);
    }

    private static int search(int[] list, int key, int len) {
        int idx = 0;
        int min = 0, max = len - 1;

        while (min <= max) {
            int mid = (min + max) / 2;
            if (key > list[mid]) {
                min = mid + 1;
            } else {
                idx = mid;
                max = mid - 1;
            }
        }
        return idx;
    }
}

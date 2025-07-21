package backjune.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backjune_암기왕 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(st.nextToken());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr1 = new int[n];

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                arr1[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr1);

            st = new StringTokenizer(br.readLine(), " ");
            int m = Integer.parseInt(st.nextToken());
            int[] answer = new int[m];
            int[] arr2 = new int[m];

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < m; i++) {
                arr2[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < m; i++) {
                answer[i] = binarySearch(arr2[i], arr1, n);
            }

            for (int i : answer) {
                sb.append(i);
                sb.append("\n");
            }
        }
        System.out.println(sb);

    }

    private static int binarySearch(int key, int[] arr1, int n) {
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr1[mid] == key) {
                return 1;
            } else if (arr1[mid] > key) {
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return 0;
    }
}

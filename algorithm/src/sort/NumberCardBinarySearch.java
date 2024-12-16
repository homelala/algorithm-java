package sort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberCardBinarySearch {
    public int solutions(int[] arr1, int ch, int start, int end, int count) {
        return getUpperInx(arr1, ch, start, end, count) - getLowerInx(arr1, ch, start, end, count);
    }

    private static int getLowerInx(int[] arr1, int ch, int start, int end, int count) {
        while (start < end) {
            int mid = (start + end) / 2;

            if (arr1[mid] >= ch) {
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }

     private static int getUpperInx(int[] arr1, int ch, int start, int end, int count) {

        while (start < end) {
            int mid = (start + end) / 2;

            if (arr1[mid] > ch) {
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
         return start;
    }


    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr1 = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        Arrays.sort(arr1);
        for (int i = 0; i < m; i++) {
            int temp = Integer.parseInt(st.nextToken());
            bw.write(solutions(arr1, temp, 0, n - 1, 0)+ " ");
        }

        bw.flush();
        bw.close();
        br.close();

    }
}

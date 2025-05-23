package backjune.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjune_11004 {
    public static void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        System.out.println(getSortK(arr, k, n));
    }

    private static long getSortK(long[] arr, int k, int n) {
        long[] temp = new long[n];
        mergeSort(0, n - 1, arr, temp);
        return arr[k];
    }

    private static void mergeSort(int start, int end, long[] arr, long[] temp) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(start, mid, arr, temp);
            mergeSort(mid + 1, end, arr, temp);
            merge(arr, temp, start, mid, end);
        }
    }

    private static void merge(long[] arr, long[] temp, int start, int mid, int end) {
        for (int i = 0; i <= end; i++) {
            temp[i] = arr[i];
        }

        int part1 = start; //1번째 박스의 인덱스
        int part2 = mid + 1; //2번째 박스의 인덱스
        int index = start;

        while (part1 <= mid && part2 <= end) {
            if (temp[part1] <= temp[part2]) {
                arr[index] = temp[part1];
                part1++;
            }else{
                arr[index] = temp[part2];
                part2++;
            }
            index++;
        }

        // part1이 남아있을 경우
        for (int i = 0; i < mid - part1; i++) {
            arr[index + i] = temp[part1 + i];
        }
    }
}

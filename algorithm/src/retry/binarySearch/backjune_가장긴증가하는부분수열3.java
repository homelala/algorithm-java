package retry.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjune_가장긴증가하는부분수열3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        long[] arr = new long[n + 1];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        long[] result = new long[n + 1]; // 증가하는 부분수열을 담는 배열
        result[0] = arr[0];
        int idx = 1;// 다음 추가될 idx

        for (int i = 1; i < n; i++) {
            if (result[idx - 1] < arr[i]) { // 만일 result의 가장 큰 값보다 arr가 크다면
                result[idx] = arr[i];
                idx++;
            } else if (result[idx - 1] > arr[i]) {
                int searchIdx = search(result, arr[i], idx);
                result[searchIdx] = arr[i];
            }
        }

        System.out.println(idx);
    }

    private static int search(long[] result, long key, int idx) {
        int answer = 0;
        int min = 0;
        int max = idx;

        while (min <= max) {
            int mid = (min + max) / 2;
            if (result[mid] < key) {
                min = mid + 1;
            }else{
                answer = mid;
                max = mid - 1;
            }
        }

        return answer;
    }
}

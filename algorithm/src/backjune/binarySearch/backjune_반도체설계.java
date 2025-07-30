package backjune.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjune_반도체설계 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] list = new int[n];
        list[0] = arr[0];
        int idx = 1;
        for (int i = 1; i < n; i++) {
            if (list[idx - 1] < arr[i]) {
                list[idx] = arr[i];
                idx++;
            }else{
                int searchIdx = search(list, arr[i], idx);
                list[searchIdx] = arr[i];
            }
        }

        System.out.println(idx);
    }

    private static int search(int[] list, int key, int idx) {
        int i = 0;
        int min = 0;
        int max = idx - 1;

        while (min <= max) {
            int mid = (min + max) / 2;
            if (list[mid] < key) {
                min = mid + 1;
            }else{
                i = mid;
                max = mid - 1;
            }
        }

        return i;
    }
}

package sort;

import java.io.*;
import java.util.StringTokenizer;

// 퀵정렬
// 중요
// 다시 풀어보기
public class QuickSort4 {
    public void quicksort(int start, int end, int[] inputArr) {
        int partition = part(start, end, inputArr);

        if (partition > start + 1) {
            quicksort(start, partition - 1, inputArr);
        }
        if (partition < end) {
            quicksort(partition, end, inputArr);
        }
    }

    private int part(int start, int end, int[] inputArr) {
        int mid = (start + end) / 2;

        while (start <= end) {
            while(inputArr[start] < inputArr[mid]) start++;
            while(inputArr[end] > inputArr[mid]) end--;

            if (start <= end) {
                swap(inputArr, start, end);
                start++;
                end--;
            }
        }

        return start;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] inputArray = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            inputArray[i] = Integer.parseInt(st.nextToken());
        }
        quicksort(0, n - 1, inputArray);
        for (int i : inputArray) {
            bw.write(i + "");
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();

    }
}

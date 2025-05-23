package sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 퀵정렬
// 중요
// 다시 풀어보기
public class QuickSort {
    public static void quickSort(int[] inputArray, int start, int end) {
        int part = partition(start, end, inputArray);

        if (start < part - 1) {
            quickSort(inputArray, start, part - 1);
        }
        if (part < end) {
            quickSort(inputArray, part, end);
        }
    }

    public static int partition(int start, int end, int[] inputArray) {
        int mid = (start + end) / 2;
        int pivot = inputArray[mid];

        while (start <= end) {
            while(inputArray[start]<pivot) start++;
            while(inputArray[end]>pivot) end--;

            if (start <= end) {
                System.out.println(pivot+" " + Arrays.toString(inputArray));
                swap(inputArray, start, end);
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
        quickSort(inputArray, 0, n - 1);
        for (int i : inputArray) {
            bw.write(i + "");
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();

    }
}

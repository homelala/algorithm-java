package sort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 퀵정렬
/*
9
9
3
5
4
8
1
6
2
7
 */
public class QuickSort1 {
    public static void quickSort(int[] inputArray, int start, int end) {
        int part1 = partition(start, end, inputArray);

        if (start < part1 - 1) {
            quickSort(inputArray, start, part1 - 1);
        }

        if (end > part1) {
            quickSort(inputArray, part1, end);
        }
    }

    public static int partition(int start, int end, int[] inputArray) {
        int mid = (start + end) / 2;
        int pivot = inputArray[mid];

        while (start <= end) {
            while(inputArray[start] < pivot) start++;
            while(inputArray[end] > pivot) end--;

            if (start <= end) {
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

    public static void main(String[] args) throws IOException {
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

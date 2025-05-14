package sort;

import java.io.*;
import java.util.StringTokenizer;

// 퀵정렬
// 중요
// 다시 풀어보기
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

public class QuickSort7 {
    public void quicksort(int start, int end, int[] inputArr) {
        int partition = part(start, end, inputArr);

        if (start < partition - 1) { // 왼쪽 파티션의 값이 1개 이상 있을 경우
            quicksort(start, partition - 1, inputArr);
        }
        if (partition < end) {
            quicksort(partition, end, inputArr);
        }
    }

    private int part(int start, int end, int[] inputArr) {
        int mid = (start + end) / 2;
        int pivot = inputArr[mid]; //inputArray 값이 바뀔 수 있으므로 고정해놓고 비교해야한다

        while (start <= end) {
            while(inputArr[start] < pivot) start++;
            while(inputArr[end] > pivot) end--;

            if (start <= end) { //만일 start의 위치가 end보다 적다면
                swap(inputArr, start, end);
                start++; // 기존 값에서 벗어나기 위해
                end--; // 기존 값에서 벗어나기 위해
            }
        }

        return start; // pivot 보타 큰 그룹의 첫번 째 idx반환
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
            bw.write(i + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

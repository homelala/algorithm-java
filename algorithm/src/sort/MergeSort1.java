package sort;

import java.io.*;
import java.util.StringTokenizer;

// 병합정렬
// 중요
// 다시 풀어보기
public class MergeSort1 {
    public static void mergeSort(int start, int end, int[] inputArray, int[] temp) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(start, mid, inputArray, temp);
            mergeSort(mid + 1, end, inputArray, temp);
            merge(inputArray, temp, start, mid, end);
        }
    }

    public static void merge(int[] inputArray, int[] temp, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            temp[i] = inputArray[i];
        }

        int part1 = start; // 왼쪽 index
        int part2 = mid + 1;//오른쪽 index
        int index = start; //변경할 index

        while (part1 <= mid && part2 <= end) {
            if (temp[part1] < temp[part2]) {
                inputArray[index] = temp[part1];
                part1++;
            }else{
                inputArray[index] = temp[part2];
                part2++;
            }

            index++;
        }

        //왼쪽 파티션이 남아 있을 경우
        for (int i = 0; i <= mid - part1; i++) {
            inputArray[index + i] = temp[part1 + i];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] inputArray = new int[n];
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            inputArray[i] = Integer.parseInt(st.nextToken());
        }
        mergeSort(0, n - 1, inputArray, temp);
        for (int i : inputArray) {
            bw.write(i + "");
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();

    }
}

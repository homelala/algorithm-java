package sort;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class FindNumber {
    public static int partition(int start, int end, long[] inputArray) {
        int mid = (start + end) / 2;
        long pivot = inputArray[mid];

        while (start <= end) {
            // pivot보다 큰것을 선택
            while (inputArray[start] < pivot) start++;
            while (inputArray[end] > pivot) end--;
            if (start <= end) {
                long temp = inputArray[start];
                inputArray[start] = inputArray[end];
                inputArray[end] = temp;
                start++;
                end--;
            }
        }

        return start;
    }

    public static void quickSort(int start, int end, long[] inputArray) {
        int part = partition(start, end, inputArray);

        if (start < part - 1) {
            quickSort(start, part - 1, inputArray);
        }
        if (part < end) {
            quickSort(part, end, inputArray);
        }

    }

    public static int[] solution(long[] inputArray, long[] findArray) {
        int[] result = new int[findArray.length];
        quickSort(0, inputArray.length - 1, inputArray);

        for (int i = 0; i < findArray.length; i++) {
            int min = 0;
            int max = inputArray.length - 1;
            boolean flag = false;
            while (min <= max) {
                int mid = (min + max) / 2;
                if (inputArray[mid] == findArray[i]) {
                    flag = true;
                    break;
                } else if (inputArray[mid] > findArray[i]) {
                    max = mid - 1;
                }else{
                    min = mid + 1;
                }
            }

            if (flag) {
                result[i] = 1;
            }else{
                result[i] = 0;
            }
        }

        return result;
    }

    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long[] inputArray = new long[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            inputArray[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        long[] findArray = new long[m];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            findArray[i] = Integer.parseInt(st.nextToken());
        }

        for (int i : solution(inputArray, findArray)) {
            bw.write(i + "");
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();

    }
}

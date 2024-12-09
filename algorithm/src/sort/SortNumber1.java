package sort;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

// 2750 백준 수 정렬하기1
public class SortNumber1 {
    // 버블
    public static int[] Bubble(int n, int[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (inputArray[j] > inputArray[j + 1]) {
                    int temp = inputArray[j];
                    inputArray[j] = inputArray[j + 1];
                    inputArray[j + 1] = temp;
                }
            }
        }
        return inputArray;
    }

    // 선택
    public static int[] Selection(int n, int[] inputArray) {
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i; j < n; j++) {
                if (inputArray[minIndex] > inputArray[j]) {
                    int temp = inputArray[minIndex];
                    inputArray[minIndex] = inputArray[j];
                    inputArray[j] = temp;
                }
            }
        }
        return inputArray;
    }

    // 삽입
    public static int[] Insert(int n, int[] inputArray) {
        for (int i = 1; i < n; i++) {
            int temp = inputArray[i], j;
            for (j = i-1; j >=0; j--) {
                if (inputArray[j] > temp) {
                    inputArray[j + 1] = inputArray[j];
                }else{
                    break;
                }
            }
            inputArray[j + 1] = temp;
        }
        return inputArray;
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
        Insert(n, inputArray);
        for (int i : inputArray) {
            bw.write(i + "");
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();

    }
}

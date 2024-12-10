package Greedy;

import java.io.*;
import java.util.*;

// 백준 11399 ATM
public class Bank {

    public static int solution1(int n, int[] array) {
        int result=0;
        Arrays.sort(array);

        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = 0; j <= i; j++) {
                temp += array[j];
            }
            result += temp;
        }
        return result;
    }


    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] array = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution1(n, array));
    }
}

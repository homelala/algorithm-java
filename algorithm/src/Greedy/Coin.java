package Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 11407 동전0
public class Coin {

    public static int solution1(int n, int m, int[] array) {
        int result=0;

        for (int i = n-1; i >= 0; i--) {
            if (array[i] > m) {
                continue;
            }else{
                int temp = m / array[i];
                m -= array[i] * temp;
                result += temp;
            }
        }
        return result;
    }


    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            array[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution1(n, m, array));
    }
}

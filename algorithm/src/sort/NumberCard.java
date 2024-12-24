package sort;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//백준 숫자카드 10815
public class NumberCard {
    public static void binarySearch(int a, int[] inputArray, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;

            if (inputArray[mid] == a) {
                System.out.print(1 + " ");
                return;
            } else if (inputArray[mid] < a) {
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        System.out.print(0 + " ");
    }


    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] inputArrayA = new int[n];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            inputArrayA[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(inputArrayA);

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < m; i++) {
            int a = Integer.parseInt(st.nextToken());
            binarySearch(a, inputArrayA, 0, n - 1);
        }

        bw.flush();
        bw.close();
        br.close();

    }
}

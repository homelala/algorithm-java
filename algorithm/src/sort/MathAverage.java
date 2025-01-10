package sort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MathAverage {

    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        double sum = 0;
        int[] inputArray = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            sum += a;
            inputArray[i] = a;
        }
        Arrays.sort(inputArray);

        int max = inputArray[0];
        int count = 1;
        int maxCount = Integer.MIN_VALUE;
        boolean flag = false;

        for (int i = 0; i < n - 1; i++) {
            if (inputArray[i] == inputArray[i + 1]) {
                count++;
            } else {
                count = 1;
            }

            if (maxCount < count) {
                maxCount = count;
                max = inputArray[i];
                flag = true;
            } else if (maxCount == count && flag) {
                max = inputArray[i];
                flag = false;
            }
        }

        bw.write(Math.round(sum / n) + " ");
        bw.newLine();
        bw.write(inputArray[n / 2]+" ");
        bw.newLine();
        bw.write(max + " ");
        bw.newLine();
        bw.write(inputArray[n - 1] - inputArray[0] + " ");

        bw.flush();
        bw.close();
        br.close();

    }
}

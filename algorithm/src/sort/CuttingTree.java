package sort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CuttingTree {

    public static long cutTree(int m, long start, long end, long[] inputArrays) {
        long answer = Integer.MIN_VALUE;
        while (start <= end) {
            long result = 0;
            long mid = (start + end) / 2;

            for (long i : inputArrays) {
                if (i > mid) {
                    result += i - mid;
                }
            }

            if (result >= m) {
                answer = Math.max(answer, mid);
            }

            if (result >= m) {
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return answer;
    }

    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] inputArray = new long[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            inputArray[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(inputArray);
        bw.write(cutTree(m, 0, Arrays.stream(inputArray).max().getAsLong(), inputArray) + " ");
        bw.flush();
        bw.close();
        br.close();

    }
}

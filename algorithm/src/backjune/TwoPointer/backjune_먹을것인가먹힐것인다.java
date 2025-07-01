package backjune.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backjune_먹을것인가먹힐것인다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int answer = 0;
            int[] arrA = new int[a];
            int[] arrB = new int[b];

            st = new StringTokenizer(br.readLine(), " ");
            for (int x = 0; x < a; x++) {
                arrA[x] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine(), " ");
            for (int x = 0; x < b; x++) {
                arrB[x] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arrA);
            Arrays.sort(arrB);

            for (int j : arrA) {
                answer += search(j, arrB, 0, b - 1);
            }
            System.out.println(answer);
        }
    }

    private static int search(int j, int[] arrB, int start, int end) {
        int minIdx = -1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (j <= arrB[mid]) {
                end = mid - 1;
            } else {
                minIdx = Math.max(minIdx, mid);
                start = mid + 1;
            }
        }

        return minIdx + 1;
    }
}

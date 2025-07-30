package backjune.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backjune_개똥벌레 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] up = new int[n/2];
        int[] down = new int[n/2];

        int minBlock = Integer.MAX_VALUE;
        int count = 0;

        for (int i = 0; i < n/2; i++) {
            down[i] = Integer.parseInt(br.readLine());
            up[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(up);
        Arrays.sort(down);

        for (int i = 1; i <= h; i++) {
            int blockCount = countCrashBlock(i, down, n) + countCrashBlock(h - i + 1, up, n);
            if (minBlock > blockCount) {
                minBlock = blockCount;
                count = 1;
            } else if (minBlock == blockCount) {
                count++;
            }
        }

        System.out.println(minBlock + " " + count);
    }

    private static int countCrashBlock(int key, int[] arr, int n) {
        int min = 0;
        int max = n / 2 ;
        while (min < max) {
            int mid = (min + max) / 2;

            if (arr[mid] >= key) {
                max = mid;
            }else{
                min = mid + 1;
            }
        }

        return n / 2 - max;
    }

}

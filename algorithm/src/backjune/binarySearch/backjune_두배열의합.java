package backjune.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class backjune_두배열의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long answer = 0;
        long t = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }


        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int[] b = new int[m];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        List<Long> sumA = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += a[j];
                sumA.add(sum);
            }
        }
        Collections.sort(sumA);

        List<Long> sumB = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            long sum = 0;
            for (int j = i; j < m; j++) {
                sum += b[j];
                sumB.add(sum);
            }
        }
        Collections.sort(sumB);

        for (long i : sumA) {
            long key = t - i;
            int la = lower_search(key, sumB);
            int lb = upper_search(key, sumB);
            answer += (lb - la);
        }

        System.out.println(answer);
    }

    private static int lower_search(long key, List<Long> sumB) {
        int min = 0;
        int max = sumB.size();

        while (min < max) {
            int mid = (min + max) / 2;

            if (sumB.get(mid) < key) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        return min;
    }

    private static int upper_search(long key, List<Long> sumB) {
        int min = 0;
        int max = sumB.size();
        while (min < max) {
            int mid = (min + max) / 2;

            if (sumB.get(mid) <= key) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        return min;
    }
}

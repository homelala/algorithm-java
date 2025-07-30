package backjune.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class backjune_회전초밥 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        int[] eat = new int[d + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0, count = 0, kind = 0;
        int answer = 0;

        while (left < n || right < n) {
            if (count < k) {
                if (eat[arr[right % n]] == 0) {
                    kind++;
                }
                eat[arr[right % n]] += 1;
                right++;
                count++;
            } else if (count == k) {
                int total = eat[c] > 0 ? kind : kind + 1;
                answer = Math.max(answer, total);

                eat[arr[left % n]]--;
                if (eat[arr[left%n]] == 0) {
                    kind--;
                }
                left++;
                count--;
            }
        }
        System.out.println(answer);
    }
}

package backjune.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjune_귀여운라이언 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int answer = Integer.MAX_VALUE;
        int count = 0;

        while (left < n && right < n) {
            if (arr[right] == 1) {
                count++;
            }
            if (count == k) {
                answer = Math.min(answer, right - left + 1);
            } else if(count > k){
                while (true) {
                    if (count == k && arr[left] == 1) {
                        answer = Math.min(answer, right - left + 1);
                        break;
                    }
                    if (arr[left] == 1) count--;
                    left++;
                }
            }

            right++;
        }
        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }
    }
}

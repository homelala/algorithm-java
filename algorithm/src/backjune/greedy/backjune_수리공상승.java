package backjune.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjune_수리공상승 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        boolean[] arr = new boolean[1001];
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int answer = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            arr[a] = true;
        }

        for (int i = 1; i < 1001; i++) {
            if (arr[i]) {
                answer++;
                i += l - 1;
            }
        }

        System.out.println(answer);
    }
}

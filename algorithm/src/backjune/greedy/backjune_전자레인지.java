package backjune.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjune_전자레인지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] times = {300, 60, 10};
        int[] answer = new int[times.length];
        int n = Integer.parseInt(st.nextToken());

        if (n % 10 != 0) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < times.length; i++) {
                if (times[i] > n) continue;

                answer[i] = n / times[i];
                n -= answer[i] * times[i];
            }
            for (int a : answer) {
                System.out.print(a + " ");
            }
        }
    }
}

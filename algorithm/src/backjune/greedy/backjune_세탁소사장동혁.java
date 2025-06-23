package backjune.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjune_세탁소사장동혁 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] prices = {25, 10, 5, 1};

        for (int i = 0; i < n; i++) {
            int[] answer = new int[prices.length];
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());

            for (int j = 0; j < prices.length; j++) {
                answer[j] = cost / prices[j];
                cost -= prices[j] * answer[j];
            }

            for (int a : answer) {
                System.out.print(a + " ");
            }
        }
    }
}

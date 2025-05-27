package backjune.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjune_1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alpha = new int[26];
        String name = br.readLine();

        for (int i = 0; i < name.length(); i++) {
            alpha[name.charAt(i) - 'A']++;
        }
        int cnt = 0;
        for (int i : alpha) {
            if (i % 2 == 1) {
                cnt++;
            }
        }

        if (cnt > 1) {
            System.out.println("I'm Sorry Hansoo");
        }else{
            StringBuilder result = new StringBuilder();
            StringBuilder mid = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < alpha[i] / 2; j++) {
                    result.append((char) (i + 65));
                }

                if (alpha[i] % 2 == 1) {
                    mid.append((char) (i + 65));
                }
            }
            StringBuilder answer = new StringBuilder(result.toString());
            StringBuilder end = result.reverse();
            answer.append(mid).append(end);
            System.out.println(answer);
        }
    }
}

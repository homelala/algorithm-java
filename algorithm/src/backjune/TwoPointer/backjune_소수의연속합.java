package backjune.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class backjune_소수의연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        boolean[] prime = new boolean[n + 1];
        ArrayList<Integer> prime_numbers = new ArrayList<>();
        prime[0] = prime[1] = true;
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = true;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if(!prime[i]) prime_numbers.add(i);
        }

        int l = 0, r = 0, sum = 0, answer = 0;
        while (l <= r) {
            if (sum < n) {
                if (r == prime_numbers.size()) break;
                sum += prime_numbers.get(r);
                r++;
            } else {
                if (sum == n) {
                    answer++;
                    if(r==prime_numbers.size()) break;
                }

                sum -= prime_numbers.get(l);
                l++;
            }
        }

        System.out.println(answer);
    }
}

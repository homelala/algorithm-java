package backjune.TwoPointer;

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

        Collections.sort(sumA);
        Collections.sort(sumB);

        int left = 0;
        int right = sumB.size() - 1;

        while (left < sumA.size() && right > -1) {
            long avsum = sumA.get(left), bvsum = sumB.get(right);
            long sum = sumA.get(left) + sumB.get(right);

            if (sum == t) {
                long ac = 0, bc = 0;

                while (left < sumA.size() && sumA.get(left) == avsum) {
                    ac++;
                    left++;
                }

                while (right > -1 && sumB.get(right) == bvsum) {
                    bc++;
                    right--;
                }

                answer += (ac * bc);
            } else if (sum > t) {
                right--;
            }else{
                left++;
            }
        }

        System.out.println(answer);
    }

}

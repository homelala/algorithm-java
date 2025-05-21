package backjune.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class backjune_1049 {
    public static class Guitar{
        int all;
        int each;

        public Guitar(int all, int each) {
            this.all = all;
            this.each = each;
        }
    }
    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int minAll = Integer.MAX_VALUE;
        int minEach = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int all = Integer.parseInt(st.nextToken());
            int each = Integer.parseInt(st.nextToken());
            minAll = Math.min(all, minAll);
            minEach = Math.min(minEach, each);
        }

        if (n >= 6) {
            if (minAll < minEach * 6) {
                result += (minAll * (n / 6));
                n %= 6;
            }else{
                result += ((minEach *6) * (n / 6));
                n %= 6;
            }
        }

        if (n >= 1) {
            if (minAll > minEach*n) {
                result += (minEach*n);
            }else{
                result += minAll;
            }
        }

        System.out.println(result);
    }
}

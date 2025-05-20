package backjune.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backjune_1940 {
    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        int result = 0;
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int l = 0, r = arr.length - 1;
        Arrays.sort(arr);
        while (l < r) {
            if(arr[l]+arr[r] < m) l++;
            else if(arr[l]+arr[r] == m){
                l++;
                r--;
                result++;
            }else{
                r--;
            }
        }

        System.out.println(result);
    }
}

package backjune.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class backjune_겹치는건싫어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int answer = 0;
        int len = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (left < n && right < n) {
            if (map.getOrDefault(arr[right], 0) >= k) {
                answer = Math.max(answer, len);
                while (true) {
                    map.put(arr[left], map.get(arr[left]) - 1);
                    if(map.containsKey(arr[left]) && map.get(arr[left])==0) map.remove(arr[left]);
                    len--;

                    if (arr[left] == arr[right]){
                        left++;
                        break;
                    }
                    left++;
                }
            }
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            len++;
            right++;
        }
        answer = Math.max(answer, len);
        System.out.println(answer);
    }
}

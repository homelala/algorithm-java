package sort;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class NumberCardCountingSort {

    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (!map.containsKey(temp)) {
                map.put(temp, 1);
            } else {
                map.put(temp, map.get(temp) + 1);
            }
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (!map.containsKey(temp)) {
                bw.write(0 + " ");
            }else{
                bw.write(map.get(temp)+ " ");
            }
        }
        bw.flush();
        bw.close();
        br.close();

    }
}

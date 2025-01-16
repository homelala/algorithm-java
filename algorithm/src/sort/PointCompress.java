package sort;

import java.io.*;
import java.util.*;

public class PointCompress {

    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] inputArray = new int[n];
        int[] inputArray2 = new int[n];
        HashMap<Integer, Integer> maps =new HashMap<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            inputArray[i] = inputArray2[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(inputArray);

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!maps.containsKey(inputArray[i])) {
                maps.put(inputArray[i], count);
                count++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int value : inputArray2){
            sb.append(maps.get(value)).append(' ');
        }
        bw.write(String.valueOf(sb));

        bw.flush();
        bw.close();
        br.close();

    }
}

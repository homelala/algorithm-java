package backjune.implement;

import java.io.*;
import java.util.*;

public class backjune_20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> maps = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if(str.length() < m) continue;

            maps.put(str, maps.getOrDefault(str, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(maps.entrySet());

        list.sort((e1, e2) ->{
            int value = e2.getValue().compareTo(e1.getValue());
            if (value != 0) {
                return value;
            }else{
                int value2 = Integer.compare(e2.getKey().length(), e1.getKey().length());
//                return value2;
                if (value2 != 0) {
                    return value2;
                }else{
                    return e1.getKey().compareTo(e2.getKey());
                }
            }
        });

        for (Map.Entry e : list) {
            bw.write(e.getKey() + "");
            bw.newLine();
        }

        bw.flush();
    }
}

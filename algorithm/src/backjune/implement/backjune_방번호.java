package backjune.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class backjune_방번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String n = st.nextToken();

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i <= 9; i++) {
            map.put(i, 0);
        }

        for (char c : n.toCharArray()) {
            map.put(c - '0', map.getOrDefault(c - '0', 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        for (int key : map.keySet()) {
            if(key == 9 || key ==6) continue;
            max = Math.max(max, map.get(key));
        }

        max = Math.max(max, (map.get(6) + map.get(9) + 1) / 2);
        System.out.println(max);
    }
}

package backjune.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class backjune_덱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        ArrayDeque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String keyword = st.nextToken();
            if (keyword.equals("push_back")) {
                d.addLast(Integer.valueOf(st.nextToken()));
            } else if (keyword.equals("push_front")) {
                d.addFirst(Integer.valueOf(st.nextToken()));
            } else if (keyword.equals("pop_front")) {
                if(d.isEmpty()) System.out.println(-1);
                else System.out.println(d.pollFirst());
            } else if (keyword.equals("pop_back")) {
                if(d.isEmpty()) System.out.println(-1);
                else System.out.println(d.pollLast());
            } else if (keyword.equals("size")) {
                System.out.println(d.size());
            } else if (keyword.equals("front")) {
                if(d.isEmpty()) System.out.println(-1);
                else System.out.println(d.getFirst());
            } else if (keyword.equals("back")) {
                if(d.isEmpty()) System.out.println(-1);
                else System.out.println(d.getLast());
            } else if (keyword.equals("empty")) {
                if(d.isEmpty()) System.out.println(1);
                else System.out.println(0);
            }
        }
    }
}

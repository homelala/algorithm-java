package DFSBFS;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//백준 5014 스타트링크
public class StartLink {

    static int f,s,g,u, d;
    static int[] ch;
    static Queue<Integer> queue = new LinkedList<>();
    public static void solutions() {
        int answer = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int now = queue.poll();
                 if (now == g) {
                    System.out.println(answer);
                    return;
                }
                int up = now + u;
                int down = now - d;
                if (up <= f && ch[up] == 0) {
                    ch[up] = 1;
                    queue.add(up);
                }
                if (down >= 1 && ch[down] == 0) {
                    ch[down] = 1;
                    queue.add(down);
                }
            }
            answer++;
        }

        System.out.println("use the stairs");
    }

    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        ch = new int[f + 1];

        queue.offer(s);
        ch[s] = 1;
        solutions();
        bw.newLine();
        bw.flush();
        bw.close();
    }
}

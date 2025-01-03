package Greedy;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.System.in;

// 백준 16953 A -> B
public class AtoB {
    public static long solution1(long a, int b) {
        int answer = 0;
        Queue<Long> queue = new LinkedList<>();
        queue.add(a);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                long cur = queue.poll();

                if (cur == b) {
                    return answer + 1;
                }

                if (cur * 10 + 1 <= b) {
                    queue.add(cur * 10 + 1);
                }

                if (cur * 2 <= b) {
                    queue.add(cur * 2);
                }
            }
            answer++;
        }

        return -1;
    }


    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        bw.write(solution1(a, b)+"");
        bw.flush();
        bw.close();
        br.close();
    }
}

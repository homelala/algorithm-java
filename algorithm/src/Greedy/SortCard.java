package Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.System.in;

// 백준 1715
// 다시 풀어보기
public class SortCard {

    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static int solution1(int n) {
        int answer = 0;

        while (pq.size() != 1) {
            int a = pq.poll();
            int b = pq.poll();
            answer += a + b;
            pq.add(a + b);
        }
        return answer;
    }


    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(Integer.valueOf(st.nextToken()));
        }

        System.out.println(solution1(n));
    }
}

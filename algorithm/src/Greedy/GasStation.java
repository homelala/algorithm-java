package Greedy;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.System.in;

// 백준 주유소
public class GasStation {
    public static long solution1(int n) {
        long answer = 0;
        long minCost = Long.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            long curCost = cost.poll();
            minCost = Math.min(minCost, curCost);
            answer += dis[i] * minCost;
        }
        return answer;
    }

    static long[] dis;
    static Queue<Long> cost;

    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        dis = new long[n - 1];
        cost = new LinkedList<>();
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n - 1; i++) {
            dis[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n - 1; i++) {
            long temp = Long.parseLong(st.nextToken());
            cost.add(temp);
        }

        bw.write(solution1(n) + "");
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}

package DFSBFS;

import java.io.*;
import java.util.*;

//백준 9019 DSLR
//다시 풀어보기
public class DSLR {

    static int n;
    static int[][] arr;
    static ArrayList<String> answer;
    static Queue<Register> queue;
    static boolean[] visit;

    static class Register {
        int num;
        String command;

        Register(int num, String command) {
            this.num = num;
            this.command = command;
        }

        int D() {
            return (num * 2) % 10000;
        }

        int S() {
            return num == 0 ? 9999 : num - 1;
        }

        int L() {
            return num % 1000 * 10 + num / 1000;
        }

        int R() {
            return num % 10 * 1000 + num / 10;
        }
    }

    public static void solution1(int after) {
        while (true) {
            Register cur = queue.poll();

            if (cur.num == after) {
                answer.add(cur.command);
                break;
            }

            if (!visit[cur.D()]) {
                queue.add(new Register(cur.D(), cur.command + "D"));
                visit[cur.D()] = true;
            }
            if (!visit[cur.S()]) {
                queue.add(new Register(cur.S(), cur.command + "S"));
                visit[cur.S()] = true;
            }
            if (!visit[cur.L()]) {
                queue.add(new Register(cur.L(), cur.command + "L"));
                visit[cur.L()] = true;
            }
            if (!visit[cur.R()]) {
                queue.add(new Register(cur.R(), cur.command + "R"));
                visit[cur.R()] = true;
            }
        }
    }


    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = new ArrayList<>();

        for (int[] num : arr) {
            visit = new boolean[10000];
            queue = new LinkedList<>();
            visit[num[0]] = true;
            queue.offer(new Register(num[0], ""));
            solution1(num[1]);
        }

        for (String s : answer) {
            bw.write(s);
            bw.newLine();

        }
        bw.flush();
        bw.close();

    }
}

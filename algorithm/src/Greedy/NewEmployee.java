package Greedy;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.*;

import static java.lang.System.in;

// 백준 1946 신입사원
public class NewEmployee {
    public static class Scores implements Comparable<Scores>{
        int scoreA;
        int scoreB;

        public Scores(int scoreA, int scoreB) {
            this.scoreA = scoreA;
            this.scoreB = scoreB;
        }

        @Override
        public int compareTo(Scores o) {
            return this.scoreA - o.scoreA;
        }
    }

    public static int solution1(ArrayList<Scores> arr) {
        int answer = 1;
        int minScoreB = arr.get(0).scoreB;

        for (int i = 1; i < arr.size(); i++) {
            if (minScoreB > arr.get(i).scoreB) {
                answer++;
            }
            minScoreB = Math.min(minScoreB, arr.get(i).scoreB);
        }
        return answer;
    }


    public void main() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        for (int i = 0; i < a; i++) {
            ArrayList<Scores> arr = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());

            for (int j = 0; j < b; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr.add(new Scores(x, y));
            }
            Collections.sort(arr);

            bw.write(solution1(arr) + " ");
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

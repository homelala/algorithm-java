package programmers;

import java.util.Arrays;

public class backjune_요격시스템_1 {
    public static int solution(int[][] targets) {
        Arrays.sort(targets, (a,b)-> {
            if (a[0] != b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        int answer = 0;
        int max = 0;
        for (int i = 0; i < targets.length; i++) {
            if (max <= targets[i][0]) {
                max = targets[i][1];
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{4, 5}, {2, 3}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 10}}));
    }
}

package programmers;

import java.util.Arrays;

public class programmers_요격시스템 {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });
        int max = -1;
        for (int i = 0; i < targets.length; i++) {
            if (targets[i][0] >= max) {
                answer++;
                max = targets[i][1];
            }
        }
        System.out.println(answer);
        return answer;
    }
}

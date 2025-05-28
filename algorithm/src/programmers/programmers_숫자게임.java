package programmers;

import java.util.Arrays;

public class programmers_숫자게임 {
    int answer = 0;

    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int idx = 0;
        for (int i = 0; i < B.length; i++) {
            if (A[idx] < B[i]) {
                answer++;
                idx++;
            }
        }
        System.out.println(answer);
        return answer;
    }

//    private void getCase(int[] a, int[] b, int[] comb, int size, boolean[] visited) {
//        if (size == b.length) {
//            int win = 0;
//            for (int i = 0; i < a.length; i++) {
//                if (a[i] < b[i]) {
//                    win++;
//                }
//            }
//            answer = Math.max(answer, win);
//        }else{
//            for (int i = size; i < b.length; i++) {
//                if(visited[i]) continue;
//                comb[size] = i;
//                visited[i] = true;
//                getCase(a, b, comb, size + 1, visited);
//                visited[i] = false;
//            }
//        }
//    }
}

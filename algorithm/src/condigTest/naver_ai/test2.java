package condigTest.naver_ai;

import java.util.HashSet;
import java.util.Set;

public class test2 {
    public static int solution(int[] A, int K) {
        int N = A.length;
        int minChanges = K; // 최악의 경우: 모두 바꿔야 함

        for (int i = 0; i <= N - K; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < i + K; j++) {
                if (A[j] >= 1 && A[j] <= K) {
                    set.add(A[j]);
                }
            }
            int changes = K - set.size();
            minChanges = Math.min(minChanges, changes);
        }

        return minChanges;
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4,2,1,3}, 4));
        System.out.println(solution(new int[]{4,2,1,3}, 4));
        System.out.println(solution(new int[]{1, 3, 2}, 2));
        System.out.println(solution(new int[]{5, 4, 2, 3}, 3));
    }
}

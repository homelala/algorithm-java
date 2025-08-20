package condigTest.naver_ai;

import java.util.ArrayList;
import java.util.List;

class test3 {
    public int[] solution(int[] A) {
        int N = A.length;
        int MAX = 50000;

        // 약수 리스트 미리 계산
        List<Integer>[] divisors = new List[MAX + 1];
        for (int i = 1; i <= MAX; i++) divisors[i] = new ArrayList<>();
        for (int i = 1; i <= MAX; i++) {
            for (int j = i; j <= MAX; j += i) {
                divisors[j].add(i);
            }
        }

        int[] freq = new int[MAX + 1];
        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            int x = A[i];
            int count = 0;

            // x의 약수에 대해 이전 등장 횟수 합산
            for (int d : divisors[x]) {
                count += freq[d];
            }

            result[i] = count;

            // 현재 수 등장 기록
            freq[x]++;
        }

        return result;
    }
}

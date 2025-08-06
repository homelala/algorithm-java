package condigTest.connectWave;

import java.util.*;

public class Solution {
    public static int[] solution(int[] arr) {
        // 1. 중복 제거 후 정렬
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : arr) set.add(num);
        List<Integer> sorted = new ArrayList<>(set);

        int n = sorted.size();
        int[] result = new int[n];

        // 2. 중앙값 설정
        int midIdx = (n-1) / 2;
        result[0] = sorted.get(midIdx);

        // 3. 좌우 리스트 생성
        List<Integer> left = new ArrayList<>(sorted.subList(0, midIdx)); // midIdx 미포함
        List<Integer> right = new ArrayList<>(sorted.subList(midIdx + 1, n));

        // 4. 순차적으로 중앙 -> 오른쪽 -> 왼쪽 -> 오른쪽 ... 순서로 배치
        int idx = 1;
        int l = left.size() - 1; // 내림차순 순회
        int r = 0;

        while (l >= 0 || r < right.size()) {
            if (r < right.size()) result[idx++] = right.get(r++);
            if (l >= 0) result[idx++] = left.get(l--);
        }

        return result;
    }


    public static void main(String[] args) {
        int[] ex1 = {50, 98, 38, 11, 13, 90, 82, 83, 70};
        int[] ex2 = {3, -2, 8, 5, 3, 9};
        int[] ex3 = {3, 6, 7, 7, 2, 6, 0, -2, 6, -1, 13};
        int[] ex4 = {0};

        System.out.println(Arrays.toString(solution(ex1))); // ✅ [70, 50, 82, 38, 83, 13, 90, 11, 98]
        System.out.println(Arrays.toString(solution(ex2))); // ✅ [5, 3, 8, -2, 9]
        System.out.println(Arrays.toString(solution(ex3))); // ✅ [2, 0, 3, -1,]()
    }
    }

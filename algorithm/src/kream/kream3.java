package kream;

import java.util.*;

public class kream3 {
    public static int solution(int[] prices, int x, int p, int y) {
        /*
            특정 기준을 만족하면 경고하는 일 수구하기
            x일 연속 하락 or 상승
            최근 p 기간동안 y일 이상 연속 주가 상승 or 하락
         */
        int n = prices.length;
        Set<Integer> warningDays = new HashSet<>();

        // 조건 1: x일 연속 상승 or 하락
        int up = 0, down = 0;
        for (int i = 1; i < n; i++) { //처음은 비교 대상이 없기 때문에 skip
            if (prices[i] > prices[i - 1]) {
                up++;
                down = 0;
            } else if (prices[i] < prices[i - 1]) {
                down++;
                up = 0;
            } else {
                up = down = 0;
            }

            if (up >= x || down >= x) {
                warningDays.add(i + 1);
            }
        }

        // 조건 2: 최근 p일 중 y일 이상 상승/하락
        int[] upCount = new int[n];
        int[] downCount = new int[n];

        for (int i = 1; i < n; i++) {
            upCount[i] = upCount[i - 1]; // 이 전날의 연속 상승 저장
            downCount[i] = downCount[i - 1];

            if (prices[i] > prices[i - 1]) upCount[i]++;
            else if (prices[i] < prices[i - 1]) downCount[i]++;
        }

        for (int i = 1; i < n; i++) {
            // 지금까지의 상승 - start까지의 상승 = p 기간 동안의 상승
            int start = Math.max(1, i - p + 1);
            int ups = upCount[i] - upCount[start - 1];
            int downs = downCount[i] - downCount[start - 1];

            if (ups >= y || downs >= y) {
                warningDays.add(i + 1);
            }
        }

        return warningDays.size();
    }

    // 테스트용 main
    public static void main(String[] args) {
        System.out.println(solution(
                new int[]{8, 12, 14, 20, 20, 12, 12, 12, 14, 20, 20, 21, 23, 28, 4},
                3, 5, 4)); // 기대값: 3

        System.out.println(solution(
                new int[]{53, 52, 51, 52, 50, 49, 50, 51, 53, 55, 60, 61},
                4, 6, 4)); // 기대값: 6

        System.out.println(solution(
                new int[]{11, 11, 10, 10, 10, 9, 9, 10, 9, 10, 9, 10, 9},
                7, 10, 3)); // 기대값: 5
    }
}

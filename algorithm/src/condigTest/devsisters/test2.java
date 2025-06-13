package condigTest.devsisters;

import java.util.*;

public class test2 {
    public boolean solution(int capacity, int[][] routes) {
        List<int[]> deliveries = new ArrayList<>();

        for (int[] route : routes) {
            int giftNum = route[0];
            int from = route[1];
            int to = route[2];

            deliveries.add(new int[]{from, giftNum});    // 픽업
            deliveries.add(new int[]{to, -giftNum});     // 배달
        }

        // 지점 순으로 정렬
        deliveries.sort((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]); // 지점 기준 정렬
            return Integer.compare(a[1], b[1]); // 변화량 기준 정렬: delivery(-)가 먼저 오도록
        });

        int currentGiftCount = 0;

        for (int[] event : deliveries) {
            currentGiftCount += event[1];

            // capacity 초과하면 실패
            if (currentGiftCount > capacity) {
                System.out.println(false);
                return false;
            }
        }

        // 끝까지 초과하지 않으면 성공
        System.out.println(true);
        return true;
    }
}

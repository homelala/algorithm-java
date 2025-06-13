package condigTest.kream;

import java.util.*;

public class kream2 {
    public static int[] solution(int[][] usage, int[] temperatures) {
        /*
            temperatures의 온도에 대한 평균 값 구하기
            기록에 없으면 가장 가까운 온도
         */
        Map<Integer, List<Integer>> tempMap = new HashMap<>();

        for (int[] record : usage) {
            int temp = record[0];
            int power = record[1];
            tempMap.computeIfAbsent(temp, k -> new ArrayList<>()).add(power);
        }

        // 평균 값 계산
        Map<Integer, Integer> avgMap = new HashMap<>();
        for (int i : tempMap.keySet()) {
            int total = 0;
            for (int record : tempMap.get(i)) {
                total += record;
            }
            avgMap.put(i, total / tempMap.get(i).size());
        }
        for (Map.Entry<Integer, List<Integer>> entry : tempMap.entrySet()) {
            int sum = 0;
            for (int p : entry.getValue()) sum += p;
            avgMap.put(entry.getKey(), sum / entry.getValue().size());
        }
        
        int[] answer = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            int target = temperatures[i];

            if (avgMap.containsKey(target)) {
                // 기록에 값이 있을 경우
                answer[i] = avgMap.get(target);
            } else {
                // 없을 경우 가장 가까운 기록 검색
                int minDiff = Integer.MAX_VALUE;
                List<Integer> candidates = new ArrayList<>();


                //후보 기온의 온도 저장
                for (int recordedTemp : avgMap.keySet()) {
                    int diff = Math.abs(recordedTemp - target);
                    if (diff < minDiff) {
                        minDiff = diff;
                        candidates.clear();
                        candidates.add(recordedTemp);
                    } else if (diff == minDiff) {
                        candidates.add(recordedTemp);
                    }
                }

                // 후보 기온들의 평균 계산
                int totalSum = 0, count = 0;
                for (int cTemp : candidates) {
                    for (int p : tempMap.get(cTemp)) {
                        totalSum += p;
                        count++;
                    }
                }

                answer[i] = totalSum / count;
            }
        }

        return answer;
    }

    // 테스트
    public static void main(String[] args) {
        int[][] usage1 = {{1, 10}, {1, 12}, {3, 17}};
        int[] temperatures1 = {1, 2};
        System.out.println(Arrays.toString(solution(usage1, temperatures1))); // [11, 13]

        int[][] usage2 = {{54, 315}, {74, 116}, {54, 309}, {6, 168}, {74, 100}};
        int[] temperatures2 = {64, 73, 30};
        System.out.println(Arrays.toString(solution(usage2, temperatures2))); // [210, 108, 264]
    }
}

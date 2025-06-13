package condigTest.naver_cloud;

import java.util.HashMap;

public class test3 {
    public int solution(int[] A) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : A) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int key : map.keySet()) {
            if (key == map.get(key)) {
                answer = Math.max(answer, key);
            }
        }

        return answer;
    }
}

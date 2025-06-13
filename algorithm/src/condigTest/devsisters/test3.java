package condigTest.devsisters;

import java.util.*;

public class test3 {
    public int solution(String[] pouches) {
        int maxCount = 0;

        // a~e 별 선택
        for (int taste = 0; taste < 5; taste++) {
            List<int[]> pouchInfo = new ArrayList<>();

            // pouchInfo에 (선택한 값과 그외의 차이 개수, 선택한 값의 개수, 총 젤리 개수) 저장
            for (String pouch : pouches) {
                int tasteCount = 0;
                for (char c : pouch.toCharArray()) {
                    if (c - 'a' == taste) tasteCount++;
                }

                int totalCount = pouch.length();
                int diffCount = 2 * tasteCount - totalCount;
                pouchInfo.add(new int[]{diffCount, tasteCount, totalCount});
            }

            // score 기준 내림차순 정렬
            pouchInfo.sort((a, b) -> Integer.compare(b[0], a[0]));

            int selectCount = 0, others = 0, cnt = 0;

            for (int[] info : pouchInfo) {
                int tasteInPouch = info[1];
                int otherInPouch = info[2] - info[1];

                selectCount += tasteInPouch;
                others += otherInPouch;

                if (selectCount > others) {
                    cnt++;
                    maxCount = Math.max(maxCount, cnt);
                } else {
                    break;
                }
            }
        }

        return maxCount;
    }

}

package condigTest.kream;

import java.util.HashMap;
import java.util.Map;

public class kream1 {
    public static long solution(String[] arr1, String[] arr2) {
        /*
             두 배열의 문자열을 이어 붙여 올바른 괄호쌍이 되는 개수 구하기
         */
        Map<String, Long> map1 = new HashMap<>();
        Map<String, Long> map2 = new HashMap<>();

        // arr1 부족한 괄호 계산
        for (String s : arr1) {
            String key = getBalanceKey(s, false); // (로부터 시작하는지 검사
            if (key != null) {
                map1.put(key, map1.getOrDefault(key, 0L) + 1);
            }
        }

        // arr2 부족한 괄호 계산
        for (String s : arr2) {
            String key = getBalanceKey(s, false); //역순으로 하는 이유는 )로 시작하는지 검사하려고
            if (key != null) {
                map2.put(key, map2.getOrDefault(key, 0L) + 1);
            }
        }

        int count = 0;

        for (String key1 : map1.keySet()) {
            String[] split = key1.split(",");
            int open1 = Integer.parseInt(split[0]);
            int close1 = Integer.parseInt(split[1]);

            String key2 = close1 + "," + open1; // 반대쌍을 찾는다
            if (map2.containsKey(key2)) {
                count += map1.get(key1) * map2.get(key2);
            }
        }

        return count;
    }

    // 잔여 괄호 상태를 "open,close" 형태로 리턴
    private static String getBalanceKey(String s, boolean reversed) {
        int balance = 0;

        if (!reversed) {
            for (char c : s.toCharArray()) {
                if (c == '(') balance++;
                else balance--;

                if (balance < 0) return null; // )가 더 많을 경우 불가능
            }
            return balance + ",0";
        } else {
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == ')') balance++;
                else balance--;

                if (balance < 0) return null; // (가 더 많을 경우 불가능
            }
            return "0," + balance;
        }
    }

    public static void main(String[] args) {
        String[] arr1 = {"()", "(()", ")()", "()"};
        String[] arr2 = {")()", "()", "(()"};
        System.out.println(solution(arr1, arr2)); // 출력: 3

        String[] arr3 = {"(()"};
        String[] arr4 = {")()"};
        System.out.println(solution(arr3, arr4)); // 출력: 3
    }
}

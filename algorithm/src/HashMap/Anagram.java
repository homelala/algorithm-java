package HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class Anagram {
    public static String solution1(String inputStringA, String inputStringB) {
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        for (Character c : inputStringA.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        for (Character c : inputStringB.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) - 1);
        }
        for (int i : charCountMap.values()) {
            if (i != 0) {
                return "NO";
            }
        }

        return "YES";
    }

    public static String solution2(String inputStringA, String inputStringB) {
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        for (Character c : inputStringA.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        for (Character c : inputStringB.toCharArray()) {
            if (!charCountMap.containsKey(c) || charCountMap.get(c) == 0) {
                return "NO";
            }
            charCountMap.put(c, charCountMap.get(c) - 1);
        }

        return "YES";
    }

    public void main() {
        Scanner in=new Scanner(System.in);
        String inputStringA = in.next();
        String inputStringB = in.next();

        System.out.print(solution1(inputStringA, inputStringB));
    }
}

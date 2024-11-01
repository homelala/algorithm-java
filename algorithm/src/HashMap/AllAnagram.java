package HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class AllAnagram {
    public static int solution1(String s, String t) {
        int result = 0, lt = 0;
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        for (char c : t.toCharArray()) {
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }

        for (int rt = 0; rt < t.length() - 1; rt++) {
            tMap.put(s.charAt(rt), tMap.getOrDefault(s.charAt(rt), 0) + 1);
        }

        for (int rt = t.length() - 1; rt < s.length(); rt++) {
            tMap.put(s.charAt(rt), tMap.getOrDefault(s.charAt(rt), 0) + 1);
            if (sMap.equals(tMap)) {
                result++;
            }
            tMap.put(s.charAt(lt), tMap.getOrDefault(s.charAt(lt), 0) - 1);
            if (tMap.get(s.charAt(lt)) == 0) {
                tMap.remove(s.charAt(lt));
            }
            lt++;
        }
        return result;
    }


    public void main() {
        Scanner in=new Scanner(System.in);
        String s = in.next();
        String t = in.next();

        System.out.print(solution1(s, t));

    }
}

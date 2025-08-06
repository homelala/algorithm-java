import java.util.*;

public class KeyboardDistance {

    static Map<Character, int[]> keyPos = new HashMap<>();

    static {
        String[] rows = {"qwertyuio", "pasdfghjk", "lzxcvbnm"};
        for (int r = 0; r < rows.length; r++) {
            for (int c = 0; c < rows[r].length(); c++) {
                keyPos.put(rows[r].charAt(c), new int[]{r, c});
            }
        }
    }

    static int dist(char a, char b) {
        int[] p1 = keyPos.get(a);
        int[] p2 = keyPos.get(b);
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

    public static int solution(String s) {
        int sum = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // 인접한 문자만 거리 계산
                int localSum = 0;
                for (int k = i; k < j; k++) {
                    char c1 = s.charAt(k);
                    char c2 = s.charAt(k + 1);
                    localSum += dist(c1, c2);
                }
                sum += localSum;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println("abcc: " + solution("abcc"));    // ✅ 23
        System.out.println("tooth: " + solution("tooth"));  // ✅ 52
        System.out.println("zzz: " + solution("zzz"));      // ✅ 0
    }
}

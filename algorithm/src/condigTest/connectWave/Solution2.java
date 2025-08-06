package condigTest.connectWave;

public class Solution2 {
    public static int solution(int p, int index) {
        StringBuilder sb = new StringBuilder();
        int num = 0;

        // index는 1-based이므로 index보다 길어질 때까지 생성
        while (sb.length() < index) {
            sb.append(Integer.toString(num++, p));
        }

        // index는 1-based이므로 (index - 1)로 접근
        return Character.getNumericValue(sb.charAt(index - 1));
    }

    public static void main(String[] args) {
        System.out.println(solution(10, 15)); // 1
        System.out.println(solution(6, 20));  // 0
        System.out.println(solution(2, 16));  // 1
    }
}

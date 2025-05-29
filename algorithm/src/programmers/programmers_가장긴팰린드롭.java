package programmers;

public class programmers_가장긴팰린드롭 {
    public int solution(String s) {
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            // 홀수 길이 (중심이 i)
            maxLen = Math.max(maxLen, expand(s, i, i));
            // 짝수 길이 (중심이 i, i+1)
            maxLen = Math.max(maxLen, expand(s, i, i + 1));
        }
        return maxLen;
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}

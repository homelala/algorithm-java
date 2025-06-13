package condigTest.naver_cloud;

public class test2 {
    public int solution(String S) {
        int N = S.length();

        // 특정 길이의 접두사와 접미사가 같은지 비교
        for (int i = N - 1; i >= 1; i--) {
            if (S.substring(0, i).equals(S.substring(N - i, N))) {
                return i;
            }
        }

        return 0;
    }

}

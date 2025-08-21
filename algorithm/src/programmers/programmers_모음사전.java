package programmers;

public class programmers_모음사전 {
    static boolean flag = false;
    static char[] alpha = {'A', 'E', 'I', 'O', 'U'};
    static int c = 0;
    public static int solution(String word) {
        getCase(word, "");
        return c;
    }

    private static void getCase(String word, String s) {
        if(flag) return;
        if (s.equals(word)) {
            flag = true;
            return;
        }

        if (s.length() >= 5) {
            return;
        }
        for (int i = 0; i < 5; i++) {
            c++;
            getCase(word, s + alpha[i]);
        }
    }

    public static void main(String[] args) {
//        System.out.println(solution("AAAAE"));
//        System.out.println(solution("AAAE"));
        System.out.println(solution("I"));
        System.out.println(solution("EIO"));

    }
}

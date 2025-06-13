package condigTest.devsisters;

public class test1 {
    public int solution(int score) {
        int answer = 0;
        int[] costs = {100, 50, 5, 1};

        for (int cost : costs) {
            answer += score / cost;
            score %= cost;
        }
        System.out.println(answer);
        return answer;
    }
}

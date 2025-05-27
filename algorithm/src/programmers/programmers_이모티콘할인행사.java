package programmers;

public class programmers_이모티콘할인행사 {
    int[] answer = new int[2];
    int min = Integer.MAX_VALUE;
    boolean flag = false;
    public int[] solution(int[][] users, int[] emoticons) {

        for (int[] user : users) {
            min = Math.min(min, user[0]);
        }
        getCase(users, emoticons, 0, new int[emoticons.length]);
        System.out.println(answer[0] + " " + answer[1]);
        return answer;
    }

    private int[] getCase(int[][] users, int[] emoticons, int idx, int[] discounts) {
        int[] per = {10, 20, 30, 40};
        if (flag) {
            return discounts;
        }

        if (idx == emoticons.length) {
            int plus = 0;
            int cost = 0;
            for (int i = 0; i < users.length; i++) {
                int total = 0;
                for (int j = 0; j < emoticons.length; j++) {
                    if (discounts[j] >= users[i][0]) {
                        total += (emoticons[j] * ((100 - discounts[j]) * 0.01));
                    }
                }
                if (total >= users[i][1]) {
                    plus++;
                }else{
                    cost += total;
                }
            }
            if (answer[0] < plus) {
                if(plus == users.length) flag = true;

                answer[0] = plus;
                answer[1] = cost;
            } else if (answer[0] == plus) {
                if(plus == users.length) flag = true;

                answer[0] = plus;
                answer[1] = Math.max(answer[1], cost);
            }
        }else{
            for (int j = 0; j < 4; j++) {
                if(per[j] < min) continue;

                discounts[idx] = per[j];
                discounts = getCase(users, emoticons, idx + 1, discounts);
            }
        }
        return discounts;
    }
}

package programmers;

import java.util.Arrays;

public class backjune_이모티콘할인행사_1 {
    static int[] discounts = {10, 20, 30, 40};
    static int[] answer = new int[2];
    public static int[] solution(int[][] users, int[] emoticons) {
        getCase(emoticons, new int[emoticons.length], 0, users);

        System.out.println(answer[0] + " " + answer[1]);
        return answer;
    }

    private static void getCase(int[] emoticons, int[] discountArr, int len, int[][] users) {
        if (len == emoticons.length) {
            int totalUser = 0;
            int totalPrice = 0;
            for (int[] user : users) {
                int price = 0;
                for (int i = 0; i < emoticons.length; i++) {
                    if (discountArr[i] >= user[0]) {
                        price += (int) (emoticons[i] * ((100-discountArr[i])*0.01));
                    }
                }
                if (price >= user[1]) {
                    totalUser++;
                }else{
                    totalPrice += price;
                }
            }
            if (answer[0] < totalUser) {
                answer[0] = totalUser;
                answer[1] = totalPrice;
            } else if (answer[0] == totalUser && answer[1] < totalPrice) {
                answer[1] = totalPrice;
            }
        }else{
            for (int i = 0; i < 4; i++) {
                discountArr[len] = discounts[i];
                getCase(emoticons, discountArr, len + 1, users);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][]{{40, 10000}, {25, 10000}}, new int[]{7000, 9000})));
        System.out.println(Arrays.toString(solution(new int[][]{{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900},{40, 3100},{27, 9200},{32,6900}}, new int[]{1300, 1500, 1600, 4900})));

    }
}

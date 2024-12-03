package Greedy;

import java.util.*;

// 다시 풀어보기
public class MaxInputSchedule {
    static class Time implements Comparable<Time>{
        int time;
        int pay;

        public Time(int time, int pay) {
            this.time = time;
            this.pay = pay;
        }

        @Override
        public int compareTo(Time time) {
            if (this.time == time.time) {
                return time.pay - this.pay;
            }else{
                return time.time - this.time;
            }
        }
    }

    static PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
    static ArrayList<Time> arr = new ArrayList<>();
    static int max = 0;

    public static int solution1(int n) {
        int answer = 0;
        Collections.sort(arr);
        int j = 0;
        for (int i = max; i >= 1; i--) {
            for (; j < n; j++) {
                if (arr.get(j).time < i) {
                    break;
                }
                queue.add(arr.get(j).pay);
            }
            if (!queue.isEmpty()) {
                answer += queue.poll();
            }
        }
        return answer;
    }

    public void main() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            max = Math.max(max, b);
            arr.add(new Time(b, a));
        }
        System.out.println(solution1(n));
    }
}

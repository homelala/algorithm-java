package Greedy;

import java.util.*;

public class Marry {
    static class Time implements Comparable<Time>{
        int time;
        char status;

        public Time(int time, char status) {
            this.time = time;
            this.status = status;
        }

        @Override
        public int compareTo(Time time) {
            if (this.time == time.time) {
                return this.status - time.status;
            }else{
                return this.time - time.time;
            }
        }
    }

    static ArrayList<Time> map;
    public static int solution1(int n) {
        int answer = 0;
        int cnt = 0;
        Collections.sort(map);

        for (Time t: map) {
            if (t.status == 'e') {
                cnt--;
            }else if (t.status == 's') {
                cnt++;
                answer = Math.max(answer, cnt);
            }
        }
        return answer;
    }


    public void main() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            map.add(new Time(a, 's'));
            map.add(new Time(b, 'e'));
        }
        System.out.println(solution1(n));
    }
}

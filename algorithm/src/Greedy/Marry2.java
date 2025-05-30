package Greedy;

import java.util.*;

public class Marry2 {
    static class Time implements Comparable<Time>{
        int time;
        char status;

        public Time(int time, char status) {
            this.time = time;
            this.status = status;
        }

        @Override
        public int compareTo(Time o) {
            if (o.time == this.time) {
                return this.status - o.status;
            }
            return this.time - o.time;
        }
    }

    static ArrayList<Time> map;
    public static int solution1(int n) {
        Collections.sort(map);
        int answer = 0;
        Queue<Time> queue = new LinkedList<>();
        for (Time t : map) {
            if (t.status == 's') {
                queue.add(t);
            }else{
                queue.poll();
            }
            answer = Math.max(answer, queue.size());
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

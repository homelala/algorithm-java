package Greedy.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 다시 풀어보기
public class Cabinet {
    static class Time implements Comparable<Time>{
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time time) {
            if (this.end == time.end) {
                return this.start - time.start;
            }else{
                return this.end - time.end;
            }
        }
    }
    static ArrayList<Time> map;
    public static int solution1(int n) {
        int cnt = 0;
        int minEnd = Integer.MIN_VALUE;
        Collections.sort(map);

        for (Time t: map) {
            if (t.start >= minEnd) {
                cnt++;
                minEnd = t.end;
            }
        }
        return cnt;
    }


    public void main() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            map.add(new Time(a, b));
        }
        System.out.println(solution1(n));
    }
}

package Greedy;

import java.util.*;


// 다시 풀어보기
public class Cabinet2 {
    static class Scrum implements Comparable<Scrum>{
        int start;
        int end;

        public Scrum(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Scrum scrum) {
            if (this.end == scrum.end) {
                return this.start - scrum.start;
            }else{
                return this.end - scrum.end;
            }
        }
    }

    public static int solution1(int n) {
        int answer = 1;
        Scrum cur = array.get(0);
        for (int i = 1; i < n; i++) {
            if (array.get(i).start >= cur.end) {
                cur = array.get(i);
                answer++;
            }
        }
        return answer;
    }

    static ArrayList<Scrum> array;
    public void main() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        array = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            array.add(new Scrum(a, b));
        }
        Collections.sort(array);
        System.out.println(solution1(n));
    }
}

package Greedy.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 다시 풀어보기
public class Ssireum {
    static class Body implements Comparable<Body> {
        int height;
        int weight;

        public Body(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Body body) {
            return body.height - this.height;
        }
    }
    static ArrayList<Body> map;
    public static int solution1(int n) {
        int cnt = 0;
        Collections.sort(map);
        int max = Integer.MIN_VALUE;

        for (Body o : map) {
            if (o.weight > max) {
                cnt++;
                max = o.weight;
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
            map.add(new Body(a, b));
        }
        System.out.println(solution1(n));
    }
}

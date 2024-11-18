package Recursion;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Calf {
    public static int  solution1(int n, int m) {
        int answer = 0;
        int[] dis = {1, -1, 5};
        int[] ch = new int[10001];
        ch[n] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (cur == m) {
                    return answer;
                } else {
                    for (int j = 0; j < dis.length; j++) {
                        int nx = cur + dis[j];
//                        if (nx == m) {
//                            return answer+1;
//                        }
                        if (nx >= 0 && nx < 10001 && ch[nx] == 0) {
                            ch[nx] = 1;
                            queue.offer(nx);
                        }
                    }
                }
            }
            answer++;
        }
        return answer;
    }


    public void main() {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        System.out.println(solution1(n, m));

    }
}

package StackQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 다시 풀어보기
public class RescuePrincess {
    public static int solution1(int n, int k) {
        int cnt = 0, princeNum = 0;
        ArrayList<Integer> princes = new ArrayList<>();
        ArrayList<Integer> outPrinces = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            princes.add(i);
        }

        while (princes.size() != 1) {
            cnt++;
            if (cnt == k) {
                princes.remove(Integer.valueOf(princeNum));
                outPrinces.add(princeNum);
                cnt = 0;
            }
            if (outPrinces.contains((princeNum+1) % n)) {
                while (true) {
                    princeNum = (princeNum+1) % n;
                    if (!outPrinces.contains(princeNum % n)) break;
                }
            } else {
                princeNum = (princeNum +1) % n;
            }
        }

        return princes.get(0)+1;
    }

    public static int solution2(int n, int k) {
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        while (queue.size() != 1) {
            cnt++;
            if (cnt == k) {
                queue.poll();
                cnt = 0;
            }else{
                queue.offer(queue.poll());
            }
        }

        return queue.peek();
    }

    public void main() {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        System.out.println(solution2(n, k));
    }
}

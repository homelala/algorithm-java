package DP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BuildTop {
    public static class Brick implements Comparable<Brick>{
        int bottom;
        int height;
        int weight;

        public Brick(int bottom, int height, int weight) {
            this.bottom = bottom;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Brick o) {
            return o.bottom - this.bottom;
        }
    }

    static int[] dp;
    static ArrayList<Brick> arr =new ArrayList<>();

    public static int solution1(int n) {
        dp[0] = arr.get(0).height;
        int answer = dp[0];
        for (int i = 1; i < arr.size(); i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr.get(i).weight < arr.get(j).weight && dp[j] > max) {
                    max = dp[j];
                }
            }
            dp[i] = max + arr.get(i).height;
            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }

    public void main() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            arr.add(new Brick(a, b, c));
        }
        Collections.sort(arr);

        System.out.println(solution1(n));
    }
}

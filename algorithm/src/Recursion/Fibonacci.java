package Recursion;

import java.util.Scanner;

//다시 풀어보기
public class Fibonacci {
    static int[] fibo;

    public static int solution1(int n) {
        if (n == 1) {
            return fibo[n] = 1;
        } else if (n == 2) {
            return fibo[n] = 1;
        } else {
            return fibo[n] = solution1(n-2) + solution1(n - 1);
        }
    }

    public static int solution2(int n) {
        if(fibo[n] > 0 ) return fibo[n];
        if (n == 1) {
            return fibo[n] = 1;
        } else if (n == 2) {
            return fibo[n] = 1;
        } else {
            return fibo[n] = solution1(n-2) + solution1(n - 1);
        }
    }



    public void main() {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        fibo = new int[n + 1];
        solution1(n);
        for (int i = 1; i <= n; i++) {
            System.out.println(fibo[i] + " ");
        }
    }
}

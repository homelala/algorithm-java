package Recursion;

import java.util.Scanner;

public class Factorial {
    public static int solution1(int n) {
        if (n == 1) {
            return n;
        }

        return n*solution1(n-1);
    }



    public void main() {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(solution1(n));
    }
}

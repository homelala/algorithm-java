package Recursion;

import java.util.Scanner;

public class Binary {
        public static void solution1(int n) {
        if (n == 0) {
            return;
        }
        solution1(n/2);
        System.out.print(n%2);
    }



    public void main() {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        solution1(n);
    }
}
